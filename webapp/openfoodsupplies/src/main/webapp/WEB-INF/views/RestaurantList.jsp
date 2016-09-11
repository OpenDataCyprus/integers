<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Restaurants</title>
        <link href="resources/css/styling.css" rel="stylesheet"/>
		<link href="resources/css/bootstrap.min.css" rel="stylesheet"/>
		<script type="text/javascript" src="resources/js/jquery-1.11.1.min.js"></script>
    </head>
    <body>
        <div align="center">
	        <h1>Nicosia Municipality</h1>
	       	<div class="container">
			  <h2><a href="add">Restaurants</a></h2>
			  <table class="table table-hover">
			    <thead>
			      <tr>
			        <th>Name</th>
        			<th>Category</th>
        			<th>Contributor</th>
        			<!-- <th>Municipality</th> -->
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach var="restaurant" items="${restaurantList}">
		        	<tr>
		        		<td>${restaurant.name}</td>
						<td>${restaurant.categoryDescription}</td>
						<%-- <td>${restaurant.municipalityName}</td> --%>
						<td>
							<a href="restaurant/edit?id=${restaurant.id}">Info</a>
							<%-- &nbsp;&nbsp;&nbsp;&nbsp;
							<a href="restaurant/delete?id=${restaurant.id}">Delete</a> --%>
						</td>
		        	</tr>
					</c:forEach>
			    </tbody>
			  </table>
			</div>
        </div>
    </body>
</html>
