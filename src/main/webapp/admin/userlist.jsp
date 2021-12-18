<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Menu | CafeOS</title>
	</head>
	<body>
		<%@ page import="com.cafeos.DAO.UserDAO, com.cafeos.bean.User, java.util.*" %>
		<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		
		<%
			List<User> list = UserDAO.getAllUser();
			request.setAttribute("list", list);
		%>
		
		<h1>Menu List - CafeOS</h1>
		
		<table border="1" style="width: 100%; margin-top: 20px;">
			<tr>
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
				<th>Password</th>
				<th>Admin?</th>
			</tr>
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.getUserId()}</td>
					<td>${item.getfName()}</td>
					<td>${item.getlName()}</td>
					<td>${item.getEmail()}</td>
					<td>${item.getPassword()}</td>
					<td>${item.getIsAdmin()}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>