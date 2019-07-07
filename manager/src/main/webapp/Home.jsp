<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="commons.SessionReturn" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="javax.servlet.http.Cookie" %>  
<%@ page import="org.hibernate.Query"%>  
<%@ page import="java.util.List" %>  
<%@ page import="manager.mappings.Person" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Cookie ck[]=request.getCookies();
String uperid=ck[0].getValue();
String level=ck[1].getValue();
SessionReturn sr=new SessionReturn();
Session s =sr.sessionReturn();
Query q1=s.createQuery("from Person where personid=150");
//q1.setParameter("p",Integer.parseInt(uperid) );
out.println("uperid"+uperid);
List<?> plist = q1.list();
Person p= (Person)plist.get(0);
String name =p.getFname()+" "+p.getLname();
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%out.println(name);%></title>
</head>
<body>
<%out.println(name); %>
</body>
</html>