<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<title>Bike data</title>
<jsp:useBean id="storage" class="com.example.bikeshop.service.StorageService" scope="application" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<div id="topdiv">
	<div class="tabs"><a href='/bikeshop/shoppingcard'>Shopping Card</div>
	<div class="tabs"><a href='/bikeshop/getBikeData.jsp'>Add Bike</div>
	<div class="tabs"><a href='/bikeshop/shop'>Shop</a></div>
	<div/>
	<form action="addBike.jsp">
      NAME : <input type="text" name="Name" required/>
      WHEEL   : <input type="text" name="Wheel" required />
      FRAME   : <input type="text" name="Frame" required/>
      PRICE : <input type="text" name="price" required/>
      <input type="submit" value=" OK ">
    </form>
</body>
</html>
