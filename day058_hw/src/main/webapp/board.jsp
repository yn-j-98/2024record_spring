<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 작성 페이지</title>
</head>
<body>
<form action="board.do" method="POST">
    <input type="text" name="title" required placeholder="제목을 입력하세요.">
    <textarea name="content" required placeholder="내용을 입력하세요."></textarea>
    <input type="submit" value="글 작성">
</form>
</body>
</html>