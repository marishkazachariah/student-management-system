import java.util.InputMismatchException;
import java.util.Scanner;
import static java.lang.System.out;

// Exercise 4
// unsure how else to do this other than creating user data
// separate to the User class
public class UserManager {
    private static final int MAX_USERS = 200;
    private String[] usernames = new String[MAX_USERS];
    private String[] passwords = new String[MAX_USERS];
    private int userCount = 0;
    private static final String USERS_NOT_FOUND = "No users found.";
    Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean shouldExit = false;

        while (!shouldExit) {
            out.println("Select an option (type in number value): ");
            out.println("1. Add User");
            out.println("2. Display Users");
            out.println("3. Edit User");
            out.println("4. Delete User");
            out.println("5. Exit");
            try {
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> addUser();
                    case 2 -> displayUsers();
                    case 3 -> editUsers();
                    case 4 -> deleteUser();
                    case 5 -> {
                        out.println("Exiting User Management System.");
                        shouldExit = true;
                    }
                    default -> out.println("Invalid option. Please select a valid option (1-5).");
                }
            } catch (InputMismatchException e) {
                out.println("Invalid input. Choose another option.");
                scanner.next();
            }
        }
    }

    void addUser() {
        if (userCount < MAX_USERS) {
            out.print("Enter new username: ");
            String username = scanner.next();
            out.print("Enter new password: ");
            String password = scanner.next();

            usernames[userCount] = username;
            passwords[userCount] = password;
            userCount++;

            out.println("User added successfully!");
        } else {
            out.println("User limit reached. Cannot add more users.");
        }
    }

    void displayUsers() {
        if (userCount > 0) {
            out.println("User List:");
            for (String username : usernames) {
                if (username != null) {
                    out.println("Username: " + username);
                }
            }
        } else {
            out.println(USERS_NOT_FOUND);
        }
    }

    void editUsers() {
        if (userCount > 0) {
            out.println("Enter the username you wish to edit: ");
            String userToEdit = scanner.next();
            boolean found = false;

            for (int i = 0; i < userCount; i++) {
                if (usernames[i].equals(userToEdit)) {
                    out.println("Choose from the following options:");
                    out.println("1. Edit Username");
                    out.println("2. Edit Password");

                    int inputChoice = scanner.nextInt();

                    if (inputChoice == 1) {
                        out.println("Type in new username: ");
                        usernames[i] = scanner.next();
                        found = true;
                        out.println("User updated successfully!");
                        run();
                    } else if (inputChoice == 2) {
                        out.print("Enter the new password: ");
                        passwords[i] = scanner.next();
                        found = true;
                        out.println("Password updated successfully!");
                        run();
                    }
                    break;
                }
            }

            if (!found) {
                out.println("User not found.");
                run();
            }
        } else {
            out.println(USERS_NOT_FOUND);
            run();
        }
    }

    void deleteUser() {
        if (userCount > 0) {
            out.println("Enter the username to delete: ");
            String searchUsername = scanner.next();

            boolean found = false;
            for (int i = 0; i < userCount; i++) {
                if (usernames[i].equals(searchUsername)) {
                    String[] newArray = new String[usernames.length - 1];
                    System.arraycopy(usernames, 0, newArray, 0, i);
                    System.arraycopy(usernames, i + 1, newArray, i, newArray.length - i);
                    usernames = newArray;

                    userCount--;
                    found = true;
                    out.println("User deleted successfully!");
                    break;
                }
            }

            if (!found) {
                out.println("User not found.");
            }
        } else {
            out.println(USERS_NOT_FOUND);
        }
    }
}
