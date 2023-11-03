public enum UserRole {
    ADMIN("Admin"),
    TEACHER("Teacher"),
    STUDENT("Student");

    private final String roleName;

    UserRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }
}

