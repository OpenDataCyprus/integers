<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurants</title>
    </head>
    <body>
        <div align="center">
	        <h1>Restaurants</h1>
	        <h2><a href="add">Add Restaurant</a></h2>
	        
        	<table border="1">
				<c:forEach var="restaurant" items="${restaurantList}">
	        	<tr>
					<td>${restaurant.name}</td>
					<td>
						<a href="edit?id=${restaurant.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="delete?id=${restaurant.id}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
    </body>
</html>
