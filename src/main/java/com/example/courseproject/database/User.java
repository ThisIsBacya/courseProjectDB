package com.example.courseproject.database;

public class User {
    private String login;
    private String password;
    private String level_access;

    public User(String login, String password, String level_access) {
        this.login = login;
        this.password = password;
        this.level_access = level_access;
    }

    public User() {}

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLevel_access(int i) {
        return level_access;
    }

    public void setLevel_access(String level_access) {
        this.level_access = level_access;
    }
}
