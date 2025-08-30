package Repository.impl;

import java.util.Map;
import java.util.TreeMap;
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

    
}
