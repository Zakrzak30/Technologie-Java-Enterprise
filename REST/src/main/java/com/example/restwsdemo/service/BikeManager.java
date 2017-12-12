package com.example.restwsdemo.service;

import com.example.restwsdemo.domain.Bike;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class BikeManager {

    @PersistenceContext
    EntityManager em;

    public void addBike(Bike bike) {
        em.persist(bike);
    }

    public void deleteBike(Bike bike) {
        em.remove(bike);
    }

    public Bike getBike(Long id) {
        return em.find(Bike.class, id);
    }

    public Bike updateBike(Bike bike) {
        return em.merge(bike);
    }

    @SuppressWarnings("unchecked")
    public List<Bike> getAllBikes() {
        return em.createNamedQuery("bike.all").getResultList();
    }

    @SuppressWarnings("unchecked")
    public List<Object[]> getBikeOfUserByUserName(String firstName) {
        return em.createNamedQuery("bikeUser.findByUserFirstName").setParameter("firstName", firstName).getResultList();
    }

    public void deletAll() {
        em.createNamedQuery("bike.delete.all").executeUpdate();
    }

}
