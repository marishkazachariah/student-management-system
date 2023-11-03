class Teacher extends User {
    public Teacher(String username, String password) {
        super(username, password, UserRole.TEACHER);
    }

    @Override
    public void displayRoleSpecificMenu() {
        System.out.println("Welcome " + getUsername() + "!");
        System.out.println("Teacher Menu:");
        System.out.println("1. Manage Grades");
        System.out.println("2. Delete Account");
    }
}
