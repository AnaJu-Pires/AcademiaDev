package Controller.dto;

import Model.Course.DifficultyLevel;


public class CourseDto {
    private String title;
    private String description;
    private String instructorName;
    private int durationHours;
    private DifficultyLevel difficultyLevel;
    private Boolean status;

    public CourseDto(String title, String description, String instructorName, int durationHours, DifficultyLevel difficultyLevel, Boolean status) {
        this.title = title;
        this.description = description;
        this.instructorName = instructorName;
        this.durationHours = durationHours;
        this.difficultyLevel = difficultyLevel;
        this.status = status;
    }

    public CourseDto(String title, int durationInHours, DifficultyLevel difficulty, Boolean status) {
        this.title = title;
        this.durationHours = durationInHours;
        this.difficultyLevel = difficulty;
        this.status = status;
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

    public int getDurationInHours() {
        return durationHours;
    }

    public DifficultyLevel getDifficulty() {
        return difficultyLevel;
    }

    public Boolean getStatus() {
        return status;
    }


}
