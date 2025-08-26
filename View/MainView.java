package View;

import Controller.AdminController;
import Model.Course.CourseList;

public class MainView {

    public static void main(String[] args) {

        CourseList courseList = new CourseList();


        AdminView adminView = new AdminView(new AdminController());


        adminView.showAdminMenu(courseList);

        
    }
}