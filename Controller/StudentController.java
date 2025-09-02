package Controller;

import java.util.List;

import Controller.dto.StudentDto;
import Service.StudentService;

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void createStudent( StudentDto studentDto) {
        studentService.createStudent(studentDto);
    }

    public StudentDto loginStudent(String email) {
        return studentService.loginStudent(email);
    }

    public void exportAllStudents(List<String> fieldsToInclude) {
        studentService.exportAllStudents(fieldsToInclude);
    }

    public void changeSubscriptionPlan(String email, String planName) {
        studentService.changeSubscriptionPlan(email, planName);
    }

    
}
