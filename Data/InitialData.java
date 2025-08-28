package Data;

import Controller.AdminController;
import Controller.dto.CourseDto;

import Model.Course.DifficultyLevel;    

public class InitialData {
    public  void addData(AdminController adminController){

        //cursos de academia
        CourseDto pilates = new CourseDto("Pilates", "Descrição do curso de Pilates", "Instructor", 10, DifficultyLevel.BEGINNER, true);
        CourseDto yoga = new CourseDto("Yoga", "Descrição do curso de Yoga", "Instructor", 10, DifficultyLevel.BEGINNER, true);
        CourseDto pilates2 = new CourseDto("Pilates2", "Descrição do curso de Pilates", "Instructor", 10, DifficultyLevel.INTERMEDIATE, true);
        CourseDto yoga2 = new CourseDto("Yoga2", "Descrição do curso de Yoga", "Instructor", 10, DifficultyLevel.INTERMEDIATE, true);
        CourseDto pilates3 = new CourseDto("Pilates3", "Descrição do curso de Pilates", "Instructor", 10, DifficultyLevel.ADVANCED, true);
        CourseDto yoga3 = new CourseDto("Yoga3", "Descrição do curso de Yoga", "Instructor", 10, DifficultyLevel.ADVANCED, false);

        
        adminController.addCourse(pilates);
        adminController.addCourse(yoga);
        adminController.addCourse(pilates2);
        adminController.addCourse(yoga2);
        adminController.addCourse(pilates3);
        adminController.addCourse(yoga3);
    }
}
