<%@page import="utils.JSFunction"%>
<%@page import="reservation.ReservationDAO"%>
<%@page import="reservation.ReservationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String checkIn = request.getParameter("checkIn");
	String checkOut = request.getParameter("CheckOut");
	String people = request.getParameter("adult");
	String roomType = request.getParameter("roomType");
	String rno = request.getParameter("rno");
	
	ReservationDTO dto = new ReservationDTO();
	dto.setCheckIn(checkIn);
	dto.setCheckOut(checkOut);
	dto.setPeople(people);
	dto.setRoomType(roomType);
	dto.setRno(rno);
	
	ReservationDAO dao = new ReservationDAO(application); // 1,2 단계
	int affected = dao.updata(dto); // 3,4 단계
	dao.close();
	
	if(affected == 1){
		JSFunction.alertLocation("예약변경 완료", "../Home.jsp", out);
	}else{
		JSFunction.alertLocation("예약변경 실패", "../Home.jsp", out);
	}

%>