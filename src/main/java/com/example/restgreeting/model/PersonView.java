package com.example.restgreeting.model;

public class PersonView {
    private String name;
    private String lastName;

    public PersonView(String name, String lastName) {
        this.setName(name);
        this.setLastName(lastName);
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
