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
	<div id="">
		<h2>상품 등록</h2>
		<form role="form" method="post" autocomplete="off">
		<input type="hidden" name="n" value="${goods.gdsNum}" />

<div class="inputArea"> 
 <label>1차 분류</label>
 <span class="category1"></span>        
 <label>2차 분류</label>
 <span class="category2">${goods.cateCode}</span>
</div>

<div class="inputArea">
 <label for="gdsName">상품명</label>
 <span>${goods.gdsName}</span>
</div>

<div class="inputArea">
 <label for="gdsPrice">상품가격</label>
 <span><fmt:formatNumber value="${goods.gdsPrice}" pattern="###,###,###"/></span>
</div>

<div class="inputArea">
 <label for="gdsStock">상품수량</label>
 <span>${goods.gdsStock}</span>
</div>

<div class="inputArea">
 <label for="gdsDes">상품소개</label>
 <span>${goods.gdsDes}</span>
</div>

<div class="inputArea">
 <button type="button" id="modify_Btn" class="btn btn-warning">수정</button>
 <button type="button" id="delete_Btn" class="btn btn-danger">삭제</button>
 
 <script>
  var formObj = $("form[role='form']");
  
  $("#modify_Btn").click(function(){
   formObj.attr("action", "/admin/goods/modify");
   formObj.attr("method", "get")
   formObj.submit();
  });
  
  $("#delete_Btn").click(function(){    
   formObj.attr("action", "/admin/goods/delete");
   formObj.submit();
  });
 </script>
</div>

		<script>
			// 컨트롤러에서 데이터 받기
			var jsonData = JSON.parse('${category}');
			console.log(jsonData);

			var cate1Arr = new Array();
			var cate1Obj = new Object();

			// 1차 분류 셀렉트 박스에 삽입할 데이터 준비
			for (var i = 0; i < jsonData.length; i++) {

				if (jsonData[i].level == "1") {
					cate1Obj = new Object(); //초기화
					cate1Obj.fCode = jsonData[i].fCode;
					cate1Obj.fName = jsonData[i].fName;
					cate1Arr.push(cate1Obj);
				}
			}

			// 1차 분류 셀렉트 박스에 데이터 삽입
			var cate1Select = $("select.category1")

			for (var i = 0; i < cate1Arr.length; i++) {
				cate1Select
						.append("<option value='" + cate1Arr[i].fCode + "'>"
								+ cate1Arr[i].fName + "</option>");
			}
			$(document).on("change", "select.category1", function(){

				 var cate2Arr = new Array();
				 var cate2Obj = new Object();
				 
				 // 2차 분류 셀렉트 박스에 삽입할 데이터 준비
				 for(var i = 0; i < jsonData.length; i++) {
				  
				  if(jsonData[i].level == "2") {
				   cate2Obj = new Object();  //초기화
				   cate2Obj.fCode = jsonData[i].fCode;
				   cate2Obj.fName = jsonData[i].fName;
				   cate2Obj.fCodeRef = jsonData[i].fCodeRef;
				   
				   cate2Arr.push(cate2Obj);
				  }
				 }
				 
				 var cate2Select = $("select.category2");
				 
				 /*
				 for(var i = 0; i < cate2Arr.length; i++) {
				   cate2Select.append("<option value='" + cate2Arr[i].cateCode + "'>"
				        + cate2Arr[i].cateName + "</option>");
				 }
				 */
				 
				 cate2Select.children().remove();

				 $("option:selected", this).each(function(){
				  
				  var selectVal = $(this).val();  
				  cate2Select.append("<option value='"+selectVal + "'>전체</option>");
				  
				  for(var i = 0; i < cate2Arr.length; i++) {
				   if(selectVal == cate2Arr[i].fCodeRef) {
				    cate2Select.append("<option value='" + cate2Arr[i].fCode + "'>"
				         + cate2Arr[i].fName + "</option>");
				   }
				  }
				  
				 });
				 
				});
		</script>
	</div>
</body>
</html>