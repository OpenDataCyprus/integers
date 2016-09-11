<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Restaurant Category Page</title>
	</head>
	<body>
		<div align="center">
			<h1>Restaurant Category Page</h1>
			<table>
				<form:form action="save" method="post" modelAttribute="restaurantCategory">
				<form:hidden path="id"/>
				<tr>
					<td>Description:</td>
					<td><form:input path="description"/></td>
				</tr>
				<tr>
					<td colspan="2" align="right">
						<input type="submit" value="Save">
					</td>
				</tr>			
				</form:form>
			</table>
		</div>
	</body>
</html>