package com.example.foster;

public class User {
    public String name, age, weight, height, email;


    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String gender;

    public User() {
    }

    public User(String name, String age, String weight, String height, String email, String gender) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.email = email;
        this.gender = gender;
    }
}
