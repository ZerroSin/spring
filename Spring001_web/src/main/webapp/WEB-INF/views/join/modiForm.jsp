<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="wrap" align="center">
		<%@ include file="../header.jsp"%>
		<%@ include file="../nav.jsp"%>
		<%@ page import="java.util.*"%>
		<%@ page import="com.human.vo.*" %>
		<% MemberVO member = (MemberVO)request.getAttribute("member"); %>
		<section>
			<form action="modiAction" method="post">
				<table border="1">
					<tr>
						<td colspan="4" align=center>회원정보수정</td>
					</tr>
					<tr>
						<td align=center>아이디</td>
						<td><input type="text" name="id" value='${member.getId()}' readonly></td>
					</tr>
					<tr>
						<td align=center>이름</td>
						<td><input type="text" name="name" value='${member.getName()}'></td>
					</tr>
					<tr>
						<td align=center>비밀번호</td>
						<td><input type="password" name="pass" value='${member.getPass()}'></td>
					</tr>
					<tr>
						<td align=center>전화번호</td>
						<td><input type="text" name="tel" value='${member.getTel()}'></td>
					</tr>
					<tr>
						<td align=center>등급</td>
						<td>

						
							<select name="grade" id="grade">
							<%if(member.getGrade().equals("일반")){
								out.print("<option value='일반' selected>일반</option>");
								out.print("<option value='vip'>VIP</option>");
								
							} else{
								out.print("<option value='일반' >일반</option>");
								out.print("<option value='vip' selected>VIP</option>");								
							}
					
								
							%>
							</select>
							
						</td>
					</tr>
				</table>
				<input type="submit" value="수정하기">
		</section>
		</form>
		<%@ include file="../footer.jsp"%>
	</div>
</body>
<script type="text/javascript">

	
</script>
</html>