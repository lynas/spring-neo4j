package com.lynas.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.List;

/**
 * Created by LynAs on 7/16/2016
 */
@NodeEntity(label = "Organization")
public class Organization {
    @GraphId
    private Long id;
    private String name;
    private int age;

    @Relationship(type = "HAS", direction = Relationship.OUTGOING)
    private List<Person> person;

    public Organization() {
    }

    public Organization(Long id, String name, int age, List<Person> person) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.person = person;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }
}
