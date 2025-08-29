
import Data.InitialData;

import Controller.AdminController;
import Controller.UserController;
import Repository.impl.CourseRepositoryImpl;
import Repository.impl.StudentRepositoryImpl;
import Service.CourseService;
import Service.StudentService;
import View.MainView;

public class Main {
    public static void main(String[] args) {
        //vou tentar explicar aqui pra eu nao esquecer e vc tentar entender 
        CourseRepositoryImpl myRepository = new CourseRepositoryImpl();  //Cria a lista pra salvar os cursos (ja coloquei alguns apenas de teste la)

        CourseService courseService = new CourseService(myRepository); 

        AdminController adminController = new AdminController(courseService);

        StudentRepositoryImpl studentRepository = new StudentRepositoryImpl();

        StudentService studentService = new StudentService(studentRepository);

        UserController userController = new UserController(studentService);

        InitialData data = new InitialData();
        data.addData(adminController);

        MainView view = new MainView(adminController, userController);

        System.out.println("\t----- Welcome to AcademiaDev! -----\n");
        view.displayMenu();

    }
    
}
