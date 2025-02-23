<%@page import="utils.JSFunction"%>
<%@page import="reservation.ReservationDAO"%>
<%@page import="reservation.ReservationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String rno = request.getParameter("rno");
	ReservationDTO dto = new ReservationDTO();
	ReservationDAO dao = new ReservationDAO(application); // 1,2 단계
	dto.setRno(rno);
	int result = dao.delete(dto);
	System.out.print(result);
	dao.close();
	
	if(result == 1){
		JSFunction.alertLocation("예약취소 완료", "../Home.jsp", out);
	}else{
		JSFunction.alertLocation("예약번호를 확인해주세요", "delete.jsp", out);
	}
%>
