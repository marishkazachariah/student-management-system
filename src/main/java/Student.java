import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student extends User implements CRUD<Course>{
    private int id;
    private String name;
    private int age;
    private List<Course> courses;

    public Student(String username, String password, int id, String name, int age) {
        super(username, password, UserRole.STUDENT);
        this.id = id;
        this.name = name;
        this.age = age;
        this.courses = new ArrayList<>();
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
    public void add(Course course) {
        courses.add(course);
    }

    @Override
    public void edit(int courseID) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type in the new course name:");
        String courseNAmeToEdit = scanner.next();
        for (Course course : courses) {
            if (course.getCourseID() == courseID) {
                course.setCourseName(courseNAmeToEdit);
                return;
            }
        }
        System.out.println("Student not found.");
        scanner.close();
    }

    @Override
    public void delete(Course course) {
        courses.remove(course);
    }

    @Override
    public void displayRecords() {
        System.out.println("Courses enrolled in:");
        for(Course course : courses) {
            System.out.println("Course name: " + course.getCourseName());
            System.out.println("Course ID: " + course.getCourseID());
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + id + "\nName: " + name + "\nAge: " + age + "\nCourses: " + courses.stream().toList();
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
