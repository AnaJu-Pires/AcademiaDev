package Repository;
import Model.Course.Course;


import java.util.List;
import java.util.TreeSet;




public interface CourseRepository {
    TreeSet<Course> courses = new TreeSet<>();

    void saveCourse(Course course);
  
    Course searchByName(String name);
    
    List<Course> searchAll();
    
    void deleteCourse(String name);


    
}
