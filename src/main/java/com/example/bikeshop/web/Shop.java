package com.example.bikeshop.web;
import com.example.bikeshop.domain.Bike;
import com.example.bikeshop.web.ShoppingCartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/shop")
public class Shop extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        HttpSession session = httpServletRequest.getSession();
        ShoppingCartService cart = (ShoppingCartService) session.getAttribute("cart");
        PrintWriter out = httpServletResponse.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Cart</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div>\n" +
                "\t\t<div class=\"tabs\" style=\"display: inline-block; border: solid 1px #000; text-decoration: none;\"><a href='/bikeshop/shoppingcart'>Cart</a></div>\n" +
                "\t\t<div class=\"tabs\" style=\"display: inline-block; border: solid 1px #000; text-decoration: none;\"><a href='/bikeshop/getBikeData.jsp'>Add Bike</a></div>\n" +
                "\t<div class=\"tabs\" style=\"display: inline-block; border: solid 1px #000; text-decoration: none;\"><a href='/bikeshop/showAllBike.jsp'>Shop</a></div>\n" +
                "\t<div/>");
        out.println("<h1>Order accepted</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}
