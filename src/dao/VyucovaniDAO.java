package dao;

import model.Vyucovani;
import java.sql.*;
import java.time.LocalDateTime;

public class VyucovaniDAO {

    public Vyucovani findById(Connection conn, int id) throws SQLException {
        String sql = "SELECT * FROM vyucovani WHERE id_vyucovani = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Vyucovani(
                        rs.getInt("id_vyucovani"),
                        rs.getInt("id_predmet"),
                        rs.getTimestamp("datum_cas").toLocalDateTime()
                );
            }
            return null;
        }
    }
}
