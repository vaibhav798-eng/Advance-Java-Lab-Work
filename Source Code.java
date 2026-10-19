
import java.sql.*;
import java.util.Scanner;

public class CollegeManagementSystem {

    // Database connection details
    private static final String URL =    "jdbc:mysql://localhost:3306/college_db";
    private static final String USER = "root";
    private static final String PASSWORD = "your_password";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 1. Add a student
    private static void addStudent(Scanner sc) {
        String sql = "INSERT INTO students " +
                "(id, name, department, email, phone) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String department = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();

            System.out.print("Enter Phone: ");
            String phone = sc.nextLine();

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, department);
            ps.setString(4, email);
            ps.setString(5, phone);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student added successfully!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid student ID.");
        } catch (SQLIntegrityConstraintViolationException e) {
            System.out.println("Student ID already exists.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // 2. Display all students
    private static void viewStudents() {
        String sql = "SELECT * FROM students ORDER BY id";

        try (Connection con = getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("\n--- Student Records ---");

            boolean found = false;

            while (rs.next()) {
                found = true;
                System.out.println("------------------------");
                System.out.println("ID         : " + rs.getInt("id"));
                System.out.println("Name       : " + rs.getString("name"));
                System.out.println("Department : " + rs.getString("department"));
                System.out.println("Email      : " + rs.getString("email"));
                System.out.println("Phone      : " + rs.getString("phone"));
            }

            if (!found) {
                System.out.println("No student records found.");
            }

        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // 3. Search for a student
    private static void searchStudent(Scanner sc) {
        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter Student ID to search: ");
            int id = Integer.parseInt(sc.nextLine());

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    System.out.println("\nStudent Found");
                    System.out.println("ID         : " + rs.getInt("id"));
                    System.out.println("Name       : " + rs.getString("name"));
                    System.out.println("Department : " + rs.getString("department"));
                    System.out.println("Email      : " + rs.getString("email"));
                    System.out.println("Phone      : " + rs.getString("phone"));
                } else {
                    System.out.println("Student not found.");
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid student ID.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // 4. Update a student
    private static void updateStudent(Scanner sc) {
        String sql = "UPDATE students SET name = ?, department = ?, " +
                "email = ?, phone = ? WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter Student ID to update: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Enter New Name: ");
            String name = sc.nextLine();

            System.out.print("Enter New Department: ");
            String department = sc.nextLine();

            System.out.print("Enter New Email: ");
            String email = sc.nextLine();

            System.out.print("Enter New Phone: ");
            String phone = sc.nextLine();

            ps.setString(1, name);
            ps.setString(2, department);
            ps.setString(3, email);
            ps.setString(4, phone);
            ps.setInt(5, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid student ID.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // 5. Delete a student
    private static void deleteStudent(Scanner sc) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            System.out.print("Enter Student ID to delete: ");
            int id = Integer.parseInt(sc.nextLine());

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student ID not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid student ID.");
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // Main method
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(
                    "MySQL JDBC driver not found. Add Connector/J to your project.");
            return;
        }

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== COLLEGE MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number from 1 to 6.");
                continue;
            }

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    searchStudent(sc);
                    break;
                case 4:
                    updateStudent(sc);
                    break;
                case 5:
                    deleteStudent(sc);
                    break;
                case 6:
                    System.out.println("Exiting College Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 6);

        sc.close();
    }
}
