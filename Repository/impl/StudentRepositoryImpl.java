package Repository.impl;

import java.util.Map;
import java.util.TreeMap;
import java.util.List;
import java.util.stream.Collectors;
import Model.User.Student;
import Repository.StudentRepository;

public class StudentRepositoryImpl implements StudentRepository {

    private final Map<String, Student> students = new TreeMap<>();//tree ou hash?

    @Override
    public void saveStudent(Student student) {

        students.put(student.getEmail(), student);
        System.out.println("Student saved.");
    }

    @Override
    public Student findByEmail(String email) {
        return students.get(email);
    }

    @Override
    public List<Student> exportAllStudents() {
        List<Student> studentList = students.values().stream().collect(Collectors.toList());
        return studentList;
    }

    
}
