package model;


import java.time.LocalDateTime;

public class Vyucovani {
    private int id;
    private int idPredmet;
    private LocalDateTime datumCas;

    public Vyucovani(int id, int idPredmet, LocalDateTime datumCas) {
        this.id = id;
        this.idPredmet = idPredmet;
        this.datumCas = datumCas;
    }

    public int getIdPredmet() { return idPredmet; }
}
