package Data;

import Controller.CourseController;
import Controller.dto.CourseDto;


import Model.Course.DifficultyLevel;    

public class InitialData {
    public  void addData(CourseController courseController){

        //cursos de academia
        CourseDto pilates = new CourseDto("Pilates", "Descrição do curso de Pilates", "Instructor", 10, DifficultyLevel.BEGINNER, true);
        CourseDto yoga = new CourseDto("Yoga", "Descrição do curso de Yoga", "Instructor", 10, DifficultyLevel.BEGINNER, true);
        CourseDto pilates2 = new CourseDto("Pilates2", "Descrição do curso de Pilates", "Instructor", 10, DifficultyLevel.INTERMEDIATE, true);
        CourseDto yoga2 = new CourseDto("Yoga2", "Descrição do curso de Yoga", "Instructor", 10, DifficultyLevel.INTERMEDIATE, true);
        CourseDto pilates3 = new CourseDto("Pilates3", "Descrição do curso de Pilates", "Instructor", 10, DifficultyLevel.ADVANCED, true);
        CourseDto yoga3 = new CourseDto("Yoga3", "Descrição do curso de Yoga", "Instructor", 10, DifficultyLevel.ADVANCED, false);



        
        courseController.addCourse(pilates);
        courseController.addCourse(yoga);
        courseController.addCourse(pilates2);
        courseController.addCourse(yoga2);
        courseController.addCourse(pilates3);
        courseController.addCourse(yoga3);
    }
}
