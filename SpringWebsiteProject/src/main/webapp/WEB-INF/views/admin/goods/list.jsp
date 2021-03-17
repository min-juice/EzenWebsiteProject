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
   <th>번호</th>
   <th>이름</th>
   <th>카테고리</th>
   <th>가격</th>
   <th>수량</th>
   <th>등록날짜</th>
  </tr>
 </thead>
 <tbody>
  <c:forEach items="${list}" var="list">
  <tr>
   <td>${list.gdsNum}</td>
   <td>
   		<a href="/admin/goods/view?n=${list.gdsNum}">${list.gdsName}</a>
   </td>
   <td>${list.cateCode}</td>
   <td>
   		<fmt:formatNumber value="${list.gdsPrice}" pattern="###,###,###"/>
   </td>
   <td>${list.gdsStock}</td>
   <td>
   		<fmt:formatDate value="${list.gdsDate}" pattern="yyyy-MM-dd"/>
   	</td>
  </tr>   
  </c:forEach>
 </tbody>
</table>
</body>
</html>