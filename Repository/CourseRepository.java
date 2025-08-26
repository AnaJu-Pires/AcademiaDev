package Repository;
import Model.Course.Course;

import java.util.List;
import java.util.Optional;


public interface CourseRepository {

   /**
    @param course
    @return
    **/

    Course save(Course course);

    /**
    @param title
    @return
    **/

    Optional<Course> findByTitle(String title);

    /**
    @return
    **/
    List<Course> findAll();


    
}
