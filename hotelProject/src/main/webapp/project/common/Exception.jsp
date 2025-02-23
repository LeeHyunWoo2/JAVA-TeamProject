<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
		int status = response.getStatus(); // 오류코드가 정수 타입으로 넘어옴
		
		if(status == 404){
			out.print("<h1>404  에러가 발생했습니다.</h1>");
		}else if(status == 405){
			out.print("<h1>405  에러가 발생했습니다.</h1>");
		}else if(status == 500){
				out.print("<h1>500  에러가 발생했습니다.</h1>");
		}
	
%>
<a href="${pageContext.request.contextPath}/project/Home.jsp">돌아가기</a>