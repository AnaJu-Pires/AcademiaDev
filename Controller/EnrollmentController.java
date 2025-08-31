package Controller;

import java.util.List;

import Controller.dto.StudentDto;
import Exception.BusinessException;
import Exception.CourseNotFoundException;
import Exception.EnrollmentNotFoundException;
import Model.Enrollment.Enrollment;
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

    public int getCourseProgress(StudentDto studentDto, String courseName) {
        try {
            return enrollmentService.getCourseProgress(studentDto, courseName);

        } catch (CourseNotFoundException | EnrollmentNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
            return -1;
        }
    }

    public void updateProgress(StudentDto studentDto, String courseName, int newProgress) {
        try {
            enrollmentService.updateProgress(studentDto, courseName, newProgress);
            System.out.println("The progress of the course '" + courseName + "' has been updated!");

        } catch (BusinessException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    
}
