package View;

import java.util.Scanner;

import Controller.AdminController;
import Model.Course.DifficultyLevel;





public class AdminView {
    private final AdminController adminController;

    public AdminView(AdminController adminController) {
        this.adminController = adminController;
    }

    public void showAdminMenu() {
    Scanner scanner = new Scanner(System.in);
    while(true) {
        System.out.println("1. Adicionar curso");
        System.out.println("2. Remover curso");
        System.out.println("3. Ver catálogo de cursos");
        System.out.println("4. Ver cursos inscritos");
        System.out.println("5. Ver tickets de suporte");
        System.out.println("0. Sair");

        // CORREÇÃO 3: Usando o scanner para ler a opção do menu
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consome a "nova linha" deixada pelo nextInt()

        switch (choice) {
            case 1:
                System.out.println("What is the course name: ");
                String CouseName = scanner.nextLine();
                System.out.println("What is the course description: ");
                String CouseDescription = scanner.nextLine();
                System.out.println("What is the course instructor name: ");
                String CouseInstructorName = scanner.nextLine();

                System.out.println("What is the course duration in hours: ");
                int CouseDurationInHours = scanner.nextInt();
                
                // CORREÇÃO 1: Consome a "nova linha" deixada pelo nextInt() anterior
                scanner.nextLine(); 

                System.out.println("What is the course difficulty level: (BEGINNER, INTERMEDIATE, ADVANCED): ");
                String CouseDifficultyLevel = scanner.nextLine();
                DifficultyLevel difficultyLevel = DifficultyLevel.valueOf(CouseDifficultyLevel.toUpperCase());

                adminController.addCourse(CouseName, CouseDescription, CouseInstructorName, CouseDurationInHours, difficultyLevel);
                break;
            case 2:
                System.out.println("What is the course name: ");
                // String courseName = scanner.next();
                // adminController.removeCourse(courseName);
                break;
            case 3:
                // adminController.showCoursesCatalog(courseList);
                break;
            case 4:
                // adminController.showEnrolledCourses();
                break;
            case 5:
                // adminController.showSupportTickets();
                break;
            case 0:
                System.out.println("Saindo do menu de admin");
                scanner.close(); // Feche o scanner aqui, ao sair
                return;
            default:
                System.out.println("Opcao invalida");
        }
        // CORREÇÃO 2: Removido o scanner.close() de dentro do loop
    }
}
}
