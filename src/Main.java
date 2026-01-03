import model.StavDochazky;
import service.DochazkaService;

public class Main {

    public static void main(String[] args) {

        DochazkaService service = new DochazkaService();

        service.zapsatDochazku(
                1,              // id_student
                1,              // id_vyucovani
                StavDochazky.PRITOMEN,
                "Včasný příchod"
        );

        System.out.println("Hotovo.");
    }
}
