import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private int id;
    private String name;
    private int age;
    private List<Course> courses = new ArrayList<>();

    public Student(String username, String password, int id, String name, int age, List<Course> courses) {
        super(username, password, UserRole.STUDENT);
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public void displayRoleSpecificMenu() {
        System.out.println("Welcome " + getUsername() + "!");
        System.out.println("Student Menu:");
        System.out.println("1. View Courses");
        System.out.println("2. Edit Data");
        System.out.println("3. Delete Account");
    }
}
