<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/resources/css/shopping.css">
</head>
<body>
	<div id="wrap" align="center">
		<%@ include file="../header.jsp"%>
		<%@ include file="../nav.jsp"%>
		<section>
			<form action="joinAction" method="post">
				<table border="1">
					<tr>
						<td colspan="4" align=center>회원가입</td>
					</tr>
					<tr>
						<td align=center>아이디</td>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<td align=center>이름</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td align=center>비밀번호</td>
						<td><input type="password" name="pass"></td>
					</tr>
					<tr>
						<td align=center>전화번호</td>
						<td><input type="text" name="tel"></td>
					</tr>
					<tr>
						<td align=center>등급</td>
						<td><select name="grade" id="grade">
								<option value="일반">일반</option>
								<option value="vip">VIP</option>
						</select></td>
					</tr>
				</table>
				<input type="submit" value="가입하기">		
			</form>
		</section>
		<%@ include file="../footer.jsp"%>
	</div>
</body>

</html>