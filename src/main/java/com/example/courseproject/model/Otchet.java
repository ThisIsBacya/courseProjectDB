package com.example.courseproject.model;

import java.sql.Date;

public class Otchet {
    private String fam_name_otch;
    private Date data;
    private String nazv_predmeta;
    private int kurs;
    private String gruppa_nomer;
    private String nazvanie_profila;
    private String type;

    public Otchet(String fam_name_otch, Date data, String nazv_predmeta, int kurs, String gruppa_nomer, String nazvanie_profila, String type) {
        this.fam_name_otch = fam_name_otch;
        this.data = data;
        this.nazv_predmeta = nazv_predmeta;
        this.kurs = kurs;
        this.gruppa_nomer = gruppa_nomer;
        this.nazvanie_profila = nazvanie_profila;
        this.type = type;
    }

    public String getFam_name_otch() {
        return fam_name_otch;
    }

    public void setFam_name_otch(String fam_name_otch) {
        this.fam_name_otch = fam_name_otch;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getNazv_predmeta() {
        return nazv_predmeta;
    }

    public void setNazv_predmeta(String nazv_predmeta) {
        this.nazv_predmeta = nazv_predmeta;
    }

    public int getKurs() {
        return kurs;
    }

    public void setKurs(int kurs) {
        this.kurs = kurs;
    }

    public String getGruppa_nomer() {
        return gruppa_nomer;
    }

    public void setGruppa_nomer(String gruppa_nomer) {
        this.gruppa_nomer = gruppa_nomer;
    }

    public String getNazvanie_profila() {
        return nazvanie_profila;
    }

    public void setNazvanie_profila(String nazvanie_profila) {
        this.nazvanie_profila = nazvanie_profila;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
