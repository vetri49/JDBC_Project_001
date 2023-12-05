<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Products</title>
</head>
<body>
<jsp:include page="index.jsp"></jsp:include>
<div style=border:2px solid green;text-align:center;padding:20px margin:auto 20%>
    <form method="post" action="delete-product">
    <fieldset>
    <legend><h3>Update product form</h3></legend>
    Product Id: <input type="text" name="product-id" id="id"><br><br>
   
    
    <input type="submit" value="delete-product">
    
    </fieldset>
    </form>

</div>

</body>
</html>