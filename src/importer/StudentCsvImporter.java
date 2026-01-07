package importer;

import service.StudentService;

import java.nio.file.*;
import java.util.*;

public class StudentCsvImporter {

    public void importCsv(String path) throws Exception {
        List<String> lines = Files.readAllLines(Path.of(path));
        StudentService service = new StudentService();

        for (String l : lines.subList(1, lines.size())) {
            String[] p = l.split(";");
            service.createStudent(p[0], p[1], p[2]);
        }
    }
}
