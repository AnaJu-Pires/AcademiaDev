package Model.Enrollment;
import Model.User.Student;
import Model.Course.Course;

public class Enrollment {

    private int id;
    private Student student;
    private Course course;
    private int progress;

    public Enrollment(int id, Student student, Course course) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.progress = 0;
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

    public void setProgress(int progress) {
        if(progress >= 0 && progress <= 100) {
            this.progress = progress;
        }else {
            System.out.println("Progress must be between 0 and 100.");
        }
    }




    

    

    
}
