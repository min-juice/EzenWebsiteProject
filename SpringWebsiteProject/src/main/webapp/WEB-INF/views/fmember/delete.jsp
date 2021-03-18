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

<input type="text" id="memId" value="${delete.memId}" readonly="readonly"/><br>

가입일: <fmt:formatDate value="${read.regDate}" type="date" pattern="yyyy-MM-dd"/><br>
최종 변경일: <fmt:formatDate value="${read.updatedate}" type="date" pattern="yyyy-MM-dd"/><br>
<hr>

   <p>정말로 삭제하시겠습니까?</p>
   
   <p>
   
    <button type="submit">예, 삭제합니다.</button><br />
    <button id="cancel_btn">아니오, 삭제하지 않습니다.</button>
    

    <script>

    // 폼을 변수에 저장
    var formObj = $("form[role='form']"); 
    
    // 취소 버튼 클릭
    $("#cancel_btn").click(function(){   
     formObj.attr("action", "/board/read?bno=" + $("#bno").val());
     formObj.attr("method", "get");  
     formObj.submit();     
     
    });
    </script>
 </form>
</body>
</html>