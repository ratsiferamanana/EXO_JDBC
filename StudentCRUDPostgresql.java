package org.StudentPortail;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentCRUDPostgresql implements StudentCRUD {

    private static final String JDBC_URL = "jdbc:postgresql://localhost:5432/student_portail";
    private static final String JDBC_USER = "postgres";
    private static final String JDBC_PASSWORD = "Tsiferana5865$";

    // Méthode pour obtenir la connexion à la base de données
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }

    @Override
    public void ajouterStudent(Student student) {
        String sql = "INSERT INTO students (id, userName, phone, email, address, firstName, lastName) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getId());
            stmt.setString(2, student.getUserName());
            stmt.setString(3, student.getPhone());
            stmt.setString(4, student.getEmail());
            stmt.setString(5, student.getAddress());
            stmt.setString(6, student.getFirstName());
            stmt.setString(7, student.getLastName());

            stmt.executeUpdate();
            System.out.println("Student inserted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student getOneStudent(String id) {
        String sql = "SELECT * FROM students WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Student(
                        rs.getString("id"),
                        rs.getString("userName"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("firstName"),
                        rs.getString("lastName")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Retourne null si l'étudiant n'est pas trouvé
    }

    @Override
    public List<Student> getAllStudents() {
        String sql = "SELECT * FROM students";
        List<Student> students = new ArrayList<>();
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                students.add(new Student(
                        rs.getString("id"),
                        rs.getString("userName"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("firstName"),
                        rs.getString("lastName")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    @Override
    public void updateStudent(Student student) {
        String sql = "UPDATE students SET userName = ?, phone = ?, email = ?, address = ?, firstName = ?, lastName = ? WHERE id = ?";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, student.getUserName());
            stmt.setString(2, student.getPhone());
            stmt.setString(3, student.getEmail());
            stmt.setString(4, student.getAddress());
            stmt.setString(5, student.getFirstName());
            stmt.setString(6, student.getLastName());
            stmt.setString(7, student.getId());

            stmt.executeUpdate();
            System.out.println("Student updated successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void supprierStudent(String id) {
        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, id);
            stmt.executeUpdate();
            System.out.println("Student removed successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StudentCRUDPostgresql studentCRUDPostgresql = new StudentCRUDPostgresql();

        // Exemple d'affichage d'un étudiant spécifique
        String studentId = "STD23081"; // Remplacez par l'ID de l'étudiant que vous souhaitez récupérer
        Student student = studentCRUDPostgresql.getOneStudent(studentId);

        if (student != null) {
            System.out.println("Student Details:");
            System.out.println("ID: " + student.getId());
            System.out.println("UserName: " + student.getUserName());
            System.out.println("Phone: " + student.getPhone());
            System.out.println("Email: " + student.getEmail());
            System.out.println("Address: " + student.getAddress());
            System.out.println("FirstName: " + student.getFirstName());
            System.out.println("LastName: " + student.getLastName());
        } else {
            System.out.println("Student with ID " + studentId + " not found.");
        }
    }
}


