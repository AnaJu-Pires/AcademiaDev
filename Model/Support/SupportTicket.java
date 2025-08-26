package Model.Support;

import Model.User.User;

public class SupportTicket {

    private Integer id;
    private String title;
    private String message;
    private User author;

    public SupportTicket(Integer id, String title, String message, User author) {
        this.id = id;
        this.title = title;
        this.message = message;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }

    public User getAuthor() {
        return author;
    }

    
}
