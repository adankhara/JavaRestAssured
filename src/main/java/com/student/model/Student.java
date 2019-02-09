package com.student.model;

import java.util.List;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String programme;
    private List<String> courses;

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public Student setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Student setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Student setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getProgramme() {
        return programme;
    }

    public Student setProgramme(String programme) {
        this.programme = programme;
        return this;
    }

    public List<String> getCourses() {
        return courses;
    }

    public Student setCourses(List<String> courses) {
        this.courses = courses;
        return this;
    }
}
