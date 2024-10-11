<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>

   <link rel="stylesheet" type="text/css" href="css/main.css"> 

</head>
<body>

<div class="container">
    <h1>${userID}님, 안녕하세요! :D</h1> 

    <hr>

    <div class="logout">
        <a href="logout.do">로그아웃</a>
    </div>

    <hr>

    <h3>글 목록</h3>
    <form action="main.do" method="GET">
        <select name="condition">
            <option value="CONTENT" ${boardDTO.condition eq 'CONTENT' ? 'selected' : ''}>내용</option>
            <option value="WRITER" ${boardDTO.condition eq 'WRITER' ? 'selected' : ''}>작성자</option>
        </select>
        <input type="text" name="keyword" placeholder="검색어를 입력해 주세요.">
        <input type="submit" value="검색">
    </form>

    <ul>
    <c:if test="${empty datas}">
        <li>검색결과가 없습니다.</li>
    </c:if>
    <c:if test="${not empty datas}">
        <c:forEach var="data" items="${datas}">
            <li>
                <strong>글 번호:</strong> ${data.bid} <br>
                <strong>내용:</strong> ${data.content} <br>
                <strong>작성자:</strong> ${data.writer}
            </li>
        </c:forEach>
    </c:if>
</ul>

    <hr>

    <a href="insertBoard.do">글 작성</a>
</div>

</body>
</html>
