package com.company.ResponseClasses;

public class Form {
    String id ;
    String is_bot;
    String first_name;
    String username;
    String language_code;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIs_bot() {
        return is_bot;
    }

    public void setIs_bot(String is_bot) {
        this.is_bot = is_bot;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLanguage_code() {
        return language_code;
    }

    public void setLanguage_code(String language_code) {
        this.language_code = language_code;
    }
}
