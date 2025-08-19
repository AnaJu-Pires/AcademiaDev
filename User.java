import java.util.List;

public abstract class User {
    private static Integer nextId = 1;

    protected Integer id;
    protected String name;
    protected String email;

    public User(String name, String email) {
        this.id = nextId++;
        this.name = name;
        this.email = email;
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

    public void login(String email) {
        System.out.println("Logando no sistema");
        //configurar certinho, se pa é um abstract mas não tenho ctz
    }

    public void showCoursesCatalog(List<Course> courses) {
        System.out.println("Verificando o catálogo de cursos");
        for(Course course : courses) {
            System.out.println("-" + course.getTitle());
        }
    }

    public void openSupportTicket() {
        System.out.println("Abrindo um ticket de suporte");
        //configurar certinho
    }

}