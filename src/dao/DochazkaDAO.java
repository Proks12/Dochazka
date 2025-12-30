package dao;

import model.Dochazka;
import java.sql.*;

public class DochazkaDAO {

    public void insert(Connection conn, Dochazka d) throws SQLException {
        String sql = "INSERT INTO dochazka (id_student, id_vyucovani, stav, poznamka) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, d.getIdStudent());
            ps.setInt(2, d.getIdVyucovani());
            ps.setString(3, d.getStav().name());
            ps.setString(4, d.getPoznamka());
            ps.executeUpdate();
        }
    }
}
