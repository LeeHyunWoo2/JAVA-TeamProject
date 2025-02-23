<%@page import="member.MemberDAO"%>
<%@page import="member.MemberDTO"%>
<%@page import="utils.JSFunction"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	MemberDTO memberDTO = new MemberDTO();
	MemberDAO memberDAO = new MemberDAO();
	
	String id = request.getParameter("id");
	memberDTO = memberDAO.accountInfo(id);
	String sessionId = session.getAttribute("loginId").toString();
	

	int success = 0;

		if(sessionId.equals(memberDTO.getId())){
			success = memberDAO.deleteAccount(memberDTO);
			memberDAO.close();
			if(success == 1){
				JSFunction.alertLocation("삭제완료", "../main/Logout.jsp", out);
			} else {
				JSFunction.alertBack("실패", out);
			}
			
		} else {
			JSFunction.alertBack("로그인정보와 맞는 계정이 없습니다", out);
			return;
		}
	
%>