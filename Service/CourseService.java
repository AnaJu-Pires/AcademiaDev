package Service;

import java.util.List;
import java.util.stream.Collectors;

import Repository.CourseRepository;
import Controller.dto.CourseDto;
import Model.Course.Course;
import Model.Course.DifficultyLevel;



public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<CourseDto> activatedCourses() {
        
        List<Course> courses = courseRepository.searchAll();
        
        return courses.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    private CourseDto convertToDto(Course course) {
        return new CourseDto(
                course.getTitle(),
                course.getDescription(),
                course.getInstructorName(),
                course.getDurationHours(),
                course.getDifficultyLevel()
        );
    }

    public void saveCourse(String title, String description, String instructorName, int durationInHours, DifficultyLevel difficulty) {
        //aparentemente aqui vai ser feito o as exception
        courseRepository.saveCourse(new Course(title, description , instructorName, durationInHours, difficulty));
    }

     
}
