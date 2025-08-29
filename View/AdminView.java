package View;

import java.util.List;
import java.util.Scanner;

import Controller.AdminController;
import Model.Course.DifficultyLevel;

import Controller.dto.CourseDto;





public class AdminView {
    private final AdminController adminController;

    public AdminView(AdminController adminController) {
        this.adminController = adminController;
    }

    public void showAdminMenu(Scanner scanner) {
    System.out.println("\t----- Admin Menu -----\n");
    while(true) {
        System.out.println("Choose an option:");
        System.out.println("1. Add course");
        System.out.println("2. Change course status");
       // System.out.println("3. Editar curso");
        System.out.println("4. Show courses catalog");
        System.out.println("5. Search course by name");
        System.out.println("6. Atender ticket de suporte");
        System.out.println("7. Show all courses(active and inactive)");
        System.out.println("8. Exportar dados para CSV");
        System.out.println("0. Return to main menu");

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

                CourseDto courseDto = new CourseDto(CouseName, CouseDescription, CouseInstructorName, CouseDurationInHours, difficultyLevel, true);

                adminController.addCourse(courseDto);
                break;
            case 2:
                System.out.println("What is the course name: ");
                String courseNameD = scanner.next();
                CourseDto courseDtoD = adminController.changeStatusCourse(courseNameD);

                System.out.println(courseNameD + " status changed to: " + courseDtoD.getStatus());
                break;
            case 3:
                

                break;
            case 4:
                List<CourseDto> courses = adminController.showCoursesCatalog();
                System.out.println("\n\n\tAvailable Courses:\n");
                for(int i = 0; i < courses.size(); i++) {
                    if(courses.get(i).getStatus() == true){

                    System.out.print((i + 1) + ". " + courses.get(i).getTitle());
                    System.out.print(" - Duration: " + courses.get(i).getDurationInHours() + " hours");
                    System.out.println(" - Difficulty: " + courses.get(i).getDifficulty());
                    
                    }
                    
                }
                    System.out.println("----------------");
                break;
            case 5:
                System.out.println("What is the course name: ");
                String courseName = scanner.next();
                CourseDto course = adminController.searchByName(courseName);
                
                System.out.print(course.getTitle());
                System.out.print(" - Description: " + course.getDescription());
                System.out.print(" - Instructor: " + course.getInstructorName());
                System.out.print(" - Duration: " + course.getDurationInHours() + " hours");
                System.out.print(" - Difficulty: " + course.getDifficulty()); 
                System.out.println(" - Availability: " + course.getStatus());

                
                break;
            case 6:
                // adminController.attendSupportTicket();
                break;
            case 7:
                List<CourseDto> allCourses = adminController.showCoursesCatalog();
                System.out.println("\n\n\tAll Courses:\n");
                for(int i = 0; i < allCourses.size(); i++) {
                    System.out.print((i + 1) + ". " + allCourses.get(i).getTitle());
                    System.out.print(" - Duration: " + allCourses.get(i).getDurationInHours() + " hours");
                    System.out.print(" - Difficulty: " + allCourses.get(i).getDifficulty()); 
                    System.out.println(" - Availability: " + allCourses.get(i).getStatus());                 
                }
                    System.out.println("----------------");
                break;
            case 8:
                // adminController.exportToCSV();
                break;
            case 0:
                System.out.println("Returning to main menu...");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        // CORREÇÃO 2: Removido o scanner.close() de dentro do loop
    }
}
}
