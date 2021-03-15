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

<div class="inputArea"> 
 <label>1차 분류</label>
 <select class="category1">
  <option value="">전체</option>
 </select>

 <label>2차 분류</label>
 <select class="category2" name="fCode">
  <option value="">전체</option>
 </select>
</div>

<div class="inputArea">
 <label for="fName">상품명</label>
 <input type="text" id="fName" name="fName" />
</div>

<div class="inputArea">
 <label for="fPrice">상품가격</label>
 <input type="text" id="fPrice" name="fPrice" />
</div>

<div class="inputArea">
 <label for="fStock">상품수량</label>
 <input type="text" id="fStock" name="fStock" />
</div>

<div class="inputArea">
 <label for="fDes">상품소개</label>
 <textarea rows="5" cols="50" id="fDes" name="fDes"></textarea>
</div>

<div class="inputArea">
 <button type="submit" id="register_Btn" class="btn btn-primary">등록</button>
</div>

</form>

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