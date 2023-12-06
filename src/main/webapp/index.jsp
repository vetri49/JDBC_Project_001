<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JDBC CRUD Operations</title>
</head>
<body>
	<div style="text-align:center;border:2px solid green; padding:20px;">
	<h1 >JDBC CRUD Operations</h1>
	<a href="init-connection" > Initialize Connection </a>  |
	<a href="retrieve-product">Retrieve Product</a>  |
	<a href="list-product" > List Product </a> |
	<a href="create-product" > Create Product</a> |
	<a href="update-product" > Update Product </a> | 
	<a href="delete-product" > Delete Product </a> | <br><br>
	
	<a href="add-product-prepstm">Add Product with Prepare statement call</a> |
	<a href="add-product-callablestm">Add Product with Callable statement call</a> |<br><br>
	
	<a href="create-db">Create Database</a> |
	<a href="drop-db">Drop Database</a> |<br><br>
	
	<a href="add-multiproducts">Add multiple products</a>
	</div>
</body>
</html>