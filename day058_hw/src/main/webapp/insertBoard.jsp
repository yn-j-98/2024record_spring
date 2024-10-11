<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
<link rel="stylesheet" type="text/css" href="css/insertBoard.css"> 
</head>
<body>

<form action="insertBoard.do" method="POST">
    <h2>글 작성</h2>
    <input type="text" name="content" placeholder="내용을 입력해 주세요" required> <br>
    <input type="text" name="writer" value="${userID}" readonly> <br>
    <input type="submit" value="글 작성">
    <a href="main.do">메인으로 이동</a>
</form>

</body>
</html>
