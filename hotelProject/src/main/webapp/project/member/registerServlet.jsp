<%@page import="utils.JSFunction"%>
<%@page import="member.MemberDAO"%>
<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	String name = request.getParameter("name");
	String sex = request.getParameter("sex");
	String num = request.getParameter("num");
	String email = request.getParameter("email");
	String agree1 = request.getParameter("agree1");
	String agree2 = request.getParameter("agree2");
	
	MemberDTO memberDTO = new MemberDTO();
	memberDTO.setId(id);
	memberDTO.setPw(pw);
	memberDTO.setName(name);
	memberDTO.setSex(sex);
	memberDTO.setNum(num);
	memberDTO.setEmail(email);
	memberDTO.setAgree1(agree1);
	memberDTO.setAgree2(agree2);

	MemberDAO memberDAO = new MemberDAO();
	
	int success = memberDAO.createAccount(memberDTO);
	memberDAO.close();
	
	if(success == 1){
		response.sendRedirect("./Login.jsp");
	} else {
		JSFunction.alertBack("가입 실패", out);
	}
	
%>