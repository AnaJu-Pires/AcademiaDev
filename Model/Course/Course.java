package Model.Course;


public class Course {
    private String title;
    private String description;
    private String instructorName;
    private int durationHours;
    private DifficultyLevel difficultyLevel;
    private Boolean status;

    public Course(String title, String description, String instructorName, int durationHours, DifficultyLevel difficultyLevel) {
        this.title = title;
        this.description = description;
        this.instructorName = instructorName;
        this.durationHours = durationHours;
        this.difficultyLevel = difficultyLevel;
        this.status = false;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getInstructorName() {
        return instructorName;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    



     


}
