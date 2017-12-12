package com.example.bikeshop.service;

import java.util.*;

import com.example.bikeshop.domain.Bike;

public class StorageService {


	private int id = 0;

	Map<Integer, Bike> shopDB = new HashMap<Integer, Bike>();
	public Map<Integer, Bike> getShopDb() {
		return shopDB;
	}

	public void setShopDB(Map<Integer, Bike> shopDB) {
		this.shopDB = shopDB;
	}

	public void addBike (String Name, int Wheel, String Frame, double price) {
		++id;
		this.shopDB.put(id,new Bike(Name, Wheel, Frame, price));
	}

	public Bike findBikeById(int id) {
		for (Map.Entry<Integer, Bike> entry : shopDB.entrySet()){
			if (entry.getKey() == id) {
				return entry.getValue();
			}
		}
		return null;
	}

}
