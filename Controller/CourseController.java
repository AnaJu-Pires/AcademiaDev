package Controller;


import java.util.List;


import Controller.dto.CourseDto;
import Service.CourseService;

public class CourseController {
    
    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    
    public void addCourse(CourseDto CourseDto){ 
        courseService.saveCourse(CourseDto);    
    }

    public List<CourseDto> showCoursesCatalog() {
        return courseService.showCoursesCatalog();
    }

    public CourseDto searchByName(String courseName) {
        return courseService.searchByName(courseName);
    }

    public CourseDto changeStatusCourse(String courseName) {
        return courseService.changeStatusCourse(courseName);
    }

    public void exportAllCourses(List<String> fieldsToInclude) {
        courseService.exportAllCourses(fieldsToInclude);
    }

}
