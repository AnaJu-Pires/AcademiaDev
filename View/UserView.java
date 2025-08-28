package View;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Flow.Subscription;

import Controller.UserController;
import Controller.dto.StudentDto;


public class UserView {

    private final UserController userController;

    public UserView(UserController userController) {
        this.userController = userController;
    }

    public void newStudentRegistration(Scanner scanner) {
         System.out.println("Welcome to GymDev!");
        
        System.out.println("What is your name:");
        String name = scanner.next();
        
        System.out.println("What is your email:");
        String email = scanner.next();

        System.out.println("What is your subscription plan:");
        String subscriptionPlan = scanner.nextLine();
        //logica de subscriptionPlanTrabalhosa
        
        //StudentDto studentDto = new StudentDto(name, email, subscriptionPlan);
        //userController.createStudent(studentDto);
        System.out.println("Press Enter to return to the main menu...");
        scanner.nextLine();
    }
        
}
