package Controller;

import Controller.dto.StudentDto;
import Service.StudentService;

public class UserController {

    private final StudentService studentService;

    public UserController(StudentService studentService) {
        this.studentService = studentService;
    }

    public void createStudent( StudentDto studentDto) {
        studentService.createStudent(studentDto);
    }

    
}
