<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>user1::register</title>
</head>
<body>
<h3>user1 등록</h3>
<a href="/ch05">처음으로</a>
<a href="/ch05/user1/list">목록이동</a>

<form action="/ch05/user1/register" method="post">
    <table border="1">
        <tr>
            <td>아이디</td>
            <td><input type="text" name="uid" placeholder="아이디 입력"></td>
        </tr>
        <tr>
            <td>이름</td>
            <td><input type="text" name="name" placeholder="이름 입력"></td>
        </tr>
        <tr>
            <td>휴대폰</td>
            <td><input type="text" name="hp" placeholder="휴대폰 입력"></td>
        </tr>
        <tr>
            <td>나이</td>
            <td><input type="number" name="age" placeholder="나이 입력"></td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="등록하기">
            </td>
        </tr>
    </table>
</form>
</body>
</html>