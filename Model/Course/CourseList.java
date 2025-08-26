package Model.Course;

import java.util.ArrayList;
import java.util.List;

import Repository.CourseRepository;


public class CourseList implements CourseRepository{
    
    private final List<Course> courses = new ArrayList<>();

    public CourseList() {
        saveCourse(new Course("Java", "Introdução ao Java", "Joaquim", 10, DifficultyLevel.BEGINNER));
        saveCourse(new Course("Python", "Introdução ao Python", "Joaquim", 10, DifficultyLevel.BEGINNER));
        saveCourse(new Course("C++", "Introdução ao C++", "Joaquim", 10, DifficultyLevel.BEGINNER));
    }

    @Override
    public List<Course> searchAll() {
        return courses;
    }

    @Override
    public void saveCourse(Course course) {
        courses.add(course);
        System.out.println("Course saved.");
    }

    @Override
    public Course searchByName(String name) {
        for(Course course : courses) {
            if(course.getTitle().equals(name)) {
                return course;
            }
        }
        return null;
    }

    @Override
    public void deleteCourse(String name) {
        for(Course course : courses) {
            if(course.getTitle().equals(name)) {
                courses.remove(course);
            }
        }
        System.out.println("Course deleted.");
    }



    
    
}
