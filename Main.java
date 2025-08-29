
import Data.InitialData;

import Controller.CourseController;
import Controller.StudentController;
import Repository.impl.CourseRepositoryImpl;
import Repository.impl.EnrollmentRepositoryImpl;
import Repository.impl.StudentRepositoryImpl;
import Service.CourseService;
import Service.EnrollmentService;
import Service.StudentService;
import View.MainView;

import Controller.EnrollmentController;

public class Main {
    public static void main(String[] args) {
        
        CourseRepositoryImpl myRepository = new CourseRepositoryImpl();  

        CourseService courseService = new CourseService(myRepository); 

        CourseController adminController = new CourseController(courseService);

        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();

        StudentService studentService = new StudentService(studentRepository);

        StudentController userController = new StudentController(studentService);

        EnrollmentRepositoryImpl enrollmentRepository = new EnrollmentRepositoryImpl();

        EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepository, myRepository);

        EnrollmentController enrollmentController = new EnrollmentController(enrollmentService);

        InitialData data = new InitialData();
        data.addData(adminController);

        MainView view = new MainView(adminController, userController, enrollmentController);

        System.out.println("\t----- Welcome to AcademiaDev! -----\n");
        view.displayMenu();

    }
    
}
