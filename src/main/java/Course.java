import java.util.*;

public class Course implements CRUD<Student> {
    private final int courseID;
    private String courseName;
    private List<Student> enrolledStudents;
    private Map<Student, Double> grades;

    public Course(int courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.grades = new HashMap<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public int getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public void addGrade(Student student, double grade) {
        if (enrolledStudents.contains(student) && grade >= 0 && grade <= 100) {
            grades.put(student, grade);
            System.out.println("Grade added for " + student.getName());
        } else {
            System.out.println("Student " + student.getName() + " is not enrolled in this course.");
        }
    }

    public void editGrade(Student student, double grade) {
        if (enrolledStudents.contains(student) && grades.containsKey(student)
        && grade >= 0 && grade <= 100) {
            grades.put(student, grade);
            System.out.println("Grade updated for " + student.getName());
        } else if (!enrolledStudents.contains(student)) {
            System.out.println("Student " + student.getName() + " is not enrolled in this course.");
        } else {
            System.out.println("Student " + student.getName() + " does not have a grade to edit.");
        }
    }

    public void displayStudentGrades() {
        System.out.println("Grades for Course: " + courseName);
        for (Map.Entry<Student, Double> entry : grades.entrySet()) {
            System.out.println("Student: " + entry.getKey() + " Grade: " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "Course Name: " + courseName + "\nCourse ID: " + courseID +
                "\nEnrolled Students: " + enrolledStudents.stream().toList();
    }

    @Override
    public void add(Student student) {
        enrolledStudents.add(student);
    }

    @Override
    public void edit(int studentID) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the new/updated name of student:");
        String nameToEdit = scanner.next();
        for (Student student : enrolledStudents) {
            if (student.getId() == studentID) {
                student.setName(nameToEdit);
                return;
            }
        }
        System.out.println("Student not found.");
        scanner.close();
    }

    @Override
    public void delete(Student student) {
        enrolledStudents.remove(student);
    }

    @Override
    public void displayRecords() {
        System.out.println("Students enrolled in this course:");
        for(Student student : enrolledStudents) {
            System.out.println("Student Name: " + student.getName());
            System.out.println("Student ID: " + student.getId());
            Double grade = grades.get(student);
            if (grade != null) {
                System.out.println("Grade: " + grade);
            } else {
                System.out.println("Grade not found for this student.");
            }
        }
    }
}

