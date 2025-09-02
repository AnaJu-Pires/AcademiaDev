package Service;

import java.util.List;
import java.util.stream.Collectors;

import Controller.dto.CourseDto;
import Repository.impl.CourseRepositoryImpl;
import Util.GenericCsvExporter;
import Model.Course.Course;
import java.util.Optional;


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

    public CourseDto searchByName(String courseName) {
        Optional<Course> optionalCourse = courseRepository.searchByName(courseName);
        if (optionalCourse.isPresent()) {
            Course course = optionalCourse.get();
            return new CourseDto(
                    course.getTitle(),
                    course.getDescription(),
                    course.getInstructorName(),
                    course.getDurationHours(),
                    course.getDifficultyLevel(),
                    course.getStatus()
            );
        } else {
            return null;
        }
    }

    public CourseDto changeStatusCourse(String courseName) {
        Course course = courseRepository.changeStatusCourse(courseName);

        CourseDto courseDto = new CourseDto(course.getTitle(), course.getDescription(), course.getInstructorName(), course.getDurationHours(), course.getDifficultyLevel(), course.getStatus());
        System.out.println("trocou." + course.getStatus());
        return courseDto;
        
    }

    public void exportAllCourses(List<String> fieldsToInclude) {
        
        List<Course> courses = courseRepository.exportAllCourses();
        String csv = GenericCsvExporter.export(courses, fieldsToInclude);
        System.out.println(csv);
    }

     
}
