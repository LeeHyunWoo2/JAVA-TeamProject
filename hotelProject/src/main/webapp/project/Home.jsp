<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">

<%@ include file="common/head.jsp" %>
  <style>
        #secret-box {
            display: none; /* 초기에는 숨김 */
            position: fixed;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            width: 400px;
            height: 300px;
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            z-index: 1000;
        }

        #overlay {
            display: none; /* 초기에는 숨김 */
            position: fixed;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background: rgba(0, 0, 0, 0.5);
            z-index: 999;
        }

    </style>
<body>
		<!-- header-start -->
		<%@ include file="common/header.jsp" %>
		<!-- header-end -->
		
    <!-- Trigger the modal with a button (for testing purpose, hidden in actual use) -->
    <button type="button" class="btn btn-info btn-lg" data-bs-toggle="modal" data-bs-target="#loginModal" style="display: none;">Open Login Modal</button>

    <!-- Modal -->
    <div id="loginModal" class="modal fade" tabindex="-1" aria-labelledby="loginModalLabel" aria-hidden="true">
        <div class="modal-dialog">
        	<!-- Modal content-->
			<div class="modal-content">


        </div>
    </div>
</div>



<script>

	let activeKonami = true;

    var konamiCode = [
    	"ArrowUp", "ArrowUp", "ArrowDown", "ArrowDown",
        "ArrowLeft", "ArrowRight", "ArrowLeft", "ArrowRight",
        "b", "a"
    ]; // 총 10개

    let command = 0;

    // keydown 이벤트 리스너 추가
    document.addEventListener("keydown", function(event) {
    	if (!activeKonami) return;
    	
        if (event.key === konamiCode[command]) {
        	command++;
         // 맞출때마다 1씩 추가
         
            if (command === konamiCode.length) {
            	// 코드 전체 자릿수와 커맨드수가 일치하면
                $('#loginModal .modal-content').load('./admin/adminLogin.jsp');
                $('#loginModal').modal();
                
                // 관리자 로그인 페이지 새창으로 띄우고 커맨드 초기화
                command = 0;
            }
        } else {
        	// 틀리면 커맨드 바로 초기화
            command = 0;
        }
    });
    
    
    // 코나미 커맨드 비활성화 함수
    function disableKonami() {
    	activeKonami = false;
    }
    // 전역 함수로 선언
    window.disableKonami = disableKonami;

    function onLoginSuccess() {
        disableKonami();
        alert("관리자 로그인 성공");
    }

    
</script>
		
	
		<!-- slider_area_start -->
		<div class="slider_area">
			<div class="slider_active owl-carousel">
				<div
					class="single_slider d-flex align-items-center justify-content-center slider_bg_1">
					<div class="container">
						<div class="row">
							<div class="col-xl-12">
								<div class="slider_text text-center">
									<h3>김기원호텔</h3>
									<p>환영합니다</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div
					class="single_slider  d-flex align-items-center justify-content-center slider_bg_2">
					<div class="container">
						<div class="row">
							<div class="col-xl-12">
								<div class="slider_text text-center">
									<h3>자 여러분</h3>
									<p>오늘 뭐배웠나요</p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div
					class="single_slider d-flex align-items-center justify-content-center slider_bg_1">
					<div class="container">
						<div class="row">
							<div class="col-xl-12">
								<div class="slider_text text-center">
									<h3>10분간 쉬겠습니다</h3>
									<p></p>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div
					class="single_slider  d-flex align-items-center justify-content-center slider_bg_2">
					<div class="container">
						<div class="row">
							<div class="col-xl-12">
								<div class="slider_text text-center">
									<h3>카드찍고가라</h3>
									<p></p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- slider_area_end -->
	
		<!-- about_area_start -->
		<div class="about_area">
			<div class="container">
				<div class="row">
					<div class="col-xl-5 col-lg-5">
						<div class="about_info">
							<div class="section_title mb-20px">
								<span>About Us</span>
								<h3>
									A Luxuries Hotel <br> with Nature
								</h3>
							</div>
							<p>Suscipit libero pretium nullam potenti. Interdum, blandit
								phasellus consectetuer dolor ornare dapibus enim ut tincidunt
								rhoncus tellus sollicitudin pede nam maecenas, dolor sem. Neque
								sollicitudin enim. Dapibus lorem feugiat facilisi faucibus et.
								Rhoncus.</p>
							<a href="#" class="line-button">Learn More</a>
						</div>
					</div>
					<div class="col-xl-7 col-lg-7">
						<div class="about_thumb d-flex">
							<div class="img_1">
								<img src="${pageContext.request.contextPath}/resources/img/about/about_1.png" alt="Description">
							</div>
							<div class="img_2">
								<img src="${pageContext.request.contextPath}/resources/img/about/about_2.png" alt="Description">
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- about_area_end -->
	
		<!-- offers_area_start -->
		<div class="offers_area">
			<div class="container">
				<div class="row">
					<div class="col-xl-12">
						<div class="section_title text-center mb-100">
							<span>Our Offers</span>
							<h3>Ongoing Offers</h3>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-xl-4 col-md-4">
						<div class="single_offers">
							<div class="about_thumb">
								<img src="${pageContext.request.contextPath}/resources/img/offers/1.png" alt="DescriptionDescription">
							</div>
							<h3>
								Up to 35% savings on Club <br> rooms and Suites
							</h3>
							<ul>
								<li>Luxaries condition</li>
								<li>3 Adults & 2 Children size</li>
								<li>Sea view side</li>
							</ul>
							<a href="#" class="book_now">book now</a>
						</div>
					</div>
					<div class="col-xl-4 col-md-4">
						<div class="single_offers">
							<div class="about_thumb">
								<img src="${pageContext.request.contextPath}/resources/img/offers/2.png" alt="Description">
							</div>
							<h3>
								Up to 35% savings on Club <br> rooms and Suites
							</h3>
							<ul>
								<li>Luxaries condition</li>
								<li>3 Adults & 2 Children size</li>
								<li>Sea view side</li>
							</ul>
							<a href="#" class="book_now">book now</a>
						</div>
					</div>
					<div class="col-xl-4 col-md-4">
						<div class="single_offers">
							<div class="about_thumb">
								<img src="${pageContext.request.contextPath}/resources/img/offers/3.png" alt="Description">
							</div>
							<h3>
								Up to 35% savings on Club <br> rooms and Suites
							</h3>
							<ul>
								<li>Luxaries condition</li>
								<li>3 Adults & 2 Children size</li>
								<li>Sea view side</li>
							</ul>
							<a href="#" class="book_now">book now</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- offers_area_end -->
	
		<!-- video_area_start -->
		<div class="video_area video_bg overlay">
			<div class="video_area_inner text-center">
				<span>Montana Sea View</span>
				<h3>
					Relax and Enjoy your <br> Vacation
				</h3>
				<a href="https://www.youtube.com/watch?v=vLnPwxZdW4Y"
					class="video_btn popup-video"> <i class="fa fa-play"></i>
				</a>
			</div>
		</div>
		<!-- video_area_end -->
	
		<!-- about_area_start -->
		<div class="about_area">
			<div class="container">
				<div class="row">
					<div class="col-xl-7 col-lg-7">
						<div class="about_thumb2 d-flex">
							<div class="img_1">
								<img src="${pageContext.request.contextPath}/resources/img/about/1.png" alt="Description">
							</div>
							<div class="img_2">
								<img src="${pageContext.request.contextPath}/resources/img/about/2.png" alt="Description">
							</div>
						</div>
					</div>
					<div class="col-xl-5 col-lg-5">
						<div class="about_info">
							<div class="section_title mb-20px">
								<span>Delicious Food</span>
								<h3>
									We Serve Fresh and <br> Delicious Food
								</h3>
							</div>
							<p>Suscipit libero pretium nullam potenti. Interdum, blandit
								phasellus consectetuer dolor ornare dapibus enim ut tincidunt
								rhoncus tellus sollicitudin pede nam maecenas, dolor sem. Neque
								sollicitudin enim. Dapibus lorem feugiat facilisi faucibus et.
								Rhoncus.</p>
							<a href="#" class="line-button">Learn More</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- about_area_end -->
	
	<!-- features_room_startt -->
	<div class="features_room">
		<div class="container">
			<div class="row">
				<div class="col-xl-12">
					<div class="section_title text-center mb-100">
						<span>Featured Rooms</span>
						<h3>Choose a Better Room</h3>
					</div>
				</div>
			</div>
		</div>
		<div class="rooms_here">
			<div class="single_rooms">
				<div class="room_thumb">
					<img
						src="${pageContext.request.contextPath}/resources/img/rooms/1.png"
						alt="Description">
					<div
						class="room_heading d-flex justify-content-between align-items-center">
						<div class="room_heading_inner">
							<span>From $250/night</span>
							<h3>Superior Room</h3>
						</div>
						<a href="#" class="line-button">book now</a>
					</div>
				</div>
			</div>
			<div class="single_rooms">
				<div class="room_thumb">
					<img
						src="${pageContext.request.contextPath}/resources/img/rooms/2.png"
						alt="Description">
					<div
						class="room_heading d-flex justify-content-between align-items-center">
						<div class="room_heading_inner">
							<span>From $250/night</span>
							<h3>Deluxe Room</h3>
						</div>
						<a href="#" class="line-button">book now</a>
					</div>
				</div>
			</div>
			<div class="single_rooms">
				<div class="room_thumb">
					<img
						src="${pageContext.request.contextPath}/resources/img/rooms/3.png"
						alt="Description">
					<div
						class="room_heading d-flex justify-content-between align-items-center">
						<div class="room_heading_inner">
							<span>From $250/night</span>
							<h3>Signature Room</h3>
						</div>
						<a href="#" class="line-button">book now</a>
					</div>
				</div>
			</div>
			<div class="single_rooms">
				<div class="room_thumb">
					<img
						src="${pageContext.request.contextPath}/resources/img/rooms/4.png"
						alt="Description">
					<div
						class="room_heading d-flex justify-content-between align-items-center">
						<div class="room_heading_inner">
							<span>From $250/night</span>
							<h3>Couple Room</h3>
						</div>
						<a href="#" class="line-button">book now</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- features_room_end -->

	<!-- forQuery_start -->
	<div class="forQuery">
		<div class="container">
			<div class="row">
				<div class="col-xl-10 offset-xl-1 col-md-12">
					<div class="Query_border">
						<div class="row align-items-center justify-content-center">
							<div class="col-xl-6 col-md-6">
								<div class="Query_text">
									<p>For Reservation 0r Query?</p>
								</div>
							</div>
							<div class="col-xl-6 col-md-6">
								<div class="phone_num">
									<a href="#" class="mobile_no">+10 576 377 4789</a>
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

		
		<!-- instragram_area_end -->
	
		<!-- footer -->
		<%@ include file="common/footer.jsp" %>
	
		<!-- link that opens popup -->
		
		<jsp:include page="common/Reservation.jsp"/>
		
		<!-- JS here -->
		<jsp:include page="common/scripts.jsp"/>


</body>

</html>