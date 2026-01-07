package service;

import dao.StudentDAO;
import util.DatabaseConnection;

import java.sql.Connection;
import java.time.LocalDate;

public class StudentService {

    public void createStudent(String jmeno, String prijmeni, String datum) throws Exception {
        try (Connection c = new DatabaseConnection().getConnection()) {
            new StudentDAO().insert(c, jmeno, prijmeni, LocalDate.parse(datum));
        }
    }
}
