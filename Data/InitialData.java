package Data;

import Controller.CourseController;
import Controller.dto.AdminDto;
import Controller.dto.CourseDto;
import Controller.dto.StudentDto;
import Controller.EnrollmentController;
import Controller.StudentController;
import Controller.AdminController;
import Model.Course.DifficultyLevel;    

public class InitialData {
    public  void addData(CourseController courseController, StudentController studentController, EnrollmentController enrollmentController, AdminController AdminController) {

        System.out.println("Adding initial data...\n");

        AdminDto adminDto = new AdminDto("Admin", "admin@email.com");
        AdminController.addAdmin(adminDto);
        AdminDto adminDto2 = new AdminDto("Admin2", "admin2@email.com");
        AdminController.addAdmin(adminDto2);

        CourseDto course1 = new CourseDto("Java Fundamentals", "Learn the basics of the Java language and OOP", "Daniel", 12, DifficultyLevel.BEGINNER, true);
        courseController.addCourse(course1);
        CourseDto course2 = new CourseDto("Essential Spring Boot", "Quickly create REST APIs with Spring Boot", "Maria", 20, DifficultyLevel.INTERMEDIATE, true);
        courseController.addCourse(course2);
        CourseDto course3 = new CourseDto("JPA and Hibernate", "High-performance data persistence with Hibernate", "Carlos", 18, DifficultyLevel.ADVANCED, true);
        courseController.addCourse(course3);
        CourseDto course4 = new CourseDto("Testing with JUnit 5 & Mockito", "Ensure your code's quality with unit tests", "Maria", 15, DifficultyLevel.INTERMEDIATE, true);
        courseController.addCourse(course4);
        CourseDto course5 = new CourseDto("Introduction to SQL", "Manipulate and query relational databases", "Daniel", 10, DifficultyLevel.BEGINNER, true);
        courseController.addCourse(course5);
        CourseDto course6 = new CourseDto("Docker for Developers", "Create and manage containers for your applications", "Ana", 16, DifficultyLevel.INTERMEDIATE, true);
        courseController.addCourse(course6);
        CourseDto course7 = new CourseDto("Microservices Architecture", "Learn the patterns and challenges of microservices", "Carlos", 25, DifficultyLevel.ADVANCED, true);
        courseController.addCourse(course7);
        CourseDto course8 = new CourseDto("Essential Git and GitHub", "Code versioning for beginners", "Daniel", 8, DifficultyLevel.BEGINNER, true);
        courseController.addCourse(course8);
        CourseDto course9 = new CourseDto("Spring Security", "Secure your applications with the Spring security framework", "Ana", 22, DifficultyLevel.ADVANCED, false);
        courseController.addCourse(course9);
        CourseDto course10 = new CourseDto("Angular for Beginners", "Build reactive front-end applications with Angular", "Beatriz", 20, DifficultyLevel.BEGINNER, true);
        courseController.addCourse(course10);

        StudentDto student1 = new StudentDto("João", "joao@email.com", "Premium");
        studentController.createStudent(student1);
        StudentDto student2 = new StudentDto("Maria", "maria@email.com", "Basic");
        studentController.createStudent(student2);
        StudentDto student3 = new StudentDto("Bob", "bob@email.com", "Premium");
        studentController.createStudent(student3);
        StudentDto student4 = new StudentDto("Ana Julia", "anaju@email.com", "Basic");
        studentController.createStudent(student4);
        StudentDto student5 = new StudentDto("Gabriel", "gabriel@email.com", "Premium");
        studentController.createStudent(student5);
        StudentDto student6 = new StudentDto("Beatriz", "beatriz@email.com", "Basic");
        studentController.createStudent(student6);

        enrollmentController.enrollInCourse(course1.getTitle(), student1);
        enrollmentController.enrollInCourse(course2.getTitle(), student2);
        enrollmentController.enrollInCourse(course3.getTitle(), student3);
        enrollmentController.enrollInCourse(course4.getTitle(), student4);
        enrollmentController.enrollInCourse(course5.getTitle(), student5);
        enrollmentController.enrollInCourse(course6.getTitle(), student6);
        enrollmentController.enrollInCourse(course7.getTitle(), student1);
        enrollmentController.enrollInCourse(course8.getTitle(), student2);
        enrollmentController.enrollInCourse(course9.getTitle(), student3);
        enrollmentController.enrollInCourse(course10.getTitle(), student4);
        enrollmentController.enrollInCourse(course1.getTitle(), student5);
        enrollmentController.enrollInCourse(course2.getTitle(), student6);

        System.out.println("\nInitial data added successfully!\n");
        

    }
}
