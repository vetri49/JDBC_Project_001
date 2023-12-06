<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Retrieve Product Form</title>
</head>
<body>

<jsp:include page="index.jsp"></jsp:include>


<div style=border:2px solid green;text-align:center;padding:20px margin:auto 20%>

    <form method="post" action="retrieve-product">
    <fieldset>
    <legend><h3>Retrieve product form</h3></legend>
    
    Product Id: <input type="text" name="product-id" id="id"><br><br>
    
   
    
    <input type="submit" value="retrieve-product">
    
    </fieldset>
    </form>

</div>
</body>
</html>