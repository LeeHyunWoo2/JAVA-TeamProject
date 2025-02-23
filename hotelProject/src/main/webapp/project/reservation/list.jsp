<%@page import="utils.JSFunction"%>
<%@page import="reservation.ReservationDTO"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="reservation.ReservationDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ReservationDAO dao = new ReservationDAO(application); // 1,2단계
	String name = request.getParameter("name");
	String num = request.getParameter("num");
	ReservationDTO dto = dao.list(name, num); // 3,4단계
	dao.close();
	
%>
<!DOCTYPE html><html lang="en">
<%@ include file="../common/head.jsp" %>
<body>

    <!-- header-start -->
    <%@ include file="../common/header.jsp" %>
    <!-- header-end -->

    <!-- 상단 뒤쪽에 배경사진하고 큰 제목 뜨는 코드 -->
    
<% 
	if(dto.getId() != null){
%>
    <div class="bradcam_area breadcam_bg_2">
        <h3>Reservation information</h3>
    </div>
    <div class="container">
            <div class="row justify-content-center mt-5 mb-5">
                <div class="col-lg-6">
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
    <tr>
      <td>
     	<form id="updata" action="updata.jsp" method="post">
			<button type="submit" class="btn btn-outline-primary">예약변경</button>
		</form>
      </td>
      <td>
      	<form id="delete" action="delete.jsp" method="post">
			<button type="submit" class="btn btn-outline-primary">예약취소</button>
		</form>
      </td>
    </tr>
  </tbody>
</table>
		</div>
	</div>
</div>
<%
	}else{
		JSFunction.alertLocation("입력정보를 확인해주세요", "../Home.jsp", out);
	}
%>


    <!-- footer -->
    <%@ include file="../common/footer.jsp" %>
    <!-- footer_end -->

    <!-- JS here -->
    <jsp:include page="../common/scripts.jsp"/>

</body>
</html>