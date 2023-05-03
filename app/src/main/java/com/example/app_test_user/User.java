package com.example.app_test_user;

public class User {

    public String  first_name, second_name, email, number, pass;

    public User() {
    }

    public User(String first_name, String sec_name, String email, String number, String pass) {
        this.first_name = first_name;
        this.second_name = sec_name;
        this.email = email;
        this.number = number;
        this.pass = pass;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getPass() {
        return pass;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
