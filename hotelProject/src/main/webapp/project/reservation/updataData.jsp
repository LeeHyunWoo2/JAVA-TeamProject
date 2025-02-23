<%@page import="utils.JSFunction"%>
<%@page import="reservation.ReservationDTO"%>
<%@page import="reservation.ReservationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String rno = request.getParameter("rno");
	ReservationDAO dao = new ReservationDAO(application); // 1,2 단계
	ReservationDTO dto = new ReservationDTO();
	dto = dao.View(rno);
%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../common/head.jsp" %>
<head>
    <style>
        .container {
            display: grid; /* Grid 레이아웃을 사용하여 요소들을 나란히 배치 */
            grid-template-columns: repeat(2, 1fr); /* 두 개의 동일한 너비의 열을 정의 */

            gap: 100px; /* 테이블 사이의 간격 */
        }
        table {
            border-collapse: collapse; /* 테두리 간 공백 제거 */
            width: 100%; /* 테이블 너비를 100%로 설정 */
        }
         th, td {
            text-align: center; /* 텍스트 가운데 정렬 */
        }
    </style>
</head>
<body>

    <!-- header-start -->
    <%@ include file="../common/header.jsp" %>
    <!-- header-end -->

    <!-- 상단 뒤쪽에 배경사진하고 큰 제목 뜨는 코드 -->
    <div class="bradcam_area breadcam_bg_2">
        <h3>Reservation changes</h3>
    </div>
    <!-- 상단 배경 끝 -->
<%
	if(dto.getId() != null){
%>
<div class="container">
<table class="table">
<thead>
    <tr>
      <th scope="col">구분</th>
      <th scope="col">내용</th>
    </tr>
</thead>
<tbody>
    <tr>
      <td>예약번호</td>
      <td><%=dto.getRno() %></td>
    </tr>
    <tr>
      <td>ID</td>
      <td><%=dto.getId() %></td>
    </tr>
    <tr>
      <td>예약자</td>
      <td><%=dto.getName() %></td>
    </tr>
    <tr>
      <td>전화번호</td>
      <td><%=dto.getNum() %></td>
    </tr>
    <tr>
      <td>체크인</td>
      <td><%=dto.getCheckIn() %></td>
    </tr>
    <tr>
      <td>체크아웃</td>
      <td><%=dto.getCheckOut() %></td>
    </tr>
    <tr>
      <td>인원수</td>
      <td><%=dto.getPeople() %></td>
    </tr>
    <tr>
      <td>룸타입</td>
      <td><%=dto.getRoomType() %></td>
    </tr>
    <tr>
      <td>가격</td>
      <td><%=dto.getAmount() %></td>
    </tr>
    <tr>
      <td>거래일시</td>
      <td><%=dto.getRegidate() %></td>
    </tr>
</tbody>
</table>

<form id="update" action="${pageContext.request.contextPath}/project/reservation/updataServlet.jsp" method="post">
<table class="table">
<thead>
    <tr>
      <th scope="col">구분</th>
      <th scope="col">내용</th>
    </tr>
</thead>
<tbody>
    <tr>
      <td>예약번호</td>
      <td><%=dto.getRno() %></td>
    </tr>
    <tr>
      <td>ID</td>
      <td><%=dto.getId() %></td>
    </tr>
    <tr>
      <td>예약자</td>
      <td><%=dto.getName() %></td>
    </tr>
    <tr>
      <td>전화번호</td>
      <td><%=dto.getNum() %></td>
    </tr>
    <tr>
      <td>체크인</td>
      <td>
      	<div class="col-xl-12">
			<input type="text" id="datepicker" name="checkIn" placeholder="Check in">
		</div>
      </td>
    </tr>
    <tr>
      <td>체크아웃</td>
      <td>
     	 <div class="col-xl-12">
			<input type="text" id="datepicker2" name="CheckOut"	placeholder="Check out">
		</div>
      </td>
    </tr>
    <tr>
      <td>인원수</td>
      <td>
      	<div class="col-xl-6">
			<select class="form-select wide" id="default-select" name="adult" class="">
				<option data-display="성인">1</option>
				<option value="2">2</option>
				<option value="3">3</option>
				<option value="4">4</option>
			</select>
		</div>
      <div class="col-xl-6">
		<select class="form-select wide" id="default-select" name="children" class="">
			<option data-display="어린이">0</option>
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
		</select>
      </div>
      </td>
    </tr>
    <tr>
      <td>룸타입</td>
      <td>
      	<div class="col-xl-12">
			<select class="form-select wide" id="default-select" name="roomType" class="">
				<option data-display="Room type">Room type</option>
				<option value="Laxaries Rooms">Laxaries Rooms</option>
				<option value="Deluxe Room">Deluxe Room</option>
				<option value="Signature Room">Signature Room</option>
				<option value="Couple Room">Couple Room</option>
			</select>
		</div>
      </td>
    </tr>
    <tr>
      <td>가격</td>
      <td><%=dto.getAmount() %></td>
    </tr>
    <tr>
      <td>거래일시</td>
      <td><%=dto.getRegidate() %></td>
    </tr>
    <tr>
      <td colspan="2">
      	<div class="col-xl-12">
      		<input type="hidden" value="<%= dto.getRno()%>" name="rno" />
      		<button type="submit" class="btn btn-outline-primary">변경</button>
		</div>
      </td>
    </tr>
</tbody>
</table>
</form>
<%
	}else{
		JSFunction.alertLocation("예약번호를 확인해주세요.", "updata.jsp", out);
	}
%>
</div>


    <!-- footer -->
    <%@ include file="../common/footer.jsp" %>
    <!-- footer_end -->

    <!-- JS here -->
    <jsp:include page="../common/scripts.jsp"/>

</body>
</html>