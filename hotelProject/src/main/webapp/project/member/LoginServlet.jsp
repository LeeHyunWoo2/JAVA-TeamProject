<%@ page import="member.MemberDTO"%>
<%@ page import="member.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String loginId = request.getParameter("userId");
	String loginPw = request.getParameter("userPw");
	// form에서 넘어온 데이터를 변수로 받음
	
	
	MemberDAO memberDAO = new MemberDAO();
	MemberDTO memberDTO = memberDAO.getMemberDTO(loginId, loginPw);
	memberDAO.close();
	
	if(memberDTO.getId() != null){
		session.setAttribute("loginId", memberDTO.getId());
		session.setAttribute("loginName", memberDTO.getName());
		%> <script>alert("로그인 완료");location.href="${pageContext.request.contextPath}/project/Home.jsp" </script> <%
	} else{
		request.setAttribute("LoginErrMsg", "id 혹은 pw를 다시 확인해주세요.");
		request.getRequestDispatcher("${pageContext.request.contextPath}/project/Home.jsp").forward(request, response);
	}

%>