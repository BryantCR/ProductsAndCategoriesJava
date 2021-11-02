<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>List</title>
	</head>
	<body>
		<header>
			<h2>
				Products List
			</h2>
		</header>
		<main>
			<table  style="display:flex; flex-direction:column;>
				<thead>
					<tr>
						<th>
							Product
						</th>
						<th>
							See products
						</th>
					</tr>
				</thead>
				<tbody">
					<tr>
						<c:forEach items="${ productsList }" var="prod">
							<td>
								${ prod.product_name }
							</td>
							<td>
								<a href="/info/${ prod.getProduct_id() }">
									Info
								</a>
							</td>
						</c:forEach>
					</tr>
				</tbody>
			</table>
		</main>
	</body>
</html>