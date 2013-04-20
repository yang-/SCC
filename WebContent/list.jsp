<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="description" content="description"/>
<meta name="keywords" content="keywords"/> 
<meta name="author" content="author"/> 
<link rel="stylesheet" type="text/css" href="default.css" media="screen"/>
<title>施福基督教会 Suffolk Christian Church | 校园团契 Campus Fellowship</title>
</head>
<body>

<div class="header">
	<h1>施福基督教会 Suffolk Christian Church</h1>
	<h2>校园团契 Campus Fellowship</h2>
	<h3>2013年新生接机</h3>
</div>

<div class="navigation">
	<a href="index.html">Home</a>
	<a href="register.html">Register for Airport Pick-up 2013</a>
	<a href="contact-us.html">Contact Us</a>
	<div class="clearer"><span></span></div>
</div>

<div class="container">
	<div class="content">
		<table border=1>
	        <thead>
	            <tr>
	                <th>User Id</th>
	                <th>Name</th>
	                <th>Flight Date</th>
	                <th>Flight Number</th>
	                <th>Arrival Time</th>
	                <th>Arrival Terminal</th>
	                <th>Apartment</th>
	                <th>Off Campus Address</th>
	                <th>QQ</th>
	                <th>QQ Name</th>
	                <th>Email</th>
	                <th>Email</th>
	                <th colspan=2>Action</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach items="${users}" var="user">
	                <tr>
	                    <td><c:out value="${user.userid}" /></td>
	                    <td><c:out value="${user.firstName}${user.lastName}" /></td>
	                    <td><fmt:formatDate pattern="MM/dd/yyyy" value="${user.dob}" /></td>
	                    <td><c:out value="${user.email}" /></td>
	                    <td><a href="UserController?action=edit&userId=<c:out value="${user.userid}"/>" >Update</a></td>
	                    <td><a href="UserController?action=delete&userId=<c:out value="${user.userid}"/>" >Delete</a></td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	    <p><a href="UserController?action=insert">Add User</a></p>
	</div>

	<div class="footer">
		&copy; 2013 <a href="index.html">Suffolk Christian Church Campus Fellowship</a>. All rights reserved.
	</div>

</div>

</body>
</html>