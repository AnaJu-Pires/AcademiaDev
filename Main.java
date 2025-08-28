
import Controller.AdminController;
import Controller.UserController;
import Data.InitialData;
import Repository.impl.CourseRepositoryImpl;
import Service.CourseService;

import View.MainView;

public class Main {
    public static void main(String[] args) {
        //vou tentar explicar aqui pra eu nao esquecer e vc tentar entender 
        CourseRepositoryImpl myRepository = new CourseRepositoryImpl();  //Cria a lista pra salvar os cursos (ja coloquei alguns apenas de teste la)

        CourseService courseService = new CourseService(myRepository); 

        AdminController adminController = new AdminController(courseService);

        UserController userController = new UserController();

        InitialData data = new InitialData();
        data.addData(adminController);

        MainView view = new MainView(adminController, userController);

        System.out.println("Bem-vindo à AcademiaDev!");
        view.displayMenu();

    }
    
}
