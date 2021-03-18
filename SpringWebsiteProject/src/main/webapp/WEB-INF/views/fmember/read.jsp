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
<form role="form" method="post" autocomplete="off">
<h1>회원 정보 자세히 보기</h1>

아이디: ${read.memId}<br>
이름: ${read.memName}<br>
이메일: ${read.memMail}<br>

주소: ${read.memAd2}<br>
주소: ${read.memAd3}<br>
주소: ${read.memAd1}<br>
가입일: <fmt:formatDate value="${read.regDate}" type="date" pattern="yyyy-MM-dd"/><br>
최종 변경일: <fmt:formatDate value="${read.updatedate}" type="date" pattern="yyyy-MM-dd"/><br>
<hr>

 <p>
  <button id="modity_btn">수정</button>
  <button id="delete_btn">삭제</button>
 </p>

<script>
 
 // 폼을 변수에 저장
 var formObj = $("form[role='form']");
 
 // 수정 버튼 클릭
 $("#modity_btn").click(function(){
  
  formObj.attr("action", "/fmember/update");
  formObj.attr("method", "get");  
  formObj.submit();     
  
 });
 
 
 // 삭제 버튼 클릭
 $("#delete_btn").click(function(){
  
  formObj.attr("action", "/fmember/delete");
  formObj.attr("method", "get");  
  formObj.submit();
  
 });
 </script>
 </form>
</body>
</html>