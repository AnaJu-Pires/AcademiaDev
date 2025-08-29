package View;

import Controller.AdminController;
import Controller.UserController;


import java.util.Scanner;

public class MainView {
    private final AdminController adminController;
    private final UserController userController;
    private final Scanner scanner;

    public MainView(AdminController adminController, UserController userController) {
        this.adminController = adminController;
        this.userController = userController;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        AdminView admin = new AdminView(adminController);
        UserView user = new UserView(userController);
        while (true) {

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