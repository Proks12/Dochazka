package service;

import util.DatabaseConnection;
import model.AbsenceReport;

import java.sql.*;
import java.util.*;

public class ReportService {

    public List<AbsenceReport> getAbsence() throws Exception {
        List<AbsenceReport> list = new ArrayList<>();

        try (Connection c = new DatabaseConnection().getConnection()) {
            ResultSet rs = c.createStatement()
                .executeQuery("SELECT * FROM v_absence_student");

            while (rs.next()) {
                list.add(new AbsenceReport(
                    rs.getString("jmeno"),
                    rs.getString("prijmeni"),
                    rs.getInt("absence")
                ));
            }
        }
        return list;
    }
}
