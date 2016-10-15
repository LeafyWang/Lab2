<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Author</title>
</head>
<body background="21.jpg">


<h3 align="center">ID doesn't exist: ${Aut}</h3>

<h4 align="center">Please input his/her information:</h4>

<form action="ADD_A" method="get">
  <p align="center"><input type="hidden" name="Aut" value="${Aut}"/></p>
  <p align="center">Name   : <input type="text" name="AName" /></p>
  <p align="center">Age    : <input type="text" name="AAge" /></p>
  <p align="center">Country: <input type="text" name="ACountry" /></p>
  <p align="center">         		<input type="submit" value="Add Author" /></p>
</form>


<form action="enter">
<input type="submit" value="Leave and create an author">
<p>If you don't know the information of this author, this will create an author whose attributes are null.</p>
</form>


</body>
</html>