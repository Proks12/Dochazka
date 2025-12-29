package dao;

import java.sql.*;

public class StudentPredmetDAO {

    public boolean exists(Connection conn, int idStudent, int idPredmet) throws SQLException {
        String sql = "SELECT 1 FROM student_predmet WHERE id_student = ? AND id_predmet = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, idStudent);
            ps.setInt(2, idPredmet);
            return ps.executeQuery().next();
        }
    }
}
