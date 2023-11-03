import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CourseManager {
    private List<Course> courses;

    public CourseManager() {
        this.courses = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Course> searchCourses(String searchTerm) {
        List<Course> searchResults = new ArrayList<>();
        for (Course course : getCourses()) {
            if (course.getCourseName().contains(searchTerm) || course.getCourseID() == Integer.parseInt(searchTerm)) {
                searchResults.add(course);
            }
        }
        return searchResults;
    }

    public List<Course> sortCoursesByName() {
        return courses.stream()
                .sorted(Comparator.comparing(Course::getCourseName))
                .toList();
    }

    public List<Course> sortCoursesById() {
        return courses.stream()
                .sorted(Comparator.comparing(Course::getCourseID))
                .toList();
    }
}
