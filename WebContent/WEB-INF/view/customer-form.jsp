<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>${title}</title>
		
		<!-- reference our style sheet -->
		
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/customer-form-style.css" />
	</head>

	
	<body>
	
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
		
		
		<div id="container">
			<h3>${title}</h3>
			
			
			
			<form:form action="saveCustomer" modelAttribute="customer" method="post">
				<table>
					<tbody>
						<tr>
							<td><label>First Name: </label></td>
							<td><form:input type="text" path="firstName"/></td>
						</tr>
						<tr>
							<td><label>Last Name: </label></td>
							<td><form:input type="text" path="lastName"/></td>
						</tr>
						<tr>
							<td><label>Email: </label></td>
							<td><form:input type="text" path="email"/></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save"/></td>
						</tr>
					</tbody>
				</table>
			</form:form>
		
		</div>
		
		
		<input type="button" value="Back to List" class="back-button"
							onclick="window.location.href='${pageContext.request.contextPath}/'; return false;"/>
		
	</body>
</html>