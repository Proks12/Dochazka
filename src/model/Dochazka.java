package model;

public class Dochazka {
    private int idStudent;
    private int idVyucovani;
    private StavDochazky stav;
    private String poznamka;



    public Dochazka(int idStudent, int idVyucovani, StavDochazky stav, String poznamka) {
        this.idStudent = idStudent;
        this.idVyucovani = idVyucovani;
        this.stav = stav;
        this.poznamka = poznamka;
    }

    public int getIdStudent() { return idStudent; }
    public int getIdVyucovani() { return idVyucovani; }
    public StavDochazky getStav() { return stav; }
    public String getPoznamka() { return poznamka; }
}
