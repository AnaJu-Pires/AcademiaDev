
import Controller.AdminController;
import Model.Course.CourseList;

import Repository.CourseRepository;
import Service.CourseService;

import View.MainView;

public class Main {
    public static void main(String[] args) {
        //vou tentar explicar aqui pra eu nao esquecer e vc tentar entender 
        CourseRepository myRepository = new CourseList();  //Cria a lista pra salvar os cursos (ja coloquei alguns apenas de teste la)

        CourseService courseService = new CourseService(myRepository); 

        AdminController adminController = new AdminController(courseService);

        MainView view = new MainView(adminController);

        System.out.println("Bem-vindo à AcademiaDev!");
        view.displayMenu();

    }
    
}
