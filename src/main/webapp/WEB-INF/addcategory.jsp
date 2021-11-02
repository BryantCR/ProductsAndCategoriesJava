<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Category</title>
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">	</head>
	</head>
	<body>
		<header>
			<nav>
				<h3><a href="/products">Products</a> | <a href="/categories/list">Categories</a></h3>
			</nav>
		</header>
		<main>
			<h2>
				Add Categories
			</h2>
			<div class="d-flex flex-column justify-content-center m-5 p-5">
				<form action="/addingcategory" method="POST">
					<div class="mb-3">
						<label class="form-label" for="category_name">
							Name
						</label>
						<input class="form-control" type="text" name="category_name" id="category_name">
					</div>
					<button type="submit" class="btn btn-primary"> Add Category </button>
				</form>	
			</div>
		</main>
	</body>
</html>