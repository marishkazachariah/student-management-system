import java.util.List;

public interface CRUD<T> {
    @MethodDocumentation("This method adds an object of any type of a list of objects of any type.")
    void add(T item);
    @MethodDocumentation("This method edits an object of any type of a list of objects of any type.")
    void edit(int id);
    @MethodDocumentation("This method deletes an object of any type of a list of objects of any type.")
    void delete(T item);
    @MethodDocumentation("This method displays records of any type.")
    void displayRecords();
}
