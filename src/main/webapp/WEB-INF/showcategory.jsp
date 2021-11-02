<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>add products</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">	</head>
	</head>
	<body>
		<header>
			<nav>
				<h3><a href="/products">Products</a> | <a href="/category">Categories</a></h3>
			</nav>
		</header>
		<main>
			<div>
				<h2 class="justify-content-center text-align-center">
					${categoryInfo.getCategory_name() }
				</h2>
			</div>
			<div class="d-flex flex-row justify-content-around m-5 p-5">
				<div>
					<h5>
						Products
					</h5>
					<ul>
						<c:forEach items="${ categoryInfo.getProducts() }" var="product">
							<li>${ product.getProduct_name() }</li>
						</c:forEach>
					</ul>
				</div>
				<div class="">
					<form action="/addproduct/category" method="POST">
						<input type="hidden" name="category_id" value="${ categoryInfo.getCategory_id() }">
						<label class="form-label">
							Add Products
						</label>
						<select class="form-control my-5" name="product_id">
				            <c:forEach var = "product" items = "${ productList }">
				                <option value="${product.getProduct_id()}">
				                	<c:out value = "${product.getProduct_name()}" ></c:out>
				                </option>
				            </c:forEach>
				        </select>
				        <button type="submit" class="btn btn-primary"> Add Product </button>
			        </form>	
				</div>
			</div>
		</main>
	</body>
</html>