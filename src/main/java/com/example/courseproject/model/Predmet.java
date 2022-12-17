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

    public Predmet(String nazvPredmeta, int chasi) {
        this.nazv_predmeta = nazvPredmeta;
        this.chasi = chasi;
    }

    public Predmet(int idPredmet) {
        this.predmet_id = idPredmet;
    }

    public int getPredmet_id() {
        return predmet_id;
    }

    public void setPredmet_id(int predmet_id) {
        this.predmet_id = predmet_id;
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