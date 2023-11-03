class Admin extends User {
    public Admin(String username, String password) {
        super(username, password, UserRole.ADMIN);
    }

    @Override
    public void displayRoleSpecificMenu() {
        System.out.println("Welcome " + getUsername() + "!");
        System.out.println("Admin Menu:");
        System.out.println("1. Manage Users");
        System.out.println("2. Delete Account");
    }
}