package com.example.courseproject.model;

public class Gruppa {

    private int gruppa_id;
    private String gruppa_nomer;
    private int god_postuplenia;
    private int profile_id;
    private String forma_obuchenia;

    public Gruppa(int gruppa_id, String gruppa_nomer, int god_postuplenia, int profile_id, String forma_obuchenia) {
        this.gruppa_id = gruppa_id;
        this.gruppa_nomer = gruppa_nomer;
        this.god_postuplenia = god_postuplenia;
        this.profile_id = profile_id;
        this.forma_obuchenia = forma_obuchenia;
    }

    public Gruppa(String gruppaNomer, int profileId, int gopPostuplenia, String formaObuchenia) {
        this.gruppa_nomer = gruppaNomer;
        this.profile_id = profileId;
        this.god_postuplenia = gopPostuplenia;
        this.forma_obuchenia = formaObuchenia;
    }

    public Gruppa(int idGruppa) {
        this.gruppa_id = idGruppa;
    }

    public int getGruppa_id() {
        return gruppa_id;
    }

    public void setGruppa_id(int gruppa_id) {
        this.gruppa_id = gruppa_id;
    }
    public String getGruppa_nomer() {
        return gruppa_nomer;
    }

    public void setGruppa_nomer(String gruppa_nomer) {
        this.gruppa_nomer = gruppa_nomer;
    }

    public int getGod_postuplenia() {
        return god_postuplenia;
    }

    public void setGod_postuplenia(int god_postuplenia) {
        this.god_postuplenia = god_postuplenia;
    }

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(int profile_id) {
        this.profile_id = profile_id;
    }

    public String getForma_obuchenia() {
        return forma_obuchenia;
    }

    public void setForma_obuchenia(String forma_obuchenia) {
        this.forma_obuchenia = forma_obuchenia;
    }
}