package Controller.dto;




public class SupportTicketDto {
    private Integer id;
    private String title;
    private String message;
    private UserDto author;

    public SupportTicketDto(Integer id, String title, String message, UserDto author) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.author = author;
    }

    public SupportTicketDto(String title, String message, UserDto author) {
        this.title = title;
        this.message = message;
        this.author = author;
    }

    public SupportTicketDto() {}

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public UserDto getAuthor() {
        return author;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuthor(UserDto author) {
        this.author = author;
    }



    
}
