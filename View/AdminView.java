package View;

import Controller.AdminController;
import Model.Course.CourseList;




public class AdminView {
    private final AdminController adminController;

    public AdminView(AdminController adminController) {
        this.adminController = adminController;
    }

    public void showAdminMenu(CourseList courseList) {
        while(true) {
            System.out.println("1. Adicionar curso");
            System.out.println("2. Remover curso");
            System.out.println("3. Ver catálogo de cursos");
            System.out.println("4. Ver cursos inscritos");
            System.out.println("5. Ver tickets de suporte");
            System.out.println("0. Sair");
            int choice = Integer.parseInt(System.console().readLine());
            switch (choice) {
                case 1 -> adminController.addCourse(courseList);
              //  case 2 -> adminController.removeCourse();
                case 3 -> adminController.showCoursesCatalog(courseList);
              //  case 4 -> adminController.showEnrolledCourses();
              //  case 5 -> adminController.showSupportTickets();
                case 0 -> {
                    System.out.println("Saindo do menu de admin");
                    return;
                }
                default -> System.out.println("Opção inválida");
            }
        }
    }
}
