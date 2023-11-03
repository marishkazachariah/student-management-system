import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.System.*;

public class CLI {
    public void runCLI() {
        Scanner scanner = new Scanner(in);
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int input = scanner.nextInt();
                switch (input) {
                    case 1 -> {
                        out.println("User Management!");
                        running = false;
                    }
                    case 2 -> {
                        out.println("Student Management!");
                        running = false;
                    }
                    case 3 -> {
                        out.println("Teacher Management!");
                        running = false;
                    }
                    case 4 -> {
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
        out.println("1. User Management");
        out.println("2. Student Management");
        out.println("3. Teacher Management");
        out.println("4. Quit Program");
    }
}
