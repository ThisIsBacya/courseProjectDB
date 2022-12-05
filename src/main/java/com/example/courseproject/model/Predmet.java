package com.example.courseproject.model;

public class Predmet {

    private int predmet_id;
    private String nazv_predmeta;
    private int chasi;

    public Predmet(int predmet_id, String nazv_predmeta, int chasi) {
        this.predmet_id = predmet_id;
        this.nazv_predmeta = nazv_predmeta;
        this.chasi = chasi;
    }

    public String getNazv_predmeta() {
        return nazv_predmeta;
    }

    public void setNazv_predmeta(String nazv_predmeta) {
        this.nazv_predmeta = nazv_predmeta;
    }

    public int getChasi() {
        return chasi;
    }

    public void setChasi(int chasi) {
        this.chasi = chasi;
    }
}
