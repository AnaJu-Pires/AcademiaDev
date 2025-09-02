package View;

import java.util.List;
import java.util.Scanner;

import Controller.EnrollmentController;
import Controller.StudentController;
import Controller.SupportTicketController;
import Controller.dto.StudentDto;
import Controller.dto.SupportTicketDto;
import Controller.dto.CourseDto;
import Controller.dto.EnrollmentDto;
import Controller.CourseController;


public class StudentView {
    private final EnrollmentController enrollmentController;
    private final CourseController courseController;
    private final StudentController studentController;
    private final SupportTicketController supportTicketController;

    public StudentView(EnrollmentController enrollmentController, CourseController courseController, StudentController studentController, SupportTicketController supportTicketController) {
        this.enrollmentController = enrollmentController;
        this.courseController = courseController;
        this.studentController = studentController;
        this.supportTicketController = supportTicketController;
    }

    public void studentMenu(Scanner scanner, StudentDto studentDto) {
        while (true) {

        System.out.println("Choose an option:");
        System.out.println("1. Enroll in a course");
        System.out.println("2. View enrolled courses");
        System.out.println("3. View available courses");
        System.out.println("4. Update progress");
        System.out.println("5. Cancel enrollment");
        System.out.println("6. Open support ticket");
        System.out.println("7. Return to main menu");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                System.out.println("Enter the course name:");
                String courseName = scanner.nextLine();
                enrollmentController.enrollInCourse(courseName, studentDto);
                break;
            case 2:
                List<EnrollmentDto> enrolledCourses = enrollmentController.viewEnrolledCourses(studentDto);
                System.out.println("\n\n\tEnrolled courses: ");
                for(EnrollmentDto enrolledCourse : enrolledCourses) {
                    System.out.println("Name: " + enrolledCourse.getCourseDto().getTitle() + " - Instructor: " + enrolledCourse.getCourseDto().getInstructorName() + " - Progress: " + enrolledCourse.getProgressDto() + "%");
                }
                System.out.println("\n\n");
                break;
            case 3:
                List<CourseDto> allCourses = courseController.showCoursesCatalog();
                System.out.println("\n\n\tAll Courses:\n");
                for(int i = 0; i < allCourses.size(); i++) {
                    if(allCourses.get(i).getStatus()){
                    System.out.print((i + 1) + ". " + allCourses.get(i).getTitle());
                    System.out.print(" - Duration: " + allCourses.get(i).getDurationInHours() + " hours");
                    System.out.println(" - Difficulty: " + allCourses.get(i).getDifficulty());      
                    }           
                }
                    System.out.println("----------------");
                System.out.println("\n\n");
                break;

            case 4:
                System.out.print("Enter the course name to update your progress: ");
                String courseNameToUpdate = scanner.nextLine();
                int currentProgress = enrollmentController.getCourseProgress(studentDto, courseNameToUpdate);
                if (currentProgress == -1) {
                    break;
                } else if (currentProgress == 100) {
                    System.out.println("You have already completed this course.");
                    break;
                }
                System.out.println("Your current progress: " + currentProgress + "%");
                System.out.print("Enter the new progress: ");
                int newProgress = scanner.nextInt();
                scanner.nextLine();
                if (newProgress < 0 || newProgress > 100) {
                    System.out.println("Update failed. Progress must be a value between 0 and 100.");
                    break;
                }
                enrollmentController.updateProgress(studentDto, courseNameToUpdate, newProgress);
                break;
            case 5:
                System.out.print("Enter the course name to cancel your enrollment: ");
                String courseNameToCancel = scanner.nextLine();
                enrollmentController.deleteEnrollment(studentDto, courseNameToCancel);
                break;
            case 6:
                SupportTicketDto supportTicketDto = new SupportTicketDto();
                System.out.println("What is the title of your support ticket?");
                supportTicketDto.setTitle(scanner.nextLine());
                System.out.println("What is your message?");
                supportTicketDto.setMessage(scanner.nextLine());
                supportTicketDto.setAuthor(studentDto);
                
                supportTicketController.saveSupportTicket(supportTicketDto);
                
                break;
            case 7:
                System.out.println("Returning to main menu...");
                return;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    }

    public void studentLogin(Scanner scanner) {
        System.out.println("Enter your email:");
        String email = scanner.nextLine();

        StudentDto existingStudent = studentController.loginStudent(email);
        if (existingStudent != null) {
            System.out.println("\nWelcome back, " + existingStudent.getName() + "!\n");
            studentMenu(scanner, existingStudent);
        } else {
            System.out.println("\nStudent with email '" + email + "' not found. Please register first in the main menu.\n");
            return;
        }

    }
    
}
