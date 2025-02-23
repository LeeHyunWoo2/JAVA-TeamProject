<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="zxx">

<%@ include file="common/head.jsp" %>

<body>
    <!--[if lte IE 9]>
            <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
        <![endif]-->

    <!-- header-start -->
    <%@ include file="common/header.jsp" %>
    <!-- header-end -->

    <!-- 객실페이지 메인이미지와 문구 -->
    <div class="bradcam_area breadcam_bg_1">
        <h3>Timeless Modern</h3>
        <h4 style="color:white">시대를 초월한 현대</h4>
    </div>
    <!-- 끝 -->
    

    <!-- 객실 보기 -->
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
                    <img src="${pageContext.request.contextPath}/resources/img/rooms/1.png" alt="Description">
                    <div class="room_heading d-flex justify-content-between align-items-center">
                        <div class="room_heading_inner">
                            <span>From ￦100,000/night</span>
                            <h3>Superior Room</h3>
                        </div>
                        <a href="${pageContext.request.contextPath}/project/room/SuperiorRoom.jsp" class="line-button">Details</a>
                    </div>
                </div>
            </div>
            <div class="single_rooms">
                <div class="room_thumb">
                    <img src="${pageContext.request.contextPath}/resources/img/rooms/2.png" alt="Description">
                    <div class="room_heading d-flex justify-content-between align-items-center">
                        <div class="room_heading_inner">
                            <span>From ￦200,000/night</span>
                            <h3>Deluxe Room</h3>
                        </div>
                        <a href="${pageContext.request.contextPath}/project/room/DeluxeRoom.jsp" class="line-button">Details</a>
                    </div>
                </div>
            </div>
            <div class="single_rooms">
                <div class="room_thumb">
                    <img src="${pageContext.request.contextPath}/resources/img/rooms/3.png" alt="Description">
                    <div class="room_heading d-flex justify-content-between align-items-center">
                        <div class="room_heading_inner">
                            <span>From ￦300,000/night</span>
                            <h3>Signature Room</h3>
                        </div>
                        <a href="${pageContext.request.contextPath}/project/room/SignatureRoom.jsp" class="line-button">Details</a>
                    </div>
                </div>
            </div>
            <div class="single_rooms">
                <div class="room_thumb">
                    <img src="${pageContext.request.contextPath}/resources/img/rooms/4.png" alt="Description">
                    <div class="room_heading d-flex justify-content-between align-items-center">
                        <div class="room_heading_inner">
                            <span>From ￦400,000/night</span>
                            <h3>Couple Room</h3>
                        </div>
                        <a href="${pageContext.request.contextPath}/project/room/CoupleRoom.jsp" class="line-button">Details</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- 객실보기 끝 -->

    <!-- 문의사항 전화번호 -->
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
    <!-- 문의사항 끝 -->

    <!-- 사진과 인스타그램 연결 -->
    <div class="instragram_area">
        <div class="single_instagram">
            <img src="${pageContext.request.contextPath}/resources/img/instragram/1.png" alt="Description">
            <div class="ovrelay">
                <a href="#">
                    <i class="fa fa-instagram"></i>
                </a>
            </div>
        </div>
        <div class="single_instagram">
            <img src="${pageContext.request.contextPath}/resources/img/instragram/2.png" alt="Description">
            <div class="ovrelay">
                <a href="#">
                    <i class="fa fa-instagram"></i>
                </a>
            </div>
        </div>
        <div class="single_instagram">
            <img src="${pageContext.request.contextPath}/resources/img/instragram/3.png" alt="Description">
            <div class="ovrelay">
                <a href="#">
                    <i class="fa fa-instagram"></i>
                </a>
            </div>
        </div>
        <div class="single_instagram">
            <img src="${pageContext.request.contextPath}/resources/img/instragram/4.png" alt="Description">
            <div class="ovrelay">
                <a href="#">
                    <i class="fa fa-instagram"></i>
                </a>
            </div>
        </div>
        <div class="single_instagram">
            <img src="${pageContext.request.contextPath}/resources/img/instragram/5.png" alt="Description">
            <div class="ovrelay">
                <a href="#">
                    <i class="fa fa-instagram"></i>
                </a>
            </div>
        </div>
    </div>
    <!-- 사진 인스타그램 끝 -->
    
    <!-- footer -->
    <%@ include file="common/footer.jsp" %>

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
                                    <option value="1">Superior Room</option>
                                    <option value="2">Deluxe Room</option>
                                    <option value="3">Signature Room</option>
                                    <option value="4">Couple Room</option>
                                </select>
                            </div>
                            <div class="col-xl-12">
                                <button type="submit" class="boxed-btn3">Check Availability</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
    </form>
<!-- form itself end -->


    <!-- JS here -->
		<jsp:include page="common/scripts.jsp"/>


</body>

</html>