package View;

import Controller.AdminController;


import java.util.Scanner;

public class MainView {
    private final AdminController adminController;
    private final Scanner scanner;

    public MainView(AdminController adminController) {
        this.adminController = adminController;
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        AdminView admin = new AdminView(adminController);
        while (true) {
            System.out.println("1. Entrar como admin");
            System.out.println("0. Sair");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    admin.showAdminMenu();
                case 0:
                    System.out.println("Saindo do menu principal");

                    return;
                default:
                    System.out.println("Opcao invalida");
            }
        }
    }
    
}