<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" type="text/css" href="css/login.css"> 

</head>
<body>

<form action="login.do" method="POST">
    <h2>로그인</h2>
    <table>
        <tr>
            <td><label for="mid">아이디</label></td>
            <td><input type="text" id="mid" name="mid" required></td>
        </tr>
        <tr>
            <td><label for="password">비밀번호</label></td>
            <td><input type="password" id="password" name="password" required></td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="로그인">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
