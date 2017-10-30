<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="bike" class="com.example.bikeshop.domain.Bike" scope="session" />

<jsp:setProperty name="bike" property="*" />

<jsp:useBean id="storage" class="com.example.bikeshop.service.StorageService" scope="application" />

<%
  storage.addBike(request.getParameter("Name"), Integer.parseInt(request.getParameter("Wheel")),request
  .getParameter("Frame"), Double.parseDouble(request.getParameter("price")));
%>

<p>Following Bikes has been added to storage: </p>
<p>
  <a href="showAllBike.jsp">Show all bikes</a>
</p>
</body>
</html>