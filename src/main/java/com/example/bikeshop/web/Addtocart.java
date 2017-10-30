package com.example.bikeshop.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/addtocart")
public class Addtocart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws
            ServletException, IOException {

        httpServletResponse.setCharacterEncoding("text/html;charset=UTF-8");
        HttpSession session = httpServletRequest.getSession();
        PrintWriter out = httpServletResponse.getWriter();
        ShoppingCart shoppingCart;
        shoppingCart = (ShoppingCart) session.getAttribute("cart");

        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            session.setAttribute("cart", shoppingCart);
        }

          String Name = httpServletRequest.getParameter("Name");
          Double price = Double.parseDouble(httpServletRequest.getParameter("price"));
          shoppingCart.addToCart(Name, price);

          HashMap<String, Integer> items = shoppingCart.getCartItems();
            for(String key: items.keySet())
                    out.println("<tr><td>"+key+" - </td><td>"+"$"+items.get(key)+"</td></tr>");
          out.println("<!DOCTYPE html>");
          out.println("<html>");
          out.println("<head>");
          out.println("<title>result</title>");
          out.println("</head>");
          out.println("<body>");
          out.println("<h1>Produkt został dodany do twojego koszyka</h1>");
          out.println("<hr>");
          out.println("<h2>Cart</h2>");
          out.println("<table border='1px'>");

          out.println("<table>");
          out.println("</body>");
          out.println("</html>");

    }
}
