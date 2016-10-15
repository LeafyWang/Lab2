<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background= "23.jpg">
<form action="enter">
<input type="submit" value="Back To Index.">
</form>
<h1 align="center">Books of ${AthrNmS}</h1>
<table align="center" width="700" border="1">
 <tr>
  <th align="center" width="100">ISBN</th>
  <th align="center" width="100">Title</th>
  <th align="center" width="100">Publisher</th>
  <th align="center" width="50">PublishDate</th>
  <th align="center" width="50">Price</th>
  <th align="center" width="50">AuthorID</th>
  <th align="center" width="100">Name</th>
  <th align="center" width="50"> Age</th>
  <th align="center" width="100">Country</th>
 </tr>
 <s:iterator value = "srst1" var= 'it'>
 <tr>
 	<th align="right"><s:property value= '#it.ISBN'/></th>
	<th align="right"><s:property value= '#it.Title'/></th>
 	<th align="right"><s:property value= '#it.Publisher'/></th>
 	<th align="right"><s:property value= '#it.PDate'/></th>
 	<th align="right"><s:property value= '#it.Price'/></th>
 	<th align="right"><s:property value= '#it.AuthorID'/></th>
 	<th align="right"><s:property value= '#it.Name'/></th>
 	<th align="right"><s:property value= '#it.Age'/></th>
 	<th align="right"><s:property value= '#it.Country'/></th>
 	<th align="center"><a href ="Del.action?Dsb=${it.ISBN}">DELETE</a></th>
 	<th align="center"><a href ="FindBook.action?Dsb=${it.ISBN}">UPDATE</a></th>
 </tr>

</s:iterator>

</table>
</body>
</html>