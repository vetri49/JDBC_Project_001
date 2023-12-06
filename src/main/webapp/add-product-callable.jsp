<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product Form</title>
</head>
<body>
  <jsp:include page="index.jsp"></jsp:include><br>
  
  <div style=text-align:center; border:2px solid green;padding:20 px>
  <form method="post" action="add-product-callable">
  <fieldset>
			<legend><h3>Add Product Form</h3></legend>
			
			Product Name :          <input type="text" name="product_name" id="name"> <br><br>
			
			
			      Product Description :   <input type="text" name="product_desc" id="description"> <br><br>
			
			
			Product Price :         <input type="text" name="product_price" id="price"> <br><br>
			
			
			<input type="submit"  value="Add Product">
		</fieldset>
  </form>
  
  </div>

</body>
</html>