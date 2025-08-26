package Controller.dto;

import Model.Course.DifficultyLevel;

public class CourseDto {
    private final String title;
    private final String description;
    private final String instructorName;
    private final int durationHours;
    private final DifficultyLevel difficultyLevel;

    public CourseDto(String title, String description, String instructorName, int durationHours, DifficultyLevel difficultyLevel) {
        this.title = title;
        this.description = description;
        this.instructorName = instructorName;
        this.durationHours = durationHours;
        this.difficultyLevel = difficultyLevel;
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

    @Override
public String toString() {
    return "Course " +
           "\n  title='" + title + '\'' +
           ",\n  description='" + description + '\'' +
           ",\n  instructorName='" + instructorName + '\'' +
           ",\n  durationHours=" + durationHours +
           ",\n  difficultyLevel=" + difficultyLevel +
           "\n\n";
}
}
