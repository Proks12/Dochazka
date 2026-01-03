package service;

import dao.*;
import model.*;
import util.*;

import java.sql.Connection;

public class DochazkaService {

    private final StudentDAO studentDAO = new StudentDAO();
    private final VyucovaniDAO vyucovaniDAO = new VyucovaniDAO();
    private final StudentPredmetDAO studentPredmetDAO = new StudentPredmetDAO();
    private final DochazkaDAO dochazkaDAO = new DochazkaDAO();

    private final DatabaseConnection db = new DatabaseConnection();
    private final Logger logger = new Logger();

    public void zapsatDochazku(
            int idStudent,
            int idVyucovani,
            StavDochazky stav,
            String poznamka
    ) {

        try (Connection conn = db.getConnection()) {
            conn.setAutoCommit(false);

            Student student = studentDAO.findById(conn, idStudent);
            if (student == null || !student.isAktivni()) {
                throw new RuntimeException("Student neexistuje nebo není aktivní");
            }

            Vyucovani vyucovani = vyucovaniDAO.findById(conn, idVyucovani);
            if (vyucovani == null) {
                throw new RuntimeException("Vyučování neexistuje");
            }

            boolean zapsan = studentPredmetDAO.exists(
                    conn,
                    idStudent,
                    vyucovani.getIdPredmet()
            );

            if (!zapsan) {
                throw new RuntimeException("Student není zapsán na předmět");
            }

            dochazkaDAO.insert(conn,
                    new Dochazka(idStudent, idVyucovani, stav, poznamka)
            );

            conn.commit();

        } catch (Exception e) {
            logger.error("Chyba při zápisu docházky", e);
        }
    }
}
