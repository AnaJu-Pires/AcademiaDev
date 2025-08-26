package Controller;


import Model.Course.DifficultyLevel;
import Service.CourseService;

public class AdminController {
    
    private final CourseService courseService;
    public AdminController(CourseService courseService) {
        this.courseService = courseService;
    }


    
    public void addCourse(String title, String description, String instructorName, int durationInHours, DifficultyLevel difficulty) {
        courseService.saveCourse(title, description, instructorName, durationInHours, difficulty);
    }
}
