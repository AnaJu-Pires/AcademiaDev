package Model.User;

public class Admin extends User {

    public Admin(String name, String email) {
        super(name, email);
    }

    public String getRole(){
        return "Admin";
    }
    
}
