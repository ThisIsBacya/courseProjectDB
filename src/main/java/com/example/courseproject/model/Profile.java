package com.example.courseproject.model;

public class Profile {
    private int profile_id;
    private String nazvanie_profila;
    public Profile(int profile_id, String nazvanie_profila) {
        this.profile_id = profile_id;
        this.nazvanie_profila = nazvanie_profila;
    }

    public Profile(String nazvanie_profila) {
        this.nazvanie_profila = nazvanie_profila;
    }

    public Profile(int idProfile) {
        this.profile_id = idProfile;
    }

    public String getNazvanie_profila() {
        return nazvanie_profila;
    }

    public void setNazvanie_profila(String nazvanie_profila) {
        this.nazvanie_profila = nazvanie_profila;
    }

    public int getProfile_id() {
        return profile_id;
    }

    public void setProfile_id(Integer profile_id) {
        this.profile_id = profile_id;
    }
}
