package Controller.dto;

public abstract class UserDto {
private static Integer nextId = 1;

    protected Integer id;
    protected String name;
    protected String email;

    public UserDto (String name, String email) {
        this.id = nextId++;
        this.name = name;
        this.email = email;
    }

    public UserDto(String email) {
        this(null, email);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


    
}
