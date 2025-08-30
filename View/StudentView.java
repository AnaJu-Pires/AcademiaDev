package View;

import java.util.List;
import java.util.Scanner;

import Controller.EnrollmentController;
import Controller.StudentController;
import Controller.dto.StudentDto;
import Controller.dto.CourseDto;
import Controller.dto.EnrollmentDto;
import Controller.CourseController;


public class StudentView {
    private final EnrollmentController enrollmentController;
    private final CourseController courseController;
    private final StudentController studentController;

    public StudentView(EnrollmentController enrollmentController, CourseController courseController, StudentController studentController) {
        this.enrollmentController = enrollmentController;
        this.courseController = courseController;
        this.studentController = studentController;
    }

    public void studentMenu(Scanner scanner, StudentDto studentDto) {
        while (true) {

        System.out.println("Choose an option:");
        System.out.println("1. Enroll in a course");
        System.out.println("2. View enrolled courses");
        System.out.println("3. View available courses");
        System.out.println("4. Exit");
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
                System.out.println("Goodbye! See you next time!");
                scanner.close();
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
