<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>   <!-- JSP 를 위한 설정 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
</head>
<body>
<h3>회원 수정</h3>
<p>${custno} 회원 수정 페이지 입니다.</p>
<form action="update" method="post">
	<input type="text" name="username" value="${custno }">
	<button>수정</button>
	<button type="button" onclick="location.href='list'">목록</button>
</form>

<a href="../">홈</a>
</body>
</html>