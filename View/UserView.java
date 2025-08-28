package View;
import java.util.Scanner;

import Controller.UserController;
import Controller.dto.StudentDto;


public class UserView {

    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void newStudentRegistration(Scanner scanner) {
        System.out.println("\t----- Student Registration -----\n");
    
        System.out.println("What is your name:");
        String name = scanner.nextLine();
        
        System.out.println("What is your email:");
        String email = scanner.nextLine();

        String chosen = null;

        while(true) {
            System.out.println("\nChoose a plan:");
            System.out.println("1. Basic");
            System.out.println("2. Premium");
            System.out.print("Enter your choice: ");

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 1) {
                    chosen = "Basic";
                    break;
                } else if (choice == 2) {
                    chosen = "Premium";
                    break;
                } else {
                    System.out.println("❌ Invalid choice.You have to choose a plan. Please enter 1 or 2.");
                }
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
            }
        }

        System.out.println("\nYou selected the " + chosen + " plan.");
        
        StudentDto studentDto = new StudentDto(name, email, chosen);
        userController.createStudent(studentDto);
        System.out.println("Press Enter to return to the main menu.");
        scanner.nextLine();
    }




        
}
