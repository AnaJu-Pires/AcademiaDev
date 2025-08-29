package Controller;

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

    
}
