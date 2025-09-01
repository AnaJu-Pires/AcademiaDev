package View;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import Controller.AdminController;
import Controller.CourseController;
import Controller.SupportTicketController;
import Model.Course.DifficultyLevel;
import Controller.dto.AdminDto;
import Controller.dto.CourseDto;
import Controller.dto.SupportTicketDto;





public class AdminView {
    private final CourseController courseController;
    private final AdminController adminController;
    private final SupportTicketController supportTicketController;

    public AdminView(CourseController courseController, AdminController adminController, SupportTicketController supportTicketController) {
        this.courseController = courseController;
        this.adminController = adminController;
        this.supportTicketController = supportTicketController;
    }

    public void showAdminMenu(Scanner scanner, AdminDto adminDto) {
    System.out.println("\t----- Admin Menu -----\n");
    while(true) {
        System.out.println("Choose an option:");
        System.out.println("1. Add course");
        System.out.println("2. Change course status");
        System.out.println("3. Open support ticket");
        System.out.println("4. Show courses catalog");
        System.out.println("5. Search course by name");
        System.out.println("6. Resolve support ticket");
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

                courseController.addCourse(courseDto);
                break;
            case 2:
                System.out.println("What is the course name: ");
                String courseNameD = scanner.next();
                CourseDto courseDtoD = courseController.changeStatusCourse(courseNameD);

                System.out.println(courseNameD + " status changed to: " + courseDtoD.getStatus());
                break;
            case 3:
                SupportTicketDto supportTicketDto = new SupportTicketDto();
                System.out.println("What is the title of your support ticket?");
                supportTicketDto.setTitle(scanner.nextLine());
                System.out.println("What is your message?");
                supportTicketDto.setMessage(scanner.nextLine());
                supportTicketDto.setAuthor(adminDto);
                supportTicketController.saveSupportTicket(supportTicketDto);
                break;
            case 4:
                System.out.print("\033[H\033[2J");
                List<CourseDto> courses = courseController.showCoursesCatalog();
                System.out.println("\n\n\tAvailable Courses:\n");
                for(int i = 0; i < courses.size(); i++) {
                    if(courses.get(i).getStatus() == true){

                    System.out.print((i + 1) + ". " + courses.get(i).getTitle());
                    System.out.print(" - Duration: " + courses.get(i).getDurationInHours() + " hours");
                    System.out.println(" - Difficulty: " + courses.get(i).getDifficulty());
                    
                    }
                    
                }
                    //System.out.println("----------------");
                    System.out.println("\n\n\tPress enter to return:\n");
                    scanner.nextLine();
                    
                    System.out.print("\033[H\033[2J");
                break;
            case 5:
                System.out.println("What is the course name: ");
                String courseName = scanner.next();
                CourseDto course = courseController.searchByName(courseName);
                
                System.out.print(course.getTitle());
                System.out.print(" - Description: " + course.getDescription());
                System.out.print(" - Instructor: " + course.getInstructorName());
                System.out.print(" - Duration: " + course.getDurationInHours() + " hours");
                System.out.print(" - Difficulty: " + course.getDifficulty()); 
                System.out.println(" - Availability: " + course.getStatus());
                break;
            case 6:
                while (true) {
                    Optional<SupportTicketDto> nextTicketOptional = supportTicketController.getNextTicket();

                    if (nextTicketOptional.isEmpty()) {
                        System.out.println("\nFila de suporte vazia. Todos os tickets foram resolvidos!\n");
                    }
                    SupportTicketDto ticketToResolve = nextTicketOptional.get();
                    System.out.println("\n--- Próximo Ticket na Fila ---");
                    System.out.println("Autor: " + ticketToResolve.getAuthor().getName());
                    System.out.println("Título: " + ticketToResolve.getTitle());
                    System.out.println("Mensagem: " + ticketToResolve.getMessage());
                    System.out.println("-----------------------------\n");
                    System.out.print("O que deseja fazer? (1 - Resolver e Ver Próximo, 0 - Voltar ao Menu): ");
                    
                    int action = scanner.nextInt();
                    scanner.nextLine();

                    if (action == 1) {
                        Optional<SupportTicketDto> resolvedTicketOptional = supportTicketController.resolveNextTicket();
                        if (resolvedTicketOptional.isPresent()) {
                            System.out.println("\nO Ticket foi resolvido com sucesso!");
                        } else {
                            System.out.println("\nOcorreu um erro ao tentar resolver o ticket.");
                        }
                    } else {
                        System.out.println("\nOperação cancelada. Voltando ao menu principal.\n");
                        break;
                    }
                }
            case 7:
                List<CourseDto> allCourses = courseController.showCoursesCatalog();
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
    }

}

    public void adminLogin(Scanner scanner) {
        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        AdminDto existingAdmin = adminController.loginAdmin(email);
        if (existingAdmin != null) {
            System.out.println("\nWelcome back, " + existingAdmin.getName() + "!\n");
            showAdminMenu(scanner, existingAdmin);
        } else {
            System.out.println("\nAdmin with email '" + email + "' not found. Please register first in the main menu.\n");
            return;
        }
    }
}
