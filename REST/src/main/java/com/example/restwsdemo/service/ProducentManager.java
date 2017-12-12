package com.example.restwsdemo.service;

import com.example.restwsdemo.domain.Producent;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProducentManager {

    @PersistenceContext
    EntityManager em;

    public void addProducent(Producent producent) {
        em.persist(producent);
    }

    public void deleteProducent(Producent producent) {
        em.remove(producent);
    }

    public Producent getProducent(Long id) {
        return em.find(Producent.class, id);
    }

    public Producent updateProducent(Producent producent) {
        return em.merge(producent);
    }

}
