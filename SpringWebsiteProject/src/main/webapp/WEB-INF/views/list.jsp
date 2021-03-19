<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<table>
<thead>
			<tr>
				<th>아이디</th>
				<th>이름</th>
				<th>메일</th>
				<th>가입일</th>
			</tr>
		</thead>
<tbody>
<c:forEach items="${list}" var="vo">
	<tr>
		<td><a href="read/${vo.memId}">${vo.memId}</a></td>
		<td>${vo.memName}</td>
		<td>${vo.memMail}</td>
		<td><fmt:formatDate pattern="yyyy-MM-dd" value="${vo.regDate}" type="date"/></td>
	
	</tr>
</c:forEach>
</tbody>
</table>
</body>
</html>