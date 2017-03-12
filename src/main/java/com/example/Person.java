package com.example;

import org.springframework.context.annotation.Bean;

import javax.ejb.EJB;
import javax.persistence.Id;

/**
 * Created by ggladko97 on 12.03.17.
 */

class Person{

    private int id;
    private String name;
    private String prof;

    public Person() {
    }

    public Person(int id, String name, String prof) {
        this.id = id;
        this.name = name;
        this.prof = prof;
    }

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

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }
}