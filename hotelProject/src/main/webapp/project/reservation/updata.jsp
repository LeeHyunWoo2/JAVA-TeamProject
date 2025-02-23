<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<%@ include file="../common/head.jsp" %>
<body>

    <!-- header-start -->
    <%@ include file="../common/header.jsp" %>
    <!-- header-end -->

    <!-- 상단 뒤쪽에 배경사진하고 큰 제목 뜨는 코드 -->
    <div class="bradcam_area breadcam_bg_2">
        <h3>Reservation inquiry</h3>
    </div>

<script>
	function validateForm(form) {
		if(!form.rno.value){
			alert("예약번호를 입력하세요."); /* 경고창 */
			return false;
			}
		}
</script>
	<div class="container">
    	<div class="row justify-content-center mt-5 mb-5">
        	<div class="col-lg-6">
 	   		<form name="updateForm" method="post" action="updataData.jsp" onsubmit="return validateForm(this);">
    	    <div class="input-group mb-3">
        	    <span class="input-group-text" id="basic-addon1">예약 번호</span>
            	<input type="text" class="form-control" name="rno" placeholder="Reservation number">
        	</div>
        	<button type="submit" class="btn btn-outline-primary">확인</button>
    		</form>
            </div>
        </div>
    </div>
    
    
	<!-- footer -->
	<%@ include file="../common/footer.jsp"%>

	<!-- JS here -->
	<jsp:include page="../common/scripts.jsp" />    
 
</body>
</html>