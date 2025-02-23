<%@page import="room.RoomDTO"%>
<%@page import="room.RoomDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String roomNo = request.getParameter("num");
System.out.print("roomNo : " + roomNo);
// 폼에서 넘어온 데이터를 변수로 넣음

RoomDAO roomDAO = new RoomDAO(application); // 1단계 2단계
RoomDTO roomDTO = roomDAO.getRoomDTO(roomNo); // 3단계 4단계
roomDAO.close(); // 5단계
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>객실 체크인 상태로 변경</title>
</head>
<body>

<form name="checkInFrm" method="post" action="CheckInProcess.jsp">
<input type="hidden" name="num" value="<%=roomNo %>"/> <!-- 요청값 -->
    <table border="1" width="50%" align="center">
        <tr>
            <td>객실 상태</td> <!-- sql로 자동전환 할 수 있지만 쓰고 싶어서 넣어봄 -->
            <td><input type="radio" name="roomStatus" value="빈방" checked>빈방
					<input type="radio" name="roomStatus" value="투숙중">투숙중
			</td>
        </tr>
        <tr>
            <td>체크인 날짜</td>
            <td><input type="date" name="checkInDate" /></td>
        </tr>
        <tr>
            <td>체크아웃 날짜</td>
            <td><input type="date" name="checkOutDate" /></td>
        </tr>
        <tr>
            <td colspan="3" align="center">
                <button type="submit">체크인 완료</button>
                <button type="reset">다시 입력</button>
                <button type="button" onclick="location.href='../elements.jsp';">
                    목록 보기</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>