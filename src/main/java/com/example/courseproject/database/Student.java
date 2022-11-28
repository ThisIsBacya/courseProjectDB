package com.example.courseproject.database;

public class Student {
    private String FIO;
    private String gruppa_id;
    private String nomer_stud_bilet;
    private String kurs;

    public Student(String FIO, String gruppa_id, String nomer_stud_bilet, String kurs) {
        this.FIO = FIO;
        this.gruppa_id = gruppa_id;
        this.nomer_stud_bilet = nomer_stud_bilet;
        this.kurs = kurs;
    }

    public Student() {

    }

    public String getFIO() {
        return FIO;
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public String getGruppa_id() {
        return gruppa_id;
    }

    public void setGruppa_id(String gruppa_id) {
        this.gruppa_id = gruppa_id;
    }

    public String getNomer_stud_bilet() {
        return nomer_stud_bilet;
    }

    public void setNomer_stud_bilet(String nomer_stud_bilet) {
        this.nomer_stud_bilet = nomer_stud_bilet;
    }

    public String getKurs() {
        return kurs;
    }

    public void setKurs(String kurs) {
        this.kurs = kurs;
    }

}
