package com.example.bikeshop.web;

import com.example.bikeshop.domain.Bike;
import com.example.bikeshop.service.StorageService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/shop")
public class Shop extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws
            ServletException, IOException {

        StorageService storage = new StorageService();
        Map<Integer, Bike> bikes = storage.getShopDb();
        bikes.put(1, new Bike("INZAI",28,"Aluminium", 2999));
        PrintWriter out = httpServletResponse.getWriter();
        HttpSession session = httpServletRequest.getSession();


        ShoppingCart shoppingCart;
        shoppingCart = (ShoppingCart) session.getAttribute("cart");
        HashMap<String, Double> items = shoppingCart.getCartItems();
        for(String key: items.keySet()){
            out.println("<tr><td>"+key+" - </td><td>"+"$"+items.get(key)+"</td></tr>");
        }
    }
}
