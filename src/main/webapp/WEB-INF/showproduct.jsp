<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
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
					${productInfo.getProduct_name() }
				</h2>
			</div>
			<div class="d-flex flex-row justify-content-around m-5 p-5">
				<div>
					<h5>
						Categories
					</h5>
					<ul>
						<c:forEach items="${ productInfo.getCategories() }" var="category">
							<li>${ category.getCategory_name() }</li>
						</c:forEach>
					</ul>
				</div>
				<div class="">
					<form action="/addcategory/product" method="POST">
						<input type="hidden" name="product_id" value="${ productInfo.getProduct_id() }">
						<label class="form-label">
							Add Category
						</label>
						<select class="form-control my-5" name="category_id">
				            <c:forEach var = "category" items = "${ CategoryList }">
				                <option value="${category.getCategory_id()}">
				                	<c:out value = "${category.getCategory_name()}" ></c:out>
				                </option>
				            </c:forEach>
				        </select>
				        <button type="submit" class="btn btn-primary"> Add Category </button>
			        </form>	
				</div>
			</div>
		</main>
	</body>
</html>