package com.example.bikeshop.web;

import java.util.HashMap;

public class ShoppingCart {

    HashMap<String, Double> cartItems;

    public ShoppingCart(){
        cartItems = new HashMap<>();

    }

    public HashMap getCartItems(){
        return cartItems;
    }

    public void addToCart(String itemId, double price){
        cartItems.put(itemId, price);
    }


}