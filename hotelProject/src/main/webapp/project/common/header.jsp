<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<div class="header-area ">
			<div id="sticky-header" class="main-header-area">
				<div class="container-fluid p-0">
					<div class="row align-items-center no-gutters">
						<div class="col-xl-5 col-lg-6">
							<div class="main-menu  d-none d-lg-block">
								<nav>
									<ul id="navigation">
										<li><a class="active" href="${pageContext.request.contextPath}/project/Home.jsp">home</a></li>
										<li><a href="${pageContext.request.contextPath}/project/rooms.jsp">rooms</a></li>
										<li><a href="${pageContext.request.contextPath}/project/about.jsp">About</a></li>
										<li><a href="#">blog <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="${pageContext.request.contextPath}/project/blog.jsp">blog</a></li>
												<li><a href="${pageContext.request.contextPath}/project/single-blog.jsp">single-blog</a></li>
											</ul></li>
										<li><a href="#">pages <i class="ti-angle-down"></i></a>
											<ul class="submenu">
												<li><a href="${pageContext.request.contextPath}/project/elements.jsp">elements</a></li>
											</ul></li>
										<li><a href="${pageContext.request.contextPath}/project/contact.jsp">Contact</a></li>
									</ul>
								</nav>
							</div>
						</div>
						<div class="col-xl-2 col-lg-2">
							<div class="logo-img">
								<a href="${pageContext.request.contextPath}/project/Home.jsp"> <img
									src="${pageContext.request.contextPath}/resources/img/logo.png"
									alt="Description">
								</a>
							</div>
						</div>
						<div class="col-xl-5 col-lg-4 d-none d-lg-block">
							<div class="book_room">
								<div class="socail_links">
									<ul>
									<%
										if(session.getAttribute("loginId")==null){ %>
										<li><a href="${pageContext.request.contextPath}/project/member/Login.jsp"> <i class="fi fi-br-sign-in-alt"></i>
										</a></li>
										<% } else { %>
										<li><a href="${pageContext.request.contextPath}/project/member/Profile.jsp"> <i class="fi fi-rs-user"></i>
										</a></li>
										<% } %>
										<% if(session.getAttribute("loginId")!=null){ %>
										<li><a href="${pageContext.request.contextPath}/project/member/Logout.jsp"> <i class="fa fa-twitter"></i>
										</a></li>
										<% } %>
										<li><a href="#"> <i class="fa fa-instagram"></i>
										</a></li>
									</ul>
								</div>
								<div class="book_btn d-none d-lg-block">
									<a class="popup-with-form" href="#test-form">예약 하기</a>
								</div>
								<div class="book_btn d-none d-lg-block">
									<a class="popup-with-form" href="#reservation">예약 조회</a>
								</div>
							</div>
						</div>
						<div class="col-12">
							<div class="mobile_menu d-block d-lg-none"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</header>
</body>
</html>