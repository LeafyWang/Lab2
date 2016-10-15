<%@taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
</head>
<body background="21.jpg">
<form action="enter">
<input type="submit" value="Back to index.">
</form>
<h1 align="center">Update</h1>
<p align="center">You can now change attributes of the book.</p>
 <form action="UpBook" method="get">
<table align="center" width="600" border="2">
 <tr>
  <th align="center">ISBN</th>
  <th align="center">Title</th>
  <th align="center">AuthorID</th>
  <th align="center">Publisher</th>
  <th align="center">PublishDate</th>
  <th align="center">Price</th>

 </tr>

 <s:iterator value = "srst" var= 'it'>
 <input type="hidden" name="ISt" value ='${it.ISBN}'/>
 <tr>
 	<th align="right"><s:property value= '#it.ISBN'/></th>
	<th align="right"><s:property value= '#it.Title'/></th>
 	<th><input type="text" name="Aut" value ='${AuthorID}'/></th>
 	<th><input type="text" name="Pst" value ='${Publisher}'/></th>
 	<th><input type="text" name="Pdt" value ='${PDate}' /></th>
 	<th><input type="text" name="Prt" value ='${Price}'/></th>
 	<th><input type="submit" value="Update" /></th>
 </tr>
</s:iterator>
</table>
</form>
<h4 align="center">If you want to change the PublishDate, please enter 8 numbers such as 20160925 into the input blank.</h4>

</body>
</html>