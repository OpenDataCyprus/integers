<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurant Categories</title>
    </head>
    <body>
        <div align="center">
	        <h1>Restaurant Categories</h1>
	        <h2><a href="category/add">Add Restaurant Category</a></h2>
	        
        	<table border="1">
				<c:forEach var="restaurantCategory" items="${restaurantCategoryList}">
	        	<tr>
					<td>${restaurantCategory.description}</td>
					<td>
						<a href="category/edit?id=${restaurantCategory.id}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<a href="category/delete?id=${restaurantCategory.id}">Delete</a>
					</td>
	        	</tr>
				</c:forEach>	        	
        	</table>
        </div>
    </body>
</html>
