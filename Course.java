public class Course {
    private String title;
    private String description;
    private String instructorName;
    private int durationHours;
    private DifficultyLevel difficultyLevel;
    private Boolean status;

    public Course(String title, String description, String instructorName, int durationHours, DifficultyLevel difficultyLevel) {
        setTitle(title);
        setDescription(description);
        setInstructorName(instructorName);
        setDurationHours(durationHours);
        setDifficultyLevel(difficultyLevel);
        setStatus(true);
    }

      public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("O título não pode ser vazio ou nulo");
        }
        this.title = title.trim();
    }

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("A descrição nao pode ser vazia ou nula");
        }
        this.description = description;
    }

    public void setInstructorName(String instructorName) {
        if (instructorName == null || instructorName.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome do instrutor nao pode ser vazio ou nulo");
        }
        this.instructorName = instructorName;
    }

    public void setDurationHours(int durationHours) {
        if (durationHours <= 0) {
            throw new IllegalArgumentException("A duracao nao pode ser negativa ou zero");
        }
        this.durationHours = durationHours;
    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        if (difficultyLevel == null) {
            throw new IllegalArgumentException("O nivel de dificuldade nao pode ser nulo");
        }
        this.difficultyLevel = difficultyLevel;
    }

    public void setStatus(Boolean status) {
        if (status == null) {
            throw new IllegalArgumentException("O status nao pode ser nulo");
        }
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

    public int getDurationHours() {
        return durationHours;
    }

    public DifficultyLevel getDifficultyLevel() {
        return difficultyLevel;
    }

    public Boolean getStatus() {
        return status;
    }



}
