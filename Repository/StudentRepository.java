package Repository;

import java.util.TreeSet;

import Model.User.Student;

public interface StudentRepository {

    TreeSet<Student> students = new TreeSet<>();

    void saveStudent(Student student);

    Student findByEmail(String email);
        

    
}
