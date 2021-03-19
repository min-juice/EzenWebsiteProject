<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
</head>
<body>
	<h3>카테고리</h3>

	<ul>
		<li><a href="/shop/list?c=100&l=1">Shop</a>
			<ul class="low">
				<li><a href="/shop/list?c=101&l=2">생화</a></li>
				<li><a href="/shop/list?c=102&l=2">장미</a></li>
				<li><a href="/shop/list?c=103&l=2">카네이션</a></li>
				<li><a href="/shop/list?c=104&l=2">소재</a></li>
				<li><a href="/shop/list?c=105&l=2">조화</a></li>
			</ul>
		<li><a href="/shop/list?c=200&l=1">Vase</a></li>
		<li><a href="/shop/list?c=300&l=1">Accessories</a></li>
		<li><a href="/shop/list?c=400&l=1">Q&A</a></li>
		<li><a href="/shop/list?c=500&l=1">Notice</a></li>
	</ul>
</body>
</html>