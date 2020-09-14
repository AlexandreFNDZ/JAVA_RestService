package com.example.restgreeting.gateway.model;

public class Person {

    private final long id;
    private final String name;
    private final String lastName;

    public Person(long id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}
