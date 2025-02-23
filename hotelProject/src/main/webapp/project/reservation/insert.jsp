<%@page import="utils.JSFunction"%>
<%@page import="java.util.Random"%>
<%@page import="reservation.ReservationDAO"%>
<%@page import="reservation.ReservationDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 랜덤 객체 생성
Random random = new Random();

int length = 10; // 길이 10의 랜덤 알파벳 문자열

// 랜덤 알파벳 문자열을 저장할 StringBuilder
StringBuilder randomAlphabet = new StringBuilder(length);

// 랜덤 알파벳 문자열 생성
for (int i = 0; i < length; i++) {
    // 대문자 알파벳의 ASCII 범위: 65(A) - 90(Z)
    // 소문자 알파벳의 ASCII 범위: 97(a) - 122(z)
    // 무작위로 대문자나 소문자 선택
    if (random.nextBoolean()) {
        randomAlphabet.append((char) (random.nextInt(26) + 65)); // 대문자
    } else {
        randomAlphabet.append((char) (random.nextInt(26) + 97)); // 소문자
    }
}
	Random ran = new Random();
	
	// 10000부터 99999까지의 랜덤 번호 생성
	int randomNumber = ran.nextInt(99999) + 10000;

// 예약 화면에서 받아온 값 불러와 저장
String rno = Integer.toString(randomNumber)+randomAlphabet;
String date1 = request.getParameter("date1");
String date2 = request.getParameter("date2");
String adult = request.getParameter("adult");
String children = request.getParameter("children");
String roomType = request.getParameter("roomType");
String name = request.getParameter("name");
String id = request.getParameter("id");
String num = request.getParameter("num");

ReservationDTO dto = new ReservationDTO(); // 빈객체 생성
// dto에 값 저장
dto.setRno(rno);
dto.setId(id);
dto.setName(name);
dto.setNum(num);
dto.setPeople(adult);
dto.setCheckIn(date1);
dto.setCheckOut(date2);
dto.setRoomType(roomType);

ReservationDAO dao = new ReservationDAO(application); // 1,2단계
int result = dao.insert(dto); // 3,4 단계
dao.close();

if(result == 1){
	JSFunction.alertLocation("예약완료", "../Home.jsp", out);
}else{
	JSFunction.alertLocation("예약실패", "../Home.jsp", out);
}
%>
