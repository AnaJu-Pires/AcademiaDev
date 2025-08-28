package Repository.impl;

import Model.Course.Course;
import Repository.CourseRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CourseRepositoryImpl implements CourseRepository{

    private final Map<String, Course> courses = new TreeMap<>();

    @Override
    public void saveCourse(Course course) {
        
        courses.put(course.getTitle(), course);
        System.out.println("Course saved.");
    }

    @Override
    public Optional<Course> searchByName(String name) {
        return Optional.ofNullable(courses.get(name));
    }

    @Override
    public List<Course> searchAll() {
        List<Course> courseList = courses.values().stream().collect(Collectors.toList());
        return courseList;
    }

    @Override
    public Course changeStatusCourse(String name) {
        Course course = courses.get(name);
        if(course.getStatus() == true) course.setStatus(false);
        else course.setStatus(true);
        return course;
    }
}
