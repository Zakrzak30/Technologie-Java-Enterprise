<%@page import="com.example.bikeshop.domain.Bike"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<jsp:useBean id="storage" class="com.example.bikeshop.service.StorageService" scope="application" />
<jsp:useBean id="bike" class="com.example.bikeshop.domain.Bike" scope="application"/>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<div id="topdiv">
	<div class="tabs"><a href='/bikeshop/shoppingcart'>Cart</div>
	<div class="tabs"><a href='/bikeshop/getBikeData.jsp'>Add Bike</div>
	<div class="tabs"><a href='/bikeshop/shop'>Shop</a></div>
	<div/>
	  <%
	      java.util.Map<Integer, com.example.bikeshop.domain.Bike> bikes = storage.getShopDb();
          for (java.util.Map.Entry<Integer, com.example.bikeshop.domain.Bike> entry : bikes.entrySet()) {
                            out.println("<form action=\"addtocart\" >\n" +
                                    "<th>Name </th>"+entry.getValue().getName()+" <th>Price</th>" +entry.getValue().getPrice()+"<th>Add to cart</th>\n" +
                                    "\n" +
                                    "<td><input type=\"hidden\" name=\"Name\" value=\""+entry.getValue().getName()
                                    +"\">\n" +
                                    "<input type=\"hidden\" name=\"price\" value=\""+entry.getValue().getPrice()+"\">\n"

                                    +
                                    "<input type=\"submit\" value=\"Add to cart\"></td></tr>\n" +
                                    "</form>");
                        }
      %>

</body>
</html>
