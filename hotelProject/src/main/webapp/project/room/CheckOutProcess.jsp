<%@page import="utils.JSFunction"%>
<%@page import="room.RoomDTO"%>
<%@page import="room.RoomDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String roomNo = request.getParameter("num"); // 삭제할 번호
	System.out.print("roomNo : " + roomNo);

	RoomDTO roomDTO = new RoomDTO(); // 빈객체 생성
	RoomDAO roomDAO = new RoomDAO(application); // 1단계 2단계
	roomDTO = roomDAO.getRoomDTO(roomNo); // 번호로 객체를 가져와 dto에 넣음
	
	int checkOutResult = 0; // 삭제성공여부 판단 1:성공, 0:실패
	
	roomDTO.setRoomNum(roomNo);
	checkOutResult = roomDAO.checkOutRoomDTO(roomDTO); // 객체를 넣어 삭제하고 int로 받음 3,4단계
	roomDAO.close(); // 5단계
		
		
	// 성공/실패 처리
	if(checkOutResult == 1) {
		// 성공
		System.out.print("체크아웃 완료");
		JSFunction.alertLocation("체크아웃 되었습니다.", "../elements.jsp", out);
	}else {
		// 실패
		request.getRequestDispatcher("../elements.jsp").forward(request, response);
		System.out.print("체크아웃 실패");
		JSFunction.alertBack("체크아웃에 오류가 발생하였습니다.", out);
	}
%>