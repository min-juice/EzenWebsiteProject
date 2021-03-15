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
<script
	src="https://code.jquery.com/jquery-3.4.1.js"
  integrity="sha256-WpOohJOqMqqyKL9FccASB9O0KwACQJpFTUBLTYOVvVU="
  crossorigin="anonymous"></script>

<link rel="stylesheet" href="/resources/css/f_member/login.css">


</head>
<body>
	<div class="wrapper">
	
		<div class="wrap">
			<form id="login_form" method="post">
			<div class="logo_wrap">
				<span>Book Mall</span>
			</div>
			<div class="login_wrap">
				<div class="id_wrap">
					<div class="id_input_box">
						<input class="id_input" name="memId">
					</div>
				</div>
				<div class="pw_wrap">
					<div class="pw_input_box">
						<input class="pw_iput" name="memPw">
					</div>
				</div>
				
				<c:if test = "${result == 0 }">
				<div class = "login_warn">사용자 ID 또는 비밀번호를 잘못 입력하셨습니다.</div>
				</c:if>
				<div class="login_button_wrap">
					<input type="button" class="login_button" value="로그인">
				</div>
			</div>
			</form>
		</div>
	</div>
	
	<script>
		/* 로그인 버튼 클릭 메서드 */
		$(".login_button").click(function() {
			//alert("로그인 버튼 작동");
			
			/* 로그인 메서드 서버 요청 */
			$("#login_form").attr("action","/fmember/login.do");
			$("#login_form").submit();
		});
	
	</script>
</body>
</html>

