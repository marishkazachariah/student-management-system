import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

public class CLI {
    public void runCLI() {
        Scanner scanner = new Scanner(in);
        boolean running = true;
        UserAuthentication userAuthentication = new UserAuthentication();

        while (running) {
            displayMenu();
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> {
                        userAuthentication.register();
                        running = false;
                    }
                    case 2 -> {
                        userAuthentication.login();
                        running = false;
                    }
                    case 3 -> {
                        out.println("Student Management!");
                        running = false;
                    }
                    case 4 -> {
                        out.println("Teacher Management!");
                        running = false;
                    }
                    case 5 -> {
                        out.println("Goodbye!");
                        running = false;
                    }
                    default -> out.println("Invalid choice. Choose another option.");
                }
            } catch (InputMismatchException e) {
                out.println("Invalid input. Choose another option.");
                scanner.next();
            }
        }

        scanner.close();
    }

    void displayMenu() {
        out.println("Main Menu");
        out.println("Choose from the following options:");
        out.println("1. Register");
        out.println("2. Login");
        out.println("3. Student Management");
        out.println("4. Teacher Management");
        out.println("5. Quit Program");
    }
}
