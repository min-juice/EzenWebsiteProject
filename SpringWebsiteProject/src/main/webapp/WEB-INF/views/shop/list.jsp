<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

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
<script src="https://code.jquery.com/jquery-3.4.1.js"
	integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
	crossorigin="anonymous"></script>
<!-- <style>

 body { margin:0; padding:0; font-family:'맑은 고딕', verdana; }
 a { color:#05f; text-decoration:none; }
 a:hover { text-decoration:underline; }
 
 h1, h2, h3, h4, h5, h6 { margin:0; padding:0; }
 ul, lo, li { margin:0; padding:0; list-style:none; }

 /* ---------- */
 
 div#root { width:900px; margin:0 auto; }
 header#header { }
 nav#nav { }
 section#container { }
  section#content { float:right; width:700px; }
  #aside { float:left; width:180px; }
  section#container::after { content:""; display:block; clear:both; } 
 footer#footer { background:#eee; padding:20px; }
 
 /* ---------- */
 
 header#header div#header_box { text-align:center; padding:30px 0; }
 header#header div#header_box h1 { font-size:50px; }
 header#header div#header_box h1 a { color:#000; }
 
 nav#nav div#nav_box { font-size:14px; padding:10px; text-align:right; }
 nav#nav div#nav_box li { display:inline-block; margin:0 10px; }
 nav#nav div#nav_box li a { color:#333; }
 
 section#container { }
 
 #aside h3 { font-size:22px; margin-bottom:20px; text-align:center; }
 #aside li { font-size:16px; text-align:center; }
 #aside li a { color:#000; display:block; padding:10px 0; }
 #aside li a:hover { text-decoration:none; background:#eee; }
 
 footer#footer { margin-top:100px; border-radius:50px 50px 0 0; }
 footer#footer div#footer_box { padding:0 20px; }
 
</style> -->
</head>
<body>
	<div class="wrapper">
		<div class="wrap">
			<div class="top_gnb_area">
				<ul class="list">
					<c:if test="${member == null}">
						<!-- 로그인 x -->

						<li><a href="/fmember/login">로그인</a></li>
						<li><a href="/fmember/insert">회원가입</a></li>

					</c:if>

					<c:if test="${member != null }">
						<!-- 로그인 o -->
						<c:if test="${member.adminCK == 1 }">
							<!-- 관리자계정 -->
							<li><a href="/admin/main">관리자 페이지</a></li>
						</c:if>
						<li><a id="gnb_logout_button">로그아웃</a></li>
						<li><a href="/fmember/read?memId=${dto.memId}">마이페이지</a></li>
						<li>마이룸</li>
						<li>장바구니</li>
					</c:if>
					<li>고객센터</li>
				</ul>

			</div>
			<div class="top_area">
				<div class="logo_area">
					<h1>logo area</h1>
				</div>
				<div class="search_area">
					<h1>Search area</h1>
				</div>
				<div class="login_area">

					<!-- 로그인 하지 않은 상태 -->
					<c:if test="${member == null }">
						<div class="login_button">
							<a href="/fmember/login">로그인</a> <span><a
								href="/fmember/insert">회원가입</a></span>
					</c:if>


					<!-- 로그인한 상태 -->
					<c:if test="${ member != null }">
						<div class="login_success_area">
							<span>회원 : ${member.memName}</span> <span>충전금액 : <fmt:formatNumber
									value="${member.money }" pattern="#,###.##" /></span> <span>포인트
								: <fmt:formatNumber value="${member.point }" pattern="#,###" />
							</span> <a href="/fmember/logout.do">로그아웃</a>

						</div>

					</c:if>
				</div>

				<div class="clearfix"></div>
			</div>
			<section id="container">
				<div id="container_box">
					<section id="content">

						<ul>
							<c:forEach items="${list}" var="list">
								<li>
									<div class="goodsThumb">
										<img src="${list.gdsThumbImg}">
									</div>
									<div class="goodsName">
										<a href="/shop/view?n=${list.gdsNum}">${list.gdsName}</a>
									</div>
								</li>
							</c:forEach>
						</ul>
						</section>

						<div class="aside">
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
						</div>
						<div class="content_area">
							<h1>content area</h1>
						</div>
				</div>
		</div>
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
		</div>
</body>
</html>