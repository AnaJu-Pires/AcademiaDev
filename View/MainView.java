package View;

import Controller.CourseController;
import Controller.StudentController;
import Controller.dto.StudentDto;
import Model.Policy.BasicPlan;
import Model.Policy.SubscriptionPlan;
import Model.User.Student;
import Controller.EnrollmentController;


import java.util.Scanner;

public class MainView {
    private final CourseController adminController;
    private final StudentController userController;
    private final EnrollmentController enrollmentController;
    private final Scanner scanner;

    public MainView(CourseController adminController, StudentController userController, EnrollmentController enrollmentController) {
        this.adminController = adminController;
        this.userController = userController;
        this.enrollmentController = enrollmentController;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        AdminView admin = new AdminView(adminController);
        UserView user = new UserView(userController);
        StudentView student = new StudentView(enrollmentController);


        while (true) {
            StudentDto studentDto = new StudentDto("John Doe", "john@example.com", "Basic"); //isso a gente vai pegar no login
            System.out.println("Choose an option:");
            System.out.println("1. Student Menu");
            System.out.println("2. Admin Menu");
            System.out.println("3. Register");
            //ver catalogo de curso ?
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    student.studentMenu(this.scanner, studentDto);
                    break;
                case 2:
                    admin.showAdminMenu(this.scanner);
                    break;
                case 3:
                    user.newStudentRegistration(this.scanner);
                    break;
                case 0:
                    System.out.println("Goodbye! See you next time!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
    
}