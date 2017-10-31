package com.example.bikeshop.web;

import com.example.bikeshop.web.ShoppingCartService;

//import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/shoppingcart")
public class ShoppingCart extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.setContentType("text/html");
        HttpSession session = httpServletRequest.getSession();
        ShoppingCartService shoppingCart = (ShoppingCartService) session.getAttribute("cart");

        PrintWriter out = httpServletResponse.getWriter();

        HashMap<String, Double> items = shoppingCart.getCartItems();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cart</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Bike added to cart</h1>");
        out.println("<hr>");
        out.println("<h2>Bikes in cart</h2>");
        out.println("<table border='1px'>");
        for(String key: items.keySet())
            out.println("<form><input type='hidden' name='name' value='"+key+"'><tr><td>"+key+" - </td><td>"+"$"+items.get(key)+"</td><td></td></tr></form>");
        out.println("<table>");
        out.println("</body>");
        out.println("</html>");
    }
}
