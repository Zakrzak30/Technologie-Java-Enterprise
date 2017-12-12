package com.example.restwsdemo.service;

import com.example.restwsdemo.domain.SerialNumber;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SerialNumberManeger {

    @PersistenceContext
    EntityManager entityManager;

    public void addSerialNumber(SerialNumber serial) {
        entityManager.persist(serial);
    }

    public void deleteSerialNumber(SerialNumber serial) {
        entityManager.remove(serial);
    }

    public SerialNumber getSerialNumber(Long id) {
        return entityManager.find(SerialNumber.class, id);
    }

    public SerialNumber updateSerialNumber(SerialNumber serial) {
        return entityManager.merge(serial);
    }

}
