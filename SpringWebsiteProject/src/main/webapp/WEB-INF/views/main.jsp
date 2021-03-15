<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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

</head>
<body>
	<div class="wrapper">
		<div class="wrap">
			<div class="top_gnb_area">
				<ul class="list">
				<c:if test = "${member == null}"> <!-- 로그인 x -->

                <li >
                    <a href="/fmember/login">로그인</a>
                </li>
                <li>
                    <a href="/fmember/insert">회원가입</a>
                </li>
               
                 </c:if>
                 
                 <c:if test="${member != null }">  <!-- 로그인 o -->
                	 <c:if test="${member.adminCK == 1 }"> <!-- 관리자계정 -->
                        <li><a href="/admin/main">관리자 페이지</a></li>
                    </c:if>                
                    <li>
                        <a id="gnb_logout_button">로그아웃</a>
                    </li>
                     <li>
                    <a href="/fmember/read?memId=${dto.memId}">마이페이지</a>
            	    </li>
                    <li>
                        마이룸
                    </li>
                    <li>
                        장바구니
                    </li>
                    </c:if> 
                <li>
                    고객센터
                </li>            
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
                <c:if test = "${member == null }">
					<div class="login_button"><a href="/fmember/login">로그인</a>
					<span><a href="/fmember/insert">회원가입</a></span>                
                </c:if> 
                

					<!-- 로그인한 상태 -->
                <c:if test="${ member != null }">
            		<div class="login_success_area">
                        <span>회원 : ${member.memName}</span>
                        <span>충전금액 : <fmt:formatNumber value="${member.money }" pattern="#,###.##"/></span>
                        <span>포인트 : <fmt:formatNumber value="${member.point }" pattern="#,###" /></span>
                        <a href="/fmember/logout.do">로그아웃</a>

                    </div>

                </c:if>

					</div>
					<div class="clearfix"></div>
				</div>
				<div class="navi_bar_area">
					<span><a href="/">home</a></span>
					<span><a href="board/flowers">flowers</a></span>
					<span><a href="board/shop">shop</a></span>
					<span><a href="board/q&a">Q&A</a></span>
					<span><a href="board/list">notice</a></span>
				</div>
				<div class="content_area">
					<h1>content area</h1>
				</div>
			</div>
		
	</div>
<script>
 
    /* gnb_area 로그아웃 버튼 작동 */
    $("#gnb_logout_button").click(function(){
       /*  alert("버튼 작동"); */
        $.ajax({
            type:"POST",
            url:"/fmember/logout.do",
            success:function(data){
                /* alert("로그아웃 성공"); */
                document.location.reload();     
            } 
        }); // ajax 
    });
    
</script>

</body>
</html>