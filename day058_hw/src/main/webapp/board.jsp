<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세 페이지</title>
<script src="js/preview.js"></script>
</head>
<body>
<!--  이 페이지 올 때에는, data와 path가 필요하다. -->

내용 ${data.content} <br>
작성자 ${data.writer} <br>

<hr>

<c:if test="${empty path}">
	<img alt="기본 이미지" src="images/default.png">
</c:if>
<c:if test="${not empty path}">
	<img alt="비워두면 안됨" src="images/${path}">
</c:if>
 
<form action="updateBoard.do" method="POST" enctype="multipart/form-data">
	<input type="hidden" name="bid" value="${data.bid}">
	이미지 <input type="file" name="file" onchange="preview(event)"> <br>
	<img id="previewImage" style="display:none;margin:5px;" alt="미리보기 이미지"><br>
	<input type="submit" value="이미지 변경">
</form>

<hr>

<a href="main.do">메인으로 이동</a>


</body>
</html>


