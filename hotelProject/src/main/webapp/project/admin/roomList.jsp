<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">
<%-- <%@ include file="./common/adminLoggedIn.jsp" %> <!-- 관리자 로그인상태 확인 --> --%>
<%@ include file="../common/head.jsp"%>
<head>
<script type="text/javascript">
// 체크인 화면 팝업
function checkIn(form){
	url = "./elements.jsp"
	open(url, "checkIn", "toolbar=no, location=no, status=no, menubar=no, scrollbars=no, resizable=no, width=800, height=1200")
}
</script>
</head>
<body>
	<!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

	<!-- header-start -->
	<%@ include file="../common/header.jsp"%>
	<!-- header-end -->

	<!-- bradcam_area_start -->
	<div class="bradcam_area breadcam_bg">
		<h3>관리자 메뉴</h3>
	</div>
	<!-- bradcam_area_end -->

	<!-- 객실 현황 -->
	<section class="button-area">
		<div class="container box_1170 border-top-generic">
		<form name="popup" method="get" action="./room/RoomManage.jsp">
			<div class="button-group-area mt-10 " align="center">
				<button type="button" class="btn btn-primary m-5 pb-5" onclick="checkIn();"><br><br>객실 관리 <span class="badge badge-light">🏨</span></button>
				<button type="button" class="btn btn-primary m-5 pb-5" onclick="money();"><br><br>금고 관리 <span class="badge badge-light">업데이트 예정</span></button>
			</div>
		</form>
		</div>
	</section>
	
	<!-- End Button -->

	

	<!-- footer -->
	<%@ include file="../common/footer.jsp"%>
	<!-- footer_end -->

	<!-- form itself end-->
	<form id="test-form" class="white-popup-block mfp-hide">
		<div class="popup_box ">
			<div class="popup_inner">
				<h3>Check Availability</h3>
				<form action="#">
					<div class="row">
						<div class="col-xl-6">
							<input id="datepicker" placeholder="Check in date">
						</div>
						<div class="col-xl-6">
							<input id="datepicker2" placeholder="Check out date">
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
							<button type="submit" class="boxed-btn3">Check
								Availability</button>
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