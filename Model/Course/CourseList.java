package Model.Course;

import java.util.ArrayList;


public class CourseList {
    
    private ArrayList<Course> courses;

    public CourseList() {
        this.courses = new ArrayList<>();
    }
    
    public CourseList(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }


    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeCourse(String title) {
        for (Course course : this.courses) {
            if (course.getTitle().trim().equals(title)) {
                this.courses.remove(course);
                break;
            }
        }
    }

    public void updateCourse(String title, Course updatedCourse) {
        for (Course course : this.courses) {
            if (course.getTitle().trim().equals(title)) {
                course.setTitle(updatedCourse.getTitle());
                course.setDescription(updatedCourse.getDescription());
                course.setInstructorName(updatedCourse.getInstructorName());
                course.setDurationHours(updatedCourse.getDurationHours());
                course.setDifficultyLevel(updatedCourse.getDifficultyLevel());
                course.setStatus(updatedCourse.getStatus());
                break;
            }
        }
    }

    public void showCoursesCatalog() {
        System.out.println("Verificando o catálogo de cursos");
        for(Course course : this.courses) {
            System.out.println("-" + course.getTitle());
        }
    }
    
}
