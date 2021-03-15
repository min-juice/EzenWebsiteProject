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
<h1>회원 정보 자세히 보기</h1>

ID: ${vo.memId}<br><br>
NAME: ${vo.memName}<br><br>
EMAIL: ${vo.memMail}<br><br>
ADDRESS: ${vo.memAd1} + ${vo.memAd2} + ${vo.memAd3}<br><br>
REGDATE: <fmt:formatDate value="${vo.regDate}" type="date" pattern="yyyy-MM-dd"/><br>
최종 변경일: <fmt:formatDate value="${vo.updatedate}" type="date" pattern="yyyy-MM-dd"/><br>
<hr>
<a href="update/${vo.memId}">수정</a> | <a href="delete">삭제</a>
</body>
</html>