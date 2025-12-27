package dao;

import model.Student;
import java.sql.*;
import java.time.LocalDate;

public class StudentDAO {

    public Student findById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM student WHERE id_student = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Student(
                        rs.getInt("id_student"),
                        rs.getString("jmeno"),
                        rs.getString("prijmeni"),
                        rs.getDate("datum_narozeni").toLocalDate(),
                        rs.getBoolean("aktivni")
                );
            }
            return null;
        }
    }
}
