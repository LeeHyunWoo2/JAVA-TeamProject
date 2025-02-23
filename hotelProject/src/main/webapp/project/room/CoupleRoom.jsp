<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<!-- 객실 선택 메뉴 -->
	<div class="features_room">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="section_title text-center mb-100">
						<a href="SuperiorRoom.jsp">Superior Room</a>&nbsp&nbsp&nbsp&nbsp&nbsp
						<a href="DeluxeRoom.jsp">Deluxe Room</a>&nbsp&nbsp&nbsp&nbsp&nbsp
						<a href="SignatureRoom.jsp">Signature Room</a>&nbsp&nbsp&nbsp&nbsp&nbsp
						<a href="CoupleRoom.jsp">Couple Room</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- 객실 보기 -->
	<div class="container">
		<div class="row">
			<div class="col-xl-12">
				<div class="section_title text-center mb-100">
					<h3>Couple Room</h3>
				</div>
			</div>
		</div>
	</div>

	<!-- 객실 사진 슬라이드 -->
	<div class="owl-carousel">
		<div class="item">
			<img
				src="${pageContext.request.contextPath}/resources/img/rooms/1.png"
				alt="Image 1">
		</div>
		<div class="item">
			<img
				src="${pageContext.request.contextPath}/resources/img/rooms/2.png">
		</div>
		<div class="item">
			<img
				src="${pageContext.request.contextPath}/resources/img/rooms/3.png">
		</div>
	</div>

	<!-- jQuery -->
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<!-- Owl Carousel JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/owl-carousel/1.3.3/owl.carousel.min.js"></script>
	<!-- Custom JS -->
	<script>
		$(document).ready(function() {
			$(".owl-carousel").owlCarousel({
				items : 1, // 슬라이드 하나에 하나의 이미지만 표시
				loop : true, // 슬라이드가 끝나면 처음으로 돌아가게 설정
				margin : 20, // 이미지 사이의 여백 설정
				nav : true, // 네비게이션 화살표 표시
				autoplay : true, // 자동 슬라이드 설정
				autoplayTimeout : 3000, // 자동 슬라이드 전환 시간 (밀리초)
				autoplayHoverPause : true
			// 슬라이드가 멈출 때 마우스를 올리면 일시 정지
			});
		});
	</script>
	<!-- 슬라이드 끝 -->


	<!-- 객실 소개 -->

	<div align="center">
		<hr>
		<span><h4>객실정보</h4> <br> 객실면적 &nbsp&nbsp&nbsp
			27.44㎡&nbsp&nbsp&nbsp 침대타입 &nbsp&nbsp&nbsp 씰리 포켓 스프링의 퀸 베드
			&nbsp&nbsp&nbsp 객실전망 &nbsp&nbsp&nbsp 노오션뷰</span>
		<hr>
		<br>
		<h4>객실 제공 서비스</h4>
		<br> 무료 Wifi <br> 개별 발코니 <br> 침실 LED 43인치 TV <br>
		냉장고, 전기 포트 (객실 내 냉장고는 소음이 없는 제품으로 9℃ - 12℃를 유지합니다.) <br> 전자식 금고 <br>
		헤어 드라이기 <br> 비데 욕실 용품, 베스로브 <br> 베이비 침대, 아기 욕조 무료 대여 (24개월
		이하, 사전 예약 필수) <br> 자동 온도 조절 시스템, 220V 전원
		<hr>
		<br> 이용 안내<br>
		<table border="1">
			<tr>
				<td width="13%" align="center">구분</td>
				<td width="20%" align="center">성수기</td>
				<td width="34%" align="center">비수기(금~일, 공휴일)</td>
				<td width="33%" align="center">비수기(월~목)</td>
			</tr>
			<tr>
				<td width="13%" align="center">체크인</td>
				<td width="20%" align="center">16:00</td>
				<td width="34%" align="center">16:00</td>
				<td width="33%" align="center">15:00</td>
			</tr>
			<tr>
				<td width="13%" align="center">체크아웃</td>
				<td width="20%" align="center">11:00</td>
				<td width="34%" align="center">11:00</td>
				<td width="33%" align="center">11:00</td>
			</tr>
		</table>
		<br>
		<hr>
		<br>
		<h4>예약 취소 / 변경 규정</h4><br><br><br>

		[비수기] <br> 체크인 3일 전: 위약금 없음 <br> 체크인 2일 전: 객실료의 30% 취소 위약금 부과 <br> 체크인 1일 전: 객실료의 50%
		취소 위약금 부과 <br> 당일 취소 및 No-Show: 객실료의 100% 취소 위약금 부과 <br><br>
		[성수기] <br> 2024. 1/12~2/3,2/9~2/11, 3/1~3/2, 5/4~5/5, 6/6~6/8, 7/19~8/17, 9/14~9/17, 10/3~10/5,12/31 <br><br><br>
		체크인 7일 전: 위약금 없음 <br> 체크인 5-6일 전: 객실료의 30% 취소 위약금 부과 <br> 체크인 3-4일 전: 객실료의
		50% 취소 위약금 부과 <br> 체크인 1-2일 전: 객실료의 100% 취소 위약금 부과 <br> 당일 취소 및 No-Show: 객실료의
		100% 취소 위약금 부과 <br><br> ※ 예약 조건에 따라 취소 및 변경이 불가할 수 있습니다. <br> ※ 추가 부대 시설 상품도 동일한 취소
		/ 변경 규정으로 위약금이 발생됩니다.
	</div>
	<!-- 객실 소개 끝 -->

	<!-- forQuery_start -->
	<div class="forQuery">
		<div class="container">
			<div class="row">
				<div class="col-xl-10 offset-xl-1 col-md-12">
					<div class="Query_border">
						<div class="row align-items-center justify-content-center">
							<div class="col-xl-6 col-md-6">
								<div class="Query_text">
									<p>📞Call for reservation</p>
								</div>
							</div>
							<div class="col-xl-6 col-md-6">
								<div class="phone_num">
									<a href="#" class="mobile_no">+10 5163 4062</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- forQuery_end-->

	<!-- instragram_area_start -->
	<div class="instragram_area">
		<div class="single_instagram">
			<img
				src="${pageContext.request.contextPath}/resources/img/instragram/1.png"
				alt="Description">
			<div class="ovrelay">
				<a href="#"> <i class="fa fa-instagram"></i>
				</a>
			</div>
		</div>
		<div class="single_instagram">
			<img
				src="${pageContext.request.contextPath}/resources/img/instragram/2.png"
				alt="Description">
			<div class="ovrelay">
				<a href="#"> <i class="fa fa-instagram"></i>
				</a>
			</div>
		</div>
		<div class="single_instagram">
			<img
				src="${pageContext.request.contextPath}/resources/img/instragram/3.png"
				alt="Description">
			<div class="ovrelay">
				<a href="#"> <i class="fa fa-instagram"></i>
				</a>
			</div>
		</div>
		<div class="single_instagram">
			<img
				src="${pageContext.request.contextPath}/resources/img/instragram/4.png"
				alt="Description">
			<div class="ovrelay">
				<a href="#"> <i class="fa fa-instagram"></i>
				</a>
			</div>
		</div>
		<div class="single_instagram">
			<img
				src="${pageContext.request.contextPath}/resources/img/instragram/5.png"
				alt="Description">
			<div class="ovrelay">
				<a href="#"> <i class="fa fa-instagram"></i>
				</a>
			</div>
		</div>
	</div>
	<!-- instragram_area_end -->

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