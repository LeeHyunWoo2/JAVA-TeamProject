<%@page import="room.RoomDTO"%>
<%@page import="room.RoomDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String roomNo = request.getParameter("roomNo");
System.out.print(roomNo); 
// 폼에서 넘어온 데이터를 변수로 넣음

RoomDAO roomDAO = new RoomDAO(application); // 1단계 2단계
RoomDTO roomDTO = roomDAO.getRoomDTO(roomNo); // 3단계 4단계
roomDAO.close(); // 5단계
%>
<!doctype html>
<html class="no-js" lang="zxx">

<%@ include file="../common/head.jsp"%>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Image Slider</title>
<!-- Owl Carousel CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.carousel.min.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.theme.default.min.css">
<!-- Custom CSS -->
<style>
.owl-carousel .item img {
	width: 100%;
	height: 700px;
}
</style>
</head>

<body>
<script type="text/javascript">
	/* 체크아웃 판단 */
	function checkOutPost(){ /* 하단에 체크아웃 버튼 클릭시 동작 */
		var confirmed = confirm("정말로 체크아웃 하시겠습니까?"); // yes=true, no=false
		
		if(confirmed){ // confirm 창에서 true
			var form = document.roomFrm; /* 아래쪽에 form 객체를 변수에 넣음 */
			form.method = "post";
			form.action = "CheckOutProcess.jsp";
			form.submit();
		}
	}
</script>
	<!--[if lte IE 9]>
	            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
	        <![endif]-->

	<!-- header-start -->
	<%@ include file="../common/header.jsp"%>
	<!-- header-end -->

	<!-- 객실페이지 메인이미지와 문구 -->
	<div class="bradcam_area breadcam_bg_1">
		<h3>Timeless Modern</h3>
		<h4 style="color: white">시대를 초월한 현대</h4>
	</div>
	<!-- 끝 -->

<div align="center">
	<br><br><br><br><br>
	<h2><%= roomNo %>호</h2>

	<form name = "roomFrm">
		<input type="hidden" name="num" value="<%= roomDTO.getRoomNum() %>"/> <!-- 다른페이지로 전달할 수 있는 값-->
		<table border="1" width="50%" align="center">
		<tr>
			<td width="10%" align="center">객실 번호</td><td><%= roomDTO.getRoomNum() %></td>
		</tr>
		<tr>
			<td width="15%" align="center">객실 타입</td><td><%= roomDTO.getRoomType() %></td>
		</tr>
		<tr>	
			<td width="15%" align="center">객실 상태</td><td><%= roomDTO.getRoomStatus() %></td>
		</tr>
		<tr>
			<td width="30%" align="center">체크인 날짜</td>
			<% if (roomDTO.getRoomCheckInNO() == null){%> <!-- 체크인날짜 공백 -->
			<td> -- </td>
			<%}else{%><td><%= roomDTO.getRoomCheckInNO() %></td><%} %>
		</tr>
		<tr>
			<td width="30%" align="center">체크아웃 날짜</td>
			<% if (roomDTO.getRoomCheckOutNO() == null){%> <!-- 체크아웃 날짜 공백 -->
			<td> -- </td>
			<%}else{%><td><%= roomDTO.getRoomCheckOutNO() %></td><%} %>
		</tr>
		
		<tr></tr><tr></tr><tr></tr>
		<tr>
			<td colspan="5" align="center">
				<button type="button" onclick="location.href='CheckIn.jsp?num=<%=roomDTO.getRoomNum()%>';">
				체크인
				</button>
				
				<button type="button" onclick="checkOutPost();">
				체크아웃
				</button>
					 
				<button type="button" onclick="location.href='../elements.jsp'">
				객실 현황 돌아가기
				</button>	
			</td> <!-- 수정, 삭제, 리스트 버튼 -->
		</tr>
		</table>
	</form>
</div>
<br><br><br>

	<!-- footer -->
	<%@ include file="../common/footer.jsp"%>

	<!-- link that opens popup -->

	<!-- form itself end-->
	<form id="test-form" class="white-popup-block mfp-hide">
		<div class="popup_box ">
			<div class="popup_inner">
				<h3>객실, 날짜, 인원 선택</h3>
				<form action="#">
					<div class="row">
						<div class="col-xl-6">
							<input id="datepicker" placeholder="Check in">
						</div>
						<div class="col-xl-6">
							<input id="datepicker2" placeholder="Check out">
						</div>
						<div class="col-xl-6">
							<select class="form-select wide" id="default-select" class="">
								<option data-display="Adult">1</option>
								<option value="1">2</option>
								<option value="2">3</option>
								<option value="3">4</option>
							</select>
						</div>
						<div class="col-xl-6">
							<select class="form-select wide" id="default-select" class="">
								<option data-display="Children">1</option>
								<option value="1">2</option>
								<option value="2">3</option>
								<option value="3">4</option>
							</select>
						</div>
						<div class="col-xl-12">
							<select class="form-select wide" id="default-select" class="">
								<option data-display="Room type">Room type</option>
								<option value="1">Laxaries Rooms</option>
								<option value="2">Deluxe Room</option>
								<option value="3">Signature Room</option>
								<option value="4">Couple Room</option>
							</select>
						</div>
						<div class="col-xl-12">
							<button type="submit" class="boxed-btn3">예약 시작하기</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</form>
	<!-- form itself end -->

	<!-- JS here -->
	<jsp:include page="../common/scripts.jsp" />


</body>

</html>