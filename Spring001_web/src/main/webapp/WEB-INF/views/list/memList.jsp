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
   ArrayList<MemberVO> al = (ArrayList)request.getAttribute("mList");
%>

   <div id="wrap" align="center">

      <h1>회원 리스트</h1>
      <table class="list">
         <tr>
            <td colspan="5" style="border: white; text-align: right">
         </tr>
         <tr>
            <th>아이디</th>
            <th>이름</th>
            <th>전화번호</th>
            <th>포인트</th>
            <th>수정/삭제</th>
         </tr>
 
         <%
         if(al.size()==0){
            out.print("<tr class='record'>");
            out.print("<td colspan=5>등록된 회원이 없습니다.</td>");   
            out.print("</tr>");
         }else{
            for(int i=0; i < al.size(); i++){
               MemberVO mvo = al.get(i);
               out.print("<tr class='record'>");
               out.print("<td>"+mvo.getId()+"</td>");   
               out.print("<td><a href='"+request.getContextPath()+"/memberView?mid="+mvo.getId()+"' target='_blank'>"+mvo.getName()+"</td>");
               out.print("<td>"+mvo.getTel()+"</td>");
               out.print("<td>"+mvo.getPoint()+"</td>");
               out.print("<td><a href='#' onclick=modi('"+mvo.getPass()+"','"+mvo.getId()+"')>M</a> / <a href='#'onclick=del('"+mvo.getPass()+"','"+mvo.getId()+"')>D</a></td>");
               out.print("</tr>");
            }
         }               
         %>            
         <!-- 아래 Tr 이 게시글 수 만큼 반복.. -->
      </table> 
   
   </div>
</body>
<script>
	function modi(thisPass, id){
		var ans = confirm('수정하시겠습니까?');
		if(ans){
			var inputPass = prompt('비밀번호를 입력해주세요');
			if(inputPass==thisPass){
				location.href='/web01/modiForm?mid='+id;
			}else{
				alert('비밀번호가 틀렸습니다');
			}
		}
	}
	
	function del(thisPass, id){
		var ans = confirm('삭제하시겠습니까?');
		if(ans){
			var inputPass = prompt('비밀번호를 입력해주세요');
			if(inputPass==thisPass){
				location.href='/web01/delete?mid='+id;
			}else{
				alert('비밀번호가 틀렸습니다');
			}
		}
	}

</script>
</html>