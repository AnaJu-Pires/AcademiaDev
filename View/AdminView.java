package View;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.ArrayList;

import Controller.AdminController;
import Controller.CourseController;
import Controller.EnrollmentController;
import Controller.StudentController;
import Controller.SupportTicketController;
import Model.Course.DifficultyLevel;
import Controller.dto.AdminDto;
import Controller.dto.CourseDto;
import Controller.dto.SupportTicketDto;





public class AdminView {
    private final CourseController courseController;
    private final AdminController adminController;
    private final SupportTicketController supportTicketController;
    private final EnrollmentController enrollmentController;
    private final StudentController studentController;

    public AdminView(CourseController courseController, AdminController adminController, SupportTicketController supportTicketController, EnrollmentController enrollmentController, StudentController studentController) {
        this.courseController = courseController;
        this.adminController = adminController;
        this.supportTicketController = supportTicketController;
        this.enrollmentController = enrollmentController;
        this.studentController = studentController;
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
        System.out.println("9. Change student subscription plan");
        System.out.println("0. Return to main menu");

       
        int choice = scanner.nextInt();
        scanner.nextLine(); 

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
                        System.out.println("\nThere are no more tickets to be resolved.\n");
                        break;
                    }
                    SupportTicketDto ticketToResolve = nextTicketOptional.get();
                    System.out.println("\n--- Next Ticket ---");
                    System.out.println("Author: " + ticketToResolve.getAuthor().getName());
                    System.out.println("Title: " + ticketToResolve.getTitle());
                    System.out.println("Message: " + ticketToResolve.getMessage());
                    System.out.println("-----------------------------\n");
                    System.out.print("What would you like to do? (1 - Resolve and show next, 2 - Return to menu): ");
                    
                    int action = scanner.nextInt();
                    scanner.nextLine();

                    if (action == 1) {
                        Optional<SupportTicketDto> resolvedTicketOptional = supportTicketController.resolveNextTicket();
                        if (resolvedTicketOptional.isPresent()) {
                            System.out.println("\nTicket successfully resolved!");
                        } else {
                            System.out.println("\nTicket could not be resolved.");
                        }
                    } else {
                        System.out.println("\nSomething went wrong, Returning to main menu.\n");
                        break;
                    }
                }
                break;
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
                System.out.println("Choose one to export:");
                System.out.println("1. All Courses");
                System.out.println("2. Enrolled Courses");
                System.out.println("3. Students");
                System.out.println("4. Admins");
                System.out.println("5. Support Tickets");
                int option = scanner.nextInt(); 
                int choose = 0;
                List<String> fieldsToInclude = new ArrayList<>();

                switch (option) {
                    case 1:
                        

                        while (true) {
                            System.out.println("Choose the fields to include:");
                            System.out.println("1. Title");
                            System.out.println("2. Description");
                            System.out.println("3. Instructor");
                            System.out.println("4. Duration");
                            System.out.println("5. Difficulty");
                            System.out.println("6. Status");
                            System.out.println("7. Submit");
                            System.out.print("8. Exit:\n");
                            
                            choose = scanner.nextInt(); 
                            scanner.nextLine();
                            if (choose == 1) {
                                fieldsToInclude.add("title");
                            } else if (choose == 2) {
                                fieldsToInclude.add("description");
                            } else if (choose == 3) {
                                fieldsToInclude.add("instructorName");
                            } else if (choose == 4) {
                                fieldsToInclude.add("durationHours");
                            } else if (choose == 5) {
                                fieldsToInclude.add("difficultyLevel");
                            } else if (choose == 6) {
                                fieldsToInclude.add("status");
                            } else if (choose == 7) {
                                courseController.exportAllCourses(fieldsToInclude);
                                break;
                            }else if(choose == 8){
                                break;
                            }
                        }

                        break;
                        case 2:
                            while(true){
                                System.out.println("Choose the fields to include:");
                                System.out.println("1. id");
                                System.out.println("2. Student");
                                System.out.println("3. Course");
                                System.out.println("4. Submit");
                                System.out.print("5. Exit:\n");
                                choose = scanner.nextInt(); 
                                scanner.nextLine();
                                if (choose == 1) {
                                    fieldsToInclude.add("id");
                                } else if (choose == 2) {
                                    fieldsToInclude.add("student");
                                } else if (choose == 3) {
                                    fieldsToInclude.add("course");
                                } else if (choose == 4) {
                                    enrollmentController.exportAllEnrollments(fieldsToInclude);
                                    break;
                                }else if(choose == 5){
                                    break;
                                }
                            }
                        break;
                        case 3:
                                while(true){
                                    System.out.println("Choose the fields to include:");
                                    System.out.println("1. Name");
                                    System.out.println("2. Email");
                                    System.out.println("3. Submit");
                                    System.out.print("4. Exit:\n");
                                    choose = scanner.nextInt(); 
                                    scanner.nextLine();
                                    if (choose == 1) {
                                        fieldsToInclude.add("name");
                                    } else if (choose == 2) {
                                        fieldsToInclude.add("email");
                                    } else if (choose == 3) {
                                        studentController.exportAllStudents(fieldsToInclude);
                                        break;
                                    }else if(choose == 4){
                                        break;
                                    }
                                }
                        break;
                        case 5:
                            while(true){
                                System.out.println("Choose the fields to include:");
                                System.out.println("1. title");
                                System.out.println("2. message");
                                System.out.println("3. author");
                                System.out.println("4. submit");
                                System.out.print("5. Exit:\n");
                                choose = scanner.nextInt(); 
                                scanner.nextLine();
                                if (choose == 1) {
                                    fieldsToInclude.add("title");
                                } else if (choose == 2) {
                                    fieldsToInclude.add("message");
                                } else if (choose == 3) {
                                    fieldsToInclude.add("author");
                                } else if (choose == 4) {
                                    supportTicketController.exportAllSupportTickets(fieldsToInclude);
                                    break;
                                }else if(choose == 5){
                                    break;
                                }
                            }
                        break;
                    default:
                        break;
                }
                
                
                
                
                break;
            case 9:
                int choice1 = 0;
                String chosen = null;
                System.out.println("Enter the email of the student whose subscription you want to change:");
                String studentEmail = scanner.nextLine();
                 while(true) {
                        System.out.println("\nChoose a plan:");
                        System.out.println("1. Basic");
                        System.out.println("2. Premium");
                        System.out.print("Enter your choice: ");

                        try {
                            choice1 = Integer.parseInt(scanner.nextLine());

                            if (choice1 == 1) {
                                chosen = "Basic";
                                break;
                            } else if (choice1 == 2) {
                                chosen = "Premium";
                                break;
                            } else {
                                System.out.println("Invalid choice.You have to choose a plan. Please enter 1 or 2.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input. Please enter a number.");
                        }
                    }
                studentController.changeSubscriptionPlan(studentEmail, chosen);
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
