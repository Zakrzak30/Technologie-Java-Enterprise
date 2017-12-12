package com.example.restwsdemo.domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class BikeResponse {
    private List<Bike> bike;

    public List<Bike> getBike() {
        return bike;
    }

    public void setBike(List<Bike> bike) {
        this.bike = bike;
    }
}
