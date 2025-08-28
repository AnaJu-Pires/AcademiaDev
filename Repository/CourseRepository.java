package Repository;
import Model.Course.Course;


import java.util.List;
import java.util.TreeSet;
import java.util.Optional;




public interface CourseRepository {
    TreeSet<Course> courses = new TreeSet<>();

    void saveCourse(Course course);
  
    Optional<Course> searchByName(String name);
    
    List<Course> searchAll();
    
    void deleteCourse(String name);


    
}
