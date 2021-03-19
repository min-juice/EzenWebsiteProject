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
	<ul>
		<c:if test="${member == null}">
			<li><a href="/fmember/login">로그인</a></li>
			<li><a href="/fmember/insert">회원가입</a></li>
		</c:if>
		<c:if test="${member != null }">
			<!-- 로그인 o -->
			<c:if test="${member.adminCK == 1 }">
			
				<!-- 관리자계정 -->
				<li><a href="/admin/main">관리자 페이지</a></li>
			</c:if>

			<li>${member.memName}님환영합니다.</li>
			
			<li><a href="/fmember/read?memId=${dto.memId}">마이페이지</a></li>
			<li><a href="/shop/cartList">카트 리스트</a></li>
			<li><a id="gnb_logout_button">로그아웃</a></li>

		</c:if>
	</ul>
<%-- 	<c:if test="${member == null }">
		<div class="login_button">
			<a href="/fmember/login">로그인</a> <span><a
				href="/fmember/insert">회원가입</a></span>
	</c:if> --%>


	<!-- 로그인한 상태 -->
	<c:if test="${ member != null }">
		<div class="login_success_area">
		<span>충전금액 : <fmt:formatNumber
					value="${member.money }" pattern="#,###.##" /></span> <span>포인트 :
				<fmt:formatNumber value="${member.point }" pattern="#,###" />

		</div>
		</c:if>
		
		<script>
		/* gnb_area 로그아웃 버튼 작동 */
		$("#gnb_logout_button").click(function() {
			/*  alert("버튼 작동"); */
			$.ajax({
				type : "POST",
				url : "/fmember/logout.do",
				success : function(data) {
					/* alert("로그아웃 성공"); */
					document.location.reload();
				}
			}); // ajax 
		});
	</script>

	