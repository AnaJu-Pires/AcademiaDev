package Controller;

import Controller.dto.StudentDto;
import Service.EnrollmentService;

public class EnrollmentController {
    private final EnrollmentService enrollmentService;

    public EnrollmentController(EnrollmentService enrollmentService) {
        this.enrollmentService = enrollmentService;
    }

    public void enrollInCourse(String courseName, StudentDto studentDto) {
        this.enrollmentService.enrollInCourse(courseName, studentDto);
    }
}
