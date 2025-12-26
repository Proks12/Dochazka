package model;


import java.time.LocalDate;

public class Student {
    private int id;
    private String jmeno;
    private String prijmeni;
    private LocalDate datumNarozeni;
    private boolean aktivni;

    public Student(int id, String jmeno, String prijmeni, LocalDate datumNarozeni, boolean aktivni) {
        this.id = id;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.aktivni = aktivni;
    }

    public int getId() { return id; }
    public boolean isAktivni() { return aktivni; }
}
