package com.example.foster;

public class User {
    public String firstName;
    public String lastName;
    public String email;
    public String age, weight;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String gender;

    public User() {
    }

    public User(String firstName, String lastName, String age, String weight, String email, String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.weight = weight;
        this.email = email;
        this.gender = gender;
    }
}
