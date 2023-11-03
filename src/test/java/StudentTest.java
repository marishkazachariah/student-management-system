import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;
    private Course course;
    @BeforeEach
    void setUp() {
        student = new Student("username", "password", 2, "Mary", 30);
        course = new Course(1, "Math");
    }

    @Test
    void add() {
        student.add(course);
        List<Course> courses = student.getCourses();
        assertTrue(courses.contains(course));
        assertEquals(1, courses.size());
    }
}