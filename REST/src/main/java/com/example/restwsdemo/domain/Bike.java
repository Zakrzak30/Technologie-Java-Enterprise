package com.example.restwsdemo.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@Entity
@NamedQueries({
        @NamedQuery(name = "bike.all", query = "Select b from Bike b"),
        @NamedQuery(name = "bike.delete.all", query = "Delete from Bike "),
        @NamedQuery(name = "bikeUser.findByUserFirstName",
                query = "Select a.firstName, a.lastName, b.name from Bike b JOIN b.users a where a.firstName = :firstName")

})
public class Bike {

    private Long id;
    private String name;
    private List<Person> users = new ArrayList<>();
    private double wheel;
    private Producent producent;
    private SerialNumber serial;


    public Bike() {
    }

    public Bike(String name, double price) {
        this.name = name;
        this.wheel = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public double getWheel() {
        return wheel;
    }

    public void setWheel(double wheel) {
        this.wheel = wheel;
    }

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<Person> getUsers() {
        return users;
    }

    public void setUsers(List<Person> users) {
        this.users = users;
    }

    public void addUsers(List<Person> persons) {

        this.setUsers(persons);

        for (Person person : persons) {
            person.getBikes().add(this);
        }
    }


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public Producent getProducent() {
        return producent;
    }

    public void setProducent(Producent producent) {
        this.producent = producent;
    }

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public SerialNumber getSerial() {
        return serial;
    }

    public void setSerial(SerialNumber serial) {
        this.serial = serial;
    }
}
