package Controller;

import java.util.List;

import Controller.dto.StudentDto;
import Service.EnrollmentService;
import Controller.dto.EnrollmentDto;

public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    public void enrollInCourse(String courseName, StudentDto studentDto) {
        this.enrollmentService.enrollInCourse(courseName, studentDto);
    }

    public List<EnrollmentDto> viewEnrolledCourses(StudentDto studentDto) {
        return this.enrollmentService.viewEnrolledCourses(studentDto);
    }
    
}
