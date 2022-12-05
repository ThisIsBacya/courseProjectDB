package com.example.courseproject.model;

public class Gruppa {

    private String gruppa_id;
    private String gruppa_nomer;
    private String god_postuplenia;
    private String profile_id;
    private String forma_obuchenia;

    public Gruppa(int gruppa_id, String gruppa_nomer, int god_postuplenia, int profile_id, String forma_obuchenia) {
    }

    public String getGruppa_id() {
        return gruppa_id;
    }

    public void setGruppa_id(String gruppa_id) {
        this.gruppa_id = gruppa_id;
    }
    public String getGruppa_nomer() {
        return gruppa_nomer;
    }

    public void setGruppa_nomer(String gruppa_nomer) {
        this.gruppa_nomer = gruppa_nomer;
    }

    public String getGod_postuplenia() {
        return god_postuplenia;
    }

    public void setGod_postuplenia(String god_postuplenia) {
        this.god_postuplenia = god_postuplenia;
    }

    public String getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(String profile_id) {
        this.profile_id = profile_id;
    }

    public String getForma_obuchenia() {
        return forma_obuchenia;
    }

    public void setForma_obuchenia(String forma_obuchenia) {
        this.forma_obuchenia = forma_obuchenia;
    }
}
