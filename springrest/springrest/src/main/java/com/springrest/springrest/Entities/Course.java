package com.springrest.springrest.Entities;

public class Course {

    int id;
    String name;
    String description;

    public Course(int id, String name, String description) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
    }
    public Course()
    {super();}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
