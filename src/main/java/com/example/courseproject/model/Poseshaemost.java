package com.example.courseproject.model;

import com.jfoenix.controls.JFXComboBox;

import java.sql.Date;

public class Poseshaemost {
    private int poseshaemost_id;
    private Date data;
    private int students_id;
    private int predmet_id;
    private int chasi_propuska;
    private String type;


//    public Poseshaemost(String date, int studentId, int predmetId, int chasiPropusk, JFXComboBox<String> comboBoxType) {
//        this.data = Date.valueOf(date);
//        this.students_id = studentId;
//        this.predmet_id = predmetId;
//        this.chasi_propuska = chasiPropusk;
//        this.type = String.valueOf(comboBoxType);
//    }

    public Poseshaemost(int poseshaemost_id, Date data, int students_id, int predmet_id, int chasi_propuska, String type) {
        this.poseshaemost_id = poseshaemost_id;
        this.data = data;
        this.students_id = students_id;
        this.predmet_id = predmet_id;
        this.chasi_propuska = chasi_propuska;
        this.type = type;
    }

    public Poseshaemost(Date date, int studentId, int predmetId, int chasiPropuska, String type) {
        this.data = date;
        this.students_id = studentId;
        this.predmet_id = predmetId;
        this.chasi_propuska = chasiPropuska;
        this.type = type;
    }

    public int getPoseshaemost_id() {
        return poseshaemost_id;
    }

    public void setPoseshaemost_id(int poseshaemost_id) {
        this.poseshaemost_id = poseshaemost_id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getId() {
        return poseshaemost_id;
    }

    public void setId(int id) {
        this.poseshaemost_id = id;
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

    public int getChasi_propuska() {
        return chasi_propuska;
    }

    public void setChasi_propuska(int chasi_propuska) {
        this.chasi_propuska = chasi_propuska;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}