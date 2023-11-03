import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Student> searchStudents(String searchTerm) {
        List<Student> searchResults = new ArrayList<>();
        for (Student student : getStudents()) {
            if (student.getName().contains(searchTerm) || student.getAge() == Integer.parseInt(searchTerm)) {
                searchResults.add(student);
            }
        }
        return searchResults;
    }

    public List<Student> sortStudentsByName() {
        return students.stream()
                .sorted(Comparator.comparing(Student::getName))
                .toList();
    }

    public List<Student> sortStudentsById() {
        return students.stream()
                .sorted(Comparator.comparing(Student::getId))
                .toList();
    }
}
