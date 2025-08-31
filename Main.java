
import Data.InitialData;
import Controller.AdminController;
import Controller.CourseController;
import Controller.StudentController;
import Repository.impl.AdminRepositoryImpl;
import Repository.impl.CourseRepositoryImpl;
import Repository.impl.EnrollmentRepositoryImpl;
import Repository.impl.StudentRepositoryImpl;
import Service.AdminService;
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
        StudentController studentController = new StudentController(studentService);

        EnrollmentRepositoryImpl enrollmentRepository = new EnrollmentRepositoryImpl();
        EnrollmentService enrollmentService = new EnrollmentService(enrollmentRepository, myRepository, enrollmentRepository);
        EnrollmentController enrollmentController = new EnrollmentController(enrollmentService);

        AdminRepositoryImpl adminRepository = new AdminRepositoryImpl();
        AdminService adminService = new AdminService(adminRepository);
        AdminController admController = new AdminController(adminService);


        InitialData data = new InitialData();
        data.addData(adminController, studentController, enrollmentController, admController);

        MainView view = new MainView(adminController, studentController, enrollmentController, admController);

        System.out.println("\t----- Welcome to AcademiaDev! -----\n");
        view.displayMenu();

    }
    
}
