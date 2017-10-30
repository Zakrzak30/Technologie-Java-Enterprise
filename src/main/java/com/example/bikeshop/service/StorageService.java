package com.example.bikeshop.service;

import java.util.*;

import com.example.bikeshop.domain.Bike;

public class StorageService {

	private String Name;
	private int Wheel;
	private String Frame;
	private int id = 0;
	private double price;
	Map<Integer, Bike> shopDB = new HashMap<Integer, Bike>();
	public Map<Integer, Bike> getShopDb() {
		return shopDB;
	}

	public void setShopDB(Map<Integer, Bike> shopDb) {
		this.shopDB = shopDB;
	}

	public void addBIke (String Name, int Wheel, String Frame, double price) {
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
