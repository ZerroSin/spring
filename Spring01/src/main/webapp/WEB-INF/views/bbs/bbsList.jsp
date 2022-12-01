<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="../top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/shopping.css">
</head>
<body>
   <div id="wrap" align="center">
      <h1>게시글 리스트</h1>
      <table class="list">
         <tr>
            <td colspan="5" style="border: white; text-align: right"><a
               href="wrForm">게시글 등록</a></td>
         </tr>
         <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회</th>
            <th>수정/삭제</th>
         </tr>
         <!-- 아래 Tr 이 게시글 수 만큼 반복.. -->
         <c:forEach items="${bList }" var="bvo">         
               <tr class='record'>
               <td><a href='bbsView?vno=${bvo.num}'>${bvo.num }</a></td>   
               <td><a href=''>${bvo.title }</td>
               <td>${bvo.name }</td>
               <td>${bvo.indate }</td>
               <td>${bvo.cnt }</td>
               <td>M/D</td>
               </tr>      
         
         </c:forEach>
         
         <!-- paging-->
         <tr>
         	<td colspan=6>
         		<c:if test="${pageVO.prev}">
         			<a href="bbsList?page=${pageVO.startPage - 1}">[이전페이지]</a>
         		</c:if>
         	<!-- forEach 리스트를 순회하는것도있고, 아래처럼 시작과 끝을 지정하여 반복해서 사용하는것도있음 -->        	
         		<c:forEach begin="${pageVO.startPage}" end="${pageVO.endPage}" var="idx">
         			<c:if test="${pageVO.page == idx }">*</c:if>
         			<a href="bbsList?page=${idx}">${idx}</a>
         		</c:forEach>
         		<c:if test="${pageVO.next}">
         			<a href="bbsList?page=${pageVO.endPage + 1}">[다음페이지]</a>
         		</c:if>        	
         	</td>
         
         </tr>
      </table>
   </div>
</body>
</html>

<!-- ----------------------------------------------------------------------------- -->

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../top.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/resources/css/shopping.css">

</head>

<body>

   <hr>
     
<%@ page import="java.util.*"%>
<%@ page import="com.human.vo.*" %>
<%
   ArrayList<BoardVO> al = (ArrayList)request.getAttribute("bList");
   //out.print(al.size() +" / 가나다라마바사 <br>" );

   //for(int i=0; i < al.size(); i++){
//      BoardVO bvo = al.get(i);
   //   out.print(bvo.getNum());
//      out.print(bvo.getName());
   //   out.print("<hr>");      
//   }
%>
   <div id="wrap" align="center">
      <h1>게시글 리스트</h1>
      <table class="list">
         <tr>
            <td colspan="5" style="border: white; text-align: right"><a
               href="wrForm">게시글 등록</a></td>
         </tr>
         <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>조회</th>
            <th>수정/삭제</th>
         </tr>
         <!-- 아래 Tr 이 게시글 수 만큼 반복.. -->
         
         <%
         if(al.size()==0){
            out.print("<tr class='record'>");
            out.print("<td colspan=5>등록된 글이 없습니다.</td>");   
            out.print("</tr>");
         }else{
            for(int i=0; i < al.size(); i++){
               BoardVO bvo = al.get(i);
               out.print("<tr class='record'>");
               out.print("<td>"+bvo.getNum()+"</td>");   
               out.print("<td><a href='"+request.getContextPath()+"/boardView?wno="+bvo.getNum()+"'>"+bvo.getTitle()+"</td>");
               out.print("<td>"+bvo.getName()+"</td>");
               out.print("<td>"+bvo.getIndate()+"</td>");
               out.print("<td>"+bvo.getCnt()+"</td>");
               out.print("<td>M/D</td>");
               out.print("</tr>");
            }
         }      
         
         %>
            
         <!-- 아래 Tr 이 게시글 수 만큼 반복.. -->
      </table>
   </div>
</body>
</html> --%>