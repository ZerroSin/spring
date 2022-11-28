<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/shopping.css">
</head>
<style>
	nav ul li{
        display: inline;
    }

    nav{
        height: 50px;
        background-color: aqua;
    }
</style>
<body>
	<nav>
		<ul>
			<li><a href="#">홈으로</a></li>
			<li><a href="#">게시판</a></li>
			<li><a href="joinForm">회원가입</a></li>
			<li><a href="memList">회원목록</a></li>
		</ul>
	</nav>

</body>
</html>