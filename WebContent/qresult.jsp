<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The result</title>
</head>

<body background="23.jpg">

<form action="enter">
<input type="submit" value="Back To Index.">
</form>

<h3 align="center">The books of Author are printed below:</h3>

<table align="center" width="600" border="1">
 <tr>
  <th align="center">ISBN</th>
  <th align="center">Title</th>
 </tr>
 <s:iterator value = "srst" var= 'it'>
 <tr>
 	<th align="right"><s:property value= '#it.ISBN'/></th>
	<th align="right"><a href ="QISBN.action?Isb=${it.ISBN}"><s:property value= '#it.Title'/></a></th>
	<th align="center"><a href ="Del.action?Dsb=${it.ISBN}">DELETE</a></th>
	<th align="center"><a href ="FindBook.action?Dsb=${it.ISBN}">UPDATE</a></th>
 </tr>
</s:iterator>
</table>

</body>

</html>