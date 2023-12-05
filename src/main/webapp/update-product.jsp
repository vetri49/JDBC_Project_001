<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<jsp:include page="index.jsp"></jsp:include>
<div style=border:2px solid green;text-align:center;padding:20px margin:auto 20%>
    <form method="post" action="update-product">
    <fieldset>
    <legend><h3>Update product form</h3></legend>
    Product Id: <input type="text" name="product-id" id="id">
    Product Name: <input type="text" name="product-name" id="name"><br><br>
    Product Price: <input type="text" name="product-price" id="price"><br><br>
    Product Description: <input type="text" name="product-desc" id="desc"><br><br>
    
    <input type="submit" value="update-product">
    
    </fieldset>
    </form>

</div>

</body>
</html>