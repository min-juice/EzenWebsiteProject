<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시판</title>
    <script type="text/javascript" src="./ckeditor/ckeditor.js"></script>
</head>

<body>
  <textarea name = "boContent" class ="ckeditor" cols = "67" rows = "15"></textarea>
<textarea name = "boContent" id = "contents" cols = "67" rows = "15"></textarea>
                  <script>
                        CKEDITOR.replace('contents');
                  </script>

</body>
</html>