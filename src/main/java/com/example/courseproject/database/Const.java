package com.example.courseproject.database;

public class Const {
    // Константы для студентов
    public static final String STUDENTS_TABLE = "students";

    public static final String STUDENTS_ID = "students_id";
    public static final String STUDENTS_FAM_NAME_OTCH = "fam_name_otch";
    public static final String STUDENTS_GRUPPAID = "gruppa_id";
    public static final String STUDENTS_STUDBILET = "nomer_stud_bilet";
    public static final String STUDENTS_KURS = "kurs";

    // Константы для юзеров
    public static final String USERS_TABLE = "users";
    public static final String USERS_ID = "user_id";
    public static final String USERS_LOGIN = "login";
    public static final String USERS_PASSWORD = "password";

    public static final String USERS_ROLE = "role";

    // Константы для групп
    public static final String GRUPPA_TABLE = "gruppa";
    public static final String GRUPPA_ID = "gruppa_id";
    public static final String GRUPPA_NOMER = "gruppa_nomer";
    public static final String GRUPPA_GOD_POSTUPLENIA = "god_postuplenia";
    public static final String GRUPPA_FORMA_OBUCHENIA = "forma_obuchenia";
    public static final String GRUPPA_PROFILE_ID = "profile_id";

    //Константы для профиля
    public static final String PROFILE_TABLE = "profile";
    public static final String PROFILE_ID = "profile_id";
    public static final String PROFILE_NAZVANIE_PROFILA = "nazvanie_profila";

    //Константы для предмета
    public static final String PREDMET_TABLE = "predmet";
    public static final String PREDMET_ID = "predmet_id";
    public static final String PREDMET_NAZV_PREDMETA = "nazv_predmeta";
    public static final String PREDMET_CHASI = "chasi";

    // Константы для посещаемости
    public static final String POSESHAEMOST_TABLE = "poseshaemost";
    public static final String POSESHAEMOST_ID = "poseshaemost_id";
    public static final String POSESHAEMOST_DATA = "data";
    public static final String POSESHAEMOST_STUDENTS_ID = "students_id";
    public static final String POSESHAEMOST_PREDMET_ID = "predmet_id";
    public static final String POSESHAEMOST_CHASI_PROPUSKA = "chasi_propuska";
    public static final String POSESHAEMOST_TYPE = "type";
}