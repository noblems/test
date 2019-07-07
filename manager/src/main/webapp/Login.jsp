<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="commons.SessionReturn" %>
<%@ page import="org.hibernate.Session" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
<form action="Login" name="login" method="post">
<br>Username<input type="text" name="uname">
<br>password<input type="password" name="passwd">
<br> <input type="submit" value="Login">
<input type="reset" value="Reset">
 </form>
</body>
</html>