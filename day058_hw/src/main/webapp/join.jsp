<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="js/checkID.js"></script>
<link rel="stylesheet" type="text/css" href="css/join.css"> 
</head>
<body>

<div class="container">
    <form action="join.do" method="POST">
        <h2>회원가입</h2>
        <table>
            <tr>
                <td><label for="name">이름</label></td>
                <td><input type="text" id="name" name="name" required></td>
            </tr>
            <tr>
                <td><label for="mid">아이디</label></td>
                <td>
                    <input type="text" id="mid" name="mid" required>
                    <span id="result"></span>
                </td>
            </tr>
            <tr>
                <td><label for="password">비밀번호</label></td>
                <td><input type="password" id="password" name="password" required></td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="회원가입">
                </td>
            </tr>
        </table>
    </form>
</div>

<div style="text-align: center; margin-top: 20px;">
    <a href="login.do">로그인 페이지로 이동</a>
</div>

</body>
</html>
