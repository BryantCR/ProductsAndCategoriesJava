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
				Categories List
			</h2>
		</header>
		<main>
			<table>
				<thead>
					<tr>
						<th>
							Category
						</th>
						<th>
							See categories
						</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<c:forEach items="${ categoriesList }" var="categories">
							<td>
								${ categories.category_name }
							</td>
							<td>
								<a href="/show/${ categories.getCategory_id() }">
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