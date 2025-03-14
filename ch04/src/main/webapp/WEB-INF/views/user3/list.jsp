<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>user2::list</title>
</head>
<body>
<h3>user2 목록</h3>
<a href="/ch04">처음으로</a>
<a href="/ch04/user3/register">등록하기</a>
<table border="1">
    <tr>
        <th>아이디</th>
        <th>이름</th>
        <th>휴대폰</th>
        <th>나이</th>
        <th>관리</th>
    </tr>
    <c:forEach var="user3" items="${user3List}">
        <tr>
            <td>${user3.uid}</td>
            <td>${user3.name}</td>
            <td>${user3.hp}</td>
            <td>${user3.age}</td>
            <td>
                <a href="/ch04/user3/modify?uid=${user3.uid}">수정</a>
                <a href="/ch04/user3/remove">삭제</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>