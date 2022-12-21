package com.example.courseproject.model;

import java.sql.Date;

public class Queries {
    private Date data;
    private String nazv_predmeta;
    private String fam_name_otch;
    private int chasi_propuska;
    private int poseshaemost_id;
    private int students_id;
    private int predmet_id;
    private String type;
    private int gruppa_id;
    private String nomer_stud_bilet;
    private int kurs;
    private String gruppa_nomer;
    private String nazvanie_profila;
    private int max;

    public Queries(int poseshaemost_id, Date data, int students_id, int predmet_id, int chasi_propuska, String type) {
        this.poseshaemost_id = poseshaemost_id;
        this.data = data;
        this.students_id = students_id;
        this.predmet_id = predmet_id;
        this.chasi_propuska = chasi_propuska;
        this.type = type;
    }

    public Queries(String fam_name_otch, Date data, String nazv_predmeta, int chasi_propuska, String type) {
        this.fam_name_otch = fam_name_otch;
        this.data = data;
        this.nazv_predmeta = nazv_predmeta;
        this.chasi_propuska = chasi_propuska;
        this.type = type;
    }

    public Queries(String fam_name_otch, Date data, String nazv_predmeta, String type) {
        this.fam_name_otch = fam_name_otch;
        this.data = data;
        this.nazv_predmeta = nazv_predmeta;
        this.type = type;
    }

    public Queries(int students_id, String fam_name_otch, String nomer_stud_bilet, int kurs) {
        this.students_id = students_id;
        this.fam_name_otch = fam_name_otch;
        this.nomer_stud_bilet = nomer_stud_bilet;
        this.kurs = kurs;
    }

    public Queries(String fam_name_otch) {
        this.fam_name_otch = fam_name_otch;
    }

    public Queries(String fam_name_otch, String gruppa_nomer) {
        this.fam_name_otch = fam_name_otch;
        this.gruppa_nomer = gruppa_nomer;
    }

    public Queries(String fam_name_otch, String nazv_predmeta, Date data) {
        this.fam_name_otch = fam_name_otch;
        this.nazv_predmeta = nazv_predmeta;
        this.data = data;
    }

    public Queries(String fam_name_otch, String gruppa_nomer, String nomer_stud_bilet) {
        this.fam_name_otch = fam_name_otch;
        this.gruppa_nomer = gruppa_nomer;
        this.nomer_stud_bilet = nomer_stud_bilet;
    }

    public Queries(String fam_name_otch, Date data, String nazv_predmeta, String gruppa_nomer, String type) {
        this.fam_name_otch = fam_name_otch;
        this.data = data;
        this.nazv_predmeta = nazv_predmeta;
        this.gruppa_nomer = gruppa_nomer;
        this.type = type;
    }

    public Queries(int max) {
        this.max = max;
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

    public String getFam_name_otch() {
        return fam_name_otch;
    }

    public void setFam_name_otch(String fam_name_otch) {
        this.fam_name_otch = fam_name_otch;
    }

    public int getChasi_propuska() {
        return chasi_propuska;
    }

    public void setChasi_propuska(int chasi_propuska) {
        this.chasi_propuska = chasi_propuska;
    }

    public int getPoseshaemost_id() {
        return poseshaemost_id;
    }

    public void setPoseshaemost_id(int poseshaemost_id) {
        this.poseshaemost_id = poseshaemost_id;
    }

    public int getStudents_id() {
        return students_id;
    }

    public void setStudents_id(int students_id) {
        this.students_id = students_id;
    }

    public int getPredmet_id() {
        return predmet_id;
    }

    public void setPredmet_id(int predmet_id) {
        this.predmet_id = predmet_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getGruppa_id() {
        return gruppa_id;
    }

    public void setGruppa_id(int gruppa_id) {
        this.gruppa_id = gruppa_id;
    }

    public String getNomer_stud_bilet() {
        return nomer_stud_bilet;
    }

    public void setNomer_stud_bilet(String nomer_stud_bilet) {
        this.nomer_stud_bilet = nomer_stud_bilet;
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


}
