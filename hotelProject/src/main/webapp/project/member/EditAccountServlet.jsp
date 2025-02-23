<%@page import="utils.JSFunction"%>
<%@page import="member.MemberDAO"%>
<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	String id = session.getAttribute("loginId").toString();
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String num = request.getParameter("num");
	String email = request.getParameter("email");
	
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setId(id);
	memberDTO.setPw(pw);
	memberDTO.setName(name);
	memberDTO.setNum(num);
	memberDTO.setEmail(email);
	
	MemberDAO memberDAO = new MemberDAO();

	int successEdit = memberDAO.editAccount(memberDTO);
	memberDAO.close();
	
	if(successEdit == 1){
		session.setAttribute("loginName", memberDTO.getName());
		JSFunction.alertLocation("정보 수정 완료", "AccountInfo.jsp", out);
	} else {
		JSFunction.alertBack("수정 실패", out);
	}
	
%>