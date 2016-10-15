<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html lang="en-US">

<head>
<title>Library System</title>
<meta charset="UTF-8">

<style>
.area {
float: left;
margin: 5px;
padding: 15px;
width: 300px;
height: 400px;
border: 1px solid grey;
} 
</style>

</head>


<body background= "22.jpg">

<h1 align="right">Library System</h1>
<h2 align="right">personal library system management.</h2>

<br>

<div class="area">
<h3>Prompt: </h3>
<p>${Prompt}</p>
</div>

<div class="area">
<h2>Search</h2>
<p>input an author's name and find all his books.</p>
<form action="Search" method="get">
    <p>name: <input type="text" name="AthrNmS" /></p>
    <p align="right"><input type="submit" value="Submit" /></p>
</form>
</div>

<div class="area">
<h2>Insert</h2>
<p>input messages of a book.</p>
<form action="ADD" method="get">
  	<p>ISBN: <input type="text" name="ISt" placeholder="Enter 13 numbers as ISBN!" pattern="^[0-9]{13}$" required="required"/></p>
 	<p>Title: <input type="text" name="Tit" required="required"/></p>
	<p>AuthorID: <input type="text" name="Aut" placeholder="Please enter only numbers!" pattern="[0-9]*" required="required"/></p>
 	<p>Publisher: <input type="text" name="Pst" placeholder="HIT PRESS" required="required"/></p>
  	<p>PublishDate: <input type="text" name="Pdt" placeholder="20160925(8 numbers only)" pattern="[0-9]{8}" required="required"/></p>
  	<p>Price: <input type="text" name="Prt" pattern="^[0-9]+(.[0-9])?([0-9])?$"required="required"/></p>
  	<p align="right"><input type="submit"  value="ADD"/></p>
</form>
</div>

</body>
</html>