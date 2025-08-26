package Model.Enrollment;
import Model.User.Student;
import Model.Course.Course;

public class Enrollment {

    private int id;
    private Student student;
    private Course course;
    private int progress;

    public Enrollment(int id, Student student, Course course, int progress) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.progress = progress;
    }

    public int getId() {
        return id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public int getProgress() {
        return progress;
    }




    

    

    
}
