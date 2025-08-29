package Controller.dto;


public class EnrollmentDto {
    private Integer id;
    private StudentDto studentDto;
    private CourseDto courseDto;
    private int progressDto;

    public EnrollmentDto(Integer id, StudentDto studentDto, CourseDto courseDto, int progressDto) {
        this.id = id;
        this.studentDto = studentDto;
        this.courseDto = courseDto;
        this.progressDto = progressDto;
    }

    public EnrollmentDto() {}

    public Integer getId() {
        return id;
    }

    public StudentDto getStudentDto() {
        return studentDto;
    }

    public CourseDto getCourseDto() {
        return courseDto;
    }

    public int getProgressDto() {
        return progressDto;
    }

    public void setProgressDto(int progressDto) {
        this.progressDto = progressDto;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStudentDto(StudentDto studentDto) {
        this.studentDto = studentDto;
    }

    public void setCourseDto(CourseDto courseDto) {
        this.courseDto = courseDto;
    }


}
