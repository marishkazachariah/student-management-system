import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserAuthentication {
    private List<User> users;
    private Scanner scanner;
    private CLI cli;

    public UserAuthentication() {
        users = new ArrayList<>();
        scanner = new Scanner(System.in);
        cli = new CLI();
    }

    public void register() {
        while (true) {
            System.out.println("Enter a username:");
            String username = scanner.next();
            boolean isUsernameTaken = false;

            for (User user : users) {
                if (user.getUsername().equals(username)) {
                    System.out.println("Username already exists. Please choose a different one.");
                    isUsernameTaken = true;
                    break;
                }
            }
            if (isUsernameTaken) {
                continue;
            }

            System.out.println("Enter a password:");
            String password = scanner.next();
            if (password.length() < 6) {
                System.out.println("Password is too short. Please type a password longer than 6 characters.");
                continue;
            }

            System.out.println("Select from the following roles:");
            for (UserRole role : UserRole.values()) {
                System.out.println(role.ordinal() + 1 + ". " + role.name());
            }
            int roleChoice = scanner.nextInt();
            if (roleChoice < 1 || roleChoice > UserRole.values().length) {
                System.out.println("Invalid role choice.");
                continue;
            }

            UserRole selectedRole = UserRole.values()[roleChoice - 1];

            User newUser = new User(username, password, selectedRole);
            newUser.setPassword(password);
            users.add(newUser);
            saveUserData(newUser);
            System.out.println("Registration successful.");
            break;
        }
        cli.runCLI();
    }

    public void login() {
        loadUserData();
        System.out.println("Enter your username: ");
        String username = scanner.next();
        System.out.println("Enter your password: ");
        String password = scanner.next();
        boolean loginSuccessful = false;

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                System.out.println("Login successful");
                System.out.println("ROLE: " + user.getRole());
                switch (user.getRole()) {
                    case ADMIN -> {
                        Admin admin = new Admin(user.getUsername(), user.getPassword());
                        admin.displayRoleSpecificMenu();
                    }
                    case STUDENT -> user.displayRoleSpecificMenu();
                    case TEACHER -> {
                        Teacher teacher = new Teacher(user.getUsername(), user.getPassword());
                        teacher.displayRoleSpecificMenu();
                    }
                }
                loginSuccessful = true;
                break;
            }
        }
        if (!loginSuccessful) {
            System.out.println("Login failed.");
            cli.runCLI();
        }
    }

    public void saveUserData(User user) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("user_data.txt", true))) {
            bufferedWriter.write(user.getUsername() + "," + user.getPassword() + "," + user.getRole().toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }

    public void loadUserData() {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("user_data.txt"))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] userData = line.split(",");
                if (userData.length == 3) {
                    String username = userData[0];
                    String password = userData[1];
                    UserRole role = UserRole.valueOf(userData[2]);
                    User user = new User(username, password, role);
                    users.add(user);
                } else {
                    System.err.println("Invalid user data");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error finding file: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error saving user data: " + e.getMessage());
        }
    }
}
