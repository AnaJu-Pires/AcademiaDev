package Service;

import java.util.List;
import java.util.stream.Collectors;

import Controller.dto.CourseDto;
import Repository.impl.CourseRepositoryImpl;
import Model.Course.Course;
import Model.Course.DifficultyLevel;



public class CourseService {
        private final CourseRepositoryImpl courseRepository;

        public CourseService(CourseRepositoryImpl courseRepository) {
            this.courseRepository = courseRepository;
        }

        public void saveCourse(CourseDto courseDto) {
        Course course = new Course(
            courseDto.getTitle(),
            courseDto.getDescription(),
            courseDto.getInstructorName(),
            courseDto.getDurationInHours(),
            courseDto.getDifficulty(),
            courseDto.getStatus()
        );



        courseRepository.saveCourse(course);
    }

    public List<CourseDto> showCoursesCatalog() {
    return courseRepository.searchAll()
            .stream()
            .map(course -> new CourseDto(
                    course.getTitle(),
                    course.getDurationHours(),
                    course.getDifficultyLevel(),
                    course.getStatus()
            ))
            .collect(Collectors.toList());
}

     
}
