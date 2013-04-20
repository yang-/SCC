<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>施福基督教会 Suffolk Christian Church | 校园团契</title>
	<style type="text/css">
		nav ul {
			list-style-type: none;
		}
		nav ul li {
			display:inline;
		}
	</style>
</head>
<body>
	<nav>
		<ul>
			<li><a href="index.html">Home</a></li>
			<li><a href="register.html">Register for Airport Pick-up</a></li>
			<li><a href="listUser.jsp">Show all users</a></li>
		</ul>
	</nav>
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
</body>
</html>