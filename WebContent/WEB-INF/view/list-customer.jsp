<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>${title}</title>
		
		<!-- reference our style sheet -->
		
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>

	
	<body>
	
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>
	
		<div id="container">
	
			<div id="content">
			
				  <!--  add a search box -->
	            <form:form action="searchCustomer" method="POST">
	                Search customer: <input type="text" name="theSearchName" />
	                <input type="submit" value="Search" class="search-button" />
	            </form:form>
				
				
	
				<!--  add our html table here -->
	
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th style="width: 150px;">Action</th>
					</tr>
	
					<!-- loop over and print our customers -->
					<c:forEach var="tempCustomer" items="${customers}">
					
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
						
						<c:url var="deleteLink" value="/customer/deleteCustomer">
							<c:param name="customerId" value="${tempCustomer.id}" />
						</c:url>
	
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
							<td>
								<a class="update" href="${updateLink}">Update</a> | 
								<a class="delete" href="${deleteLink}"
									onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false;">
									Delete</a>
							</td>
						</tr>
	
					</c:forEach>
	
				</table>
				
				
				<!-- button to add customer -->
				<input type="button" value="Add Customer"
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button"/>
	
			</div>
	
		</div>
	
	</body>
</html>