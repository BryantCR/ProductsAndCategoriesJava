<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Product</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">	</head>
	<body>
		<header>
			<nav>
				<h3><a href="/showproducts">Products</a> | <a href="/category">Categories</a></h3>
			</nav>
		</header>
		<main>
			<h2>
				Add Products
			</h2>
			<div class="d-flex flex-column justify-content-center m-5 p-5">
				<form action="/adding" method="POST">
					<div class="mb-3">
						<label class="form-label" for="product_name">
							Name
						</label>
						<input class="form-control" type="text" name="product_name" id="product_name">
					</div>
					<div class="mb-3">
						<label class="form-label" for="product_description">
							Description
						</label>
						<textarea class="form-control" rows="" cols="" name="product_description"></textarea>
					</div>
					<div class="mb-3">
						<label class="form-label" for="product_price">
							Price
						</label>
						<input class="form-control" type="number" name="product_price" id="product_price">
					</div>
					<button type="submit" class="btn btn-primary"> Add Product</button>
				</form>	
			</div>
			<ul>
				<c:forEach items="${ products }" var="product">
					<li>
						<a href="/${ product.products_id }">
							${ product.name }
						</a>
					</li>		
				</c:forEach>
			</ul>
		</main>
	</body>
</html>