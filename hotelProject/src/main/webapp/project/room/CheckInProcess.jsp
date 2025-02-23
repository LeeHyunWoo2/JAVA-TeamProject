<%@page import="utils.JSFunction"%>
<%@page import="java.sql.Date"%>
<%@page import="room.RoomDAO"%>
<%@page import="room.RoomDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = request.getParameter("num");
	String roomStatus = request.getParameter("roomStatus");
	String checkInDate = request.getParameter("checkInDate");
	String checkOutDate = request.getParameter("checkOutDate"); // form 값 저장
	
	RoomDTO roomDTO = new RoomDTO();
	roomDTO.setRoomNum(num);
	roomDTO.setRoomStatus(roomStatus);
	roomDTO.setRoomCheckInNO(checkInDate);
	roomDTO.setRoomCheckOutNO(checkOutDate);// 빈객체 생성후 값 저장완료
	
	RoomDAO roomDAO = new RoomDAO(application); // 1,2단계
	int affected = roomDAO.updateRoomDTO(roomDTO); // 3,4단계
	roomDAO.close(); // 5단계
	
	// 성공/실패 처리
	if(affected == 1) {
		// 성공
		System.out.println("체크인 완료");
		System.out.println("체크인 날짜 : " + checkInDate); // 값 확인
		System.out.println("체크아웃 날짜 : " + checkOutDate);
		JSFunction.alertLocation("체크인 되었습니다.", "../elements.jsp", out);
	}else {
		// 실패
		System.out.println("체크인 실패");
		System.out.println("체크인 날짜 : " + checkInDate);
		System.out.println("체크아웃 날짜 : " + checkOutDate);
		JSFunction.alertBack("체크인에 오류가 발생하였습니다.", out);
	}
%>