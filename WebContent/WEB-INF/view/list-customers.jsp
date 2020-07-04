<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>

<!-- reference the css file -->
	<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>

<body>

	<div id="wrapper">
		<div id="header">
		<h2> Customer Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		
			<!-- Add Button for adding new customer -->
			<input type="button" value="Add Customer" class="add-button"
				   onclick="window.location.href='showFormForAdd'; return false;"
			/>
		
			<!-- html table here -->
			<table>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email</th>
			</tr>
			
			<!-- loap over and print customers -->
			<c:forEach var="tempCustomer" items="${customers}">
				<tr>
					<td>${tempCustomer.firstName} </td>
					<td>${tempCustomer.lastName} </td>
					<td>${tempCustomer.email} </td>
				</tr>
			</c:forEach>
			
			</table>
		
		</div>
	</div>

</body>


</html>