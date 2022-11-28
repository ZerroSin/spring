<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/shopping.css">

</head>

<body>
     
<%@ page import="java.util.*"%>
<%@ page import="com.human.vo.*" %>
<%
   //ArrayList<MemberVO> al = (ArrayList)request.getAttribute("mList");
%>
   <div id="wrap" align="center">
   <h1>회원정보</h1> 
   <h3>아이디</h3>${member.getId()}
   <h3>이름</h3>${member.getName()}
   <h3>전화번호</h3>${member.getTel()}
   <h3>포인트</h3>${member.getPoint()}
   <h3>등급</h3>${member.getGrade()}
   <br>
   <br>
   <input type="button" value='현재창닫기' onclick='window.close()'>
   </div>
   
</body>
<script>
	
</script>
</html>