<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../common/head.jsp" %>
<body>

    <!-- header-start -->
    <%@ include file="../common/header.jsp" %>
    <!-- header-end -->

    <!-- bradcam_area_start -->
    <div class="bradcam_area breadcam_bg_2">
        <h3>로그인</h3>
    </div>
    <!-- bradcam_area_end -->

        <div class="container">
            <div class="row justify-content-center mt-5 mb-5">
                <div class="col-lg-6">
                    <div class="login-container">
                        <form action="LoginServlet.jsp" method="post">
                            <div class="form-group">
                                <label for="userId">아이디:</label>
                                <input type="text" name="userId" class="form-control" required autofocus>
                            </div>
                            <div class="form-group">
                                <label for="userPw">비밀번호:</label>
                                <input type="password" name="userPw" class="form-control" required>
                            </div>
                            <button type="submit" class="btn btn-primary" style="float: right;">로그인</button>
                        </form>
                        <%
                            String errorMessage = (String) request.getAttribute("errorMessage");
                            if (errorMessage != null) {
                                out.println("<p style='color:red;'>" + errorMessage + "</p>");
                            }
                        %>
                        <div align="left">
                        	<a href="register.jsp" class="genric-btn success-border circle">회원 가입</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    <!-- footer -->
    <%@ include file="../common/footer.jsp" %>
    <!-- footer_end -->

    <!-- JS here -->
    <jsp:include page="../common/scripts.jsp"/>
</body>
</html>
