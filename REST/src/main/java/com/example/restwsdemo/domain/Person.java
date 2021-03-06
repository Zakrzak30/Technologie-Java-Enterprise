package com.example.restwsdemo.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
public class Person {

    private Long id;
    private String firstName;
    private String lastName;
    private List<Bike> bikes = new ArrayList<>();


    public Person(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<Bike> getBikes() {
        return bikes;
    }

    public void setBikes(List<Bike> bikes) {
        this.bikes = bikes;
    }
}
