package com.example.courseproject.model;

public class Student {
    private int students_id;
    private String fam_name_otch;
    private int gruppa_id;
    private String nomer_stud_bilet;
    private int kurs;

    public Student(int students_id, String fam_name_otch, int gruppa_id, String nomer_stud_bilet, int kurs) {
        this.students_id = students_id;
        this.fam_name_otch = fam_name_otch;
        this.gruppa_id = gruppa_id;
        this.nomer_stud_bilet = nomer_stud_bilet;
        this.kurs = kurs;
    }

    public Student() {

    }

    public String getFam_name_otch() {
        return fam_name_otch;
    }

    public void setFam_name_otch(String FIO) {
        this.fam_name_otch = FIO;
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
    public int getStudents_id() {
        return students_id;
    }

    public void setStudents_id(int students_id) {
        this.students_id = students_id;
    }


}
