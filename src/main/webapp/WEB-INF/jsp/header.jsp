<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>BK FOODCART</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="shortcut icon" href="<c:url value="/resources/image/favicon.ico"/>" />
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"rel="stylesheet">
<link href="<c:url value="/resources/css/custom.css"/>" rel="stylesheet">
<script src="<c:url value="/resources/js/respond.js"/>"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

<style>
#the-slider img {
	width: 100%;
}

.navbar {
	background-color: #282828  !important ;
}

.navbar li a {
	color: white !important;
}

.navbar li a:hover {
	color: red !important;
}

.navbar-default .navbar-nav>.active>a {
	background-color: blue !important;
}

.navbar {
	padding: 10px;
}
</style>



</head>
<body>


	<p class="center">
		<Strong>
		<h4>
		If a person cares for his health,it is
				difficult to find a doctor who would know what's better for him.
				-Socrates</Strong>
	    </h4>
	</p>
	
	<hr/>
  <style>
hr {
	width: 100%;
	height: 8px;
	margin-left: auto;
	margin-right: auto; 
	background-color: #FF0066;
	color: #FF0066;
	border: 0 none;
}
</style>

 <!-- navigation bar -->
  <div class="navbar navbar-default row">
<div class="navbar-header">
<a class="navbar-brand" href="#">FoodCart</a>

	<ul class="nav  nav-justified">
				
				<li class="active"><a href="home">Home</a></li>
				<li class="active"><a href="about">About</a></li>
				<li class="active"><a href="http://balakannansachin5@gmail.com">Contact</a></li>
				<li class="active"><a href="admin/frontcrud">Products</a></li>
				<c:if test="${pageContext.request.userPrincipal.name != null}">
                            <li class="active"><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
                            <li class="active"><a href="<c:url value="logout" />">Logout</a></li>
                            <c:if test="${pageContext.request.userPrincipal.name == 'admin'}">
                                <li class="active"><a href="<c:url value="admin/" />">Admin</a></li>
                            </c:if>
                            
                        </c:if>

                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <li class="active"><a href="<c:url value="loginpages" />">Login</a></li>
                            <li class="active"><a href="<c:url value="memberShip.obj" />">Register</a></li>
                        </c:if>
                         
                               
                            
                            <c:if test="${pageContext.request.userPrincipal.name != 'admin'}">
				<li><a href="<c:url value="/user/cart" />" class="btn btn-info btn-sm"> <span
						class="glyphicon glyphicon-shopping-cart"></span> View Cart
				</a></li>
				</c:if>
                        
                    </ul>
				
		</div>
		</div>
	
	



	
	<!-- end of navigation bar -->
	