package util;

import java.sql.*;

public class DatabaseConnection {

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                Config.get("db.url"),
                Config.get("db.user"),
                Config.get("db.password")
        );
    }
}
