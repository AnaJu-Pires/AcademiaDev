package Repository;

import java.util.List;
import java.util.TreeSet;

import Model.User.Student;

public interface StudentRepository {

    TreeSet<Student> students = new TreeSet<>();

    void saveStudent(Student student);

    Student findByEmail(String email);
        
    List<Student> exportAllStudents();
    
}
