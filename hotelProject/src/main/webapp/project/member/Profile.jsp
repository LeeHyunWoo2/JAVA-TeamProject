<%@page import="member.MemberDAO"%>
<%@page import="member.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/LoginCheck.jsp"%>
<%
MemberDTO memberDTO = new MemberDTO();
MemberDAO memberDAO = new MemberDAO();
String id = session.getAttribute("loginId").toString();
memberDTO = memberDAO.accountInfo(id);
memberDAO.close();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@ include file="../common/head.jsp"%>
<%@ include file="../common/header.jsp"%>
<body>
	<script type="text/javascript">
		function deleteAccount() {
			var confirmed = confirm("탈퇴하시겠습니까?"); // y/n
			if (confirmed) {
				var realConfirmed = confirm("탈퇴 시 각종 멤버십 혜택을 누릴 수 없습니다 그래도 진행하시겠습니까?")
				if (realConfirmed) {
					var form = document.accountFrm;
					form.method = "post";
					form.action = "DeleteAccountServlet.jsp";
					form.submit();
				} else {
					history.back();
				}
			}
		}
	</script>

	<div class="bradcam_area breadcam_bg_2">
		<h3>내 정보</h3>
	</div>


	<div class="container">
		<div class="row justify-content-center mt-5 mb-5">
			<div class="col-lg-5">
				<input type="hidden" name="id" value="<%=memberDTO.getId()%>" />
				<div class="form-group">
					<label>아이디 :</label> <input class="form-control" type="text"
						value=<%=memberDTO.getId()%> readonly>
				</div>
				<div class="form-group">
					<label>비밀번호 :</label> <input class="form-control" type="text"
						value="" readonly>
				</div>
				<div class="form-group">
					<label>이름 :</label> <input class="form-control" type="text"
						value=<%=memberDTO.getName()%> readonly>
				</div>
				<div class="form-group">
					<label>성별 :</label>
					<%
					if (memberDTO.getSex().equals("man")) {
					%>
					<input class="form-control" type="text" value="남성" readonly>
					<%
					} else {
					%>
					<input class="form-control" type="text" value="여성" readonly>
					<%
					}
					%>
				</div>
				<div class="form-group">
					<label>전화번호 :</label> <input class="form-control" type="text"
						value=<%=memberDTO.getNum()%> readonly>
				</div>
				<div class="form-group">
					<label>이메일 :</label> <input class="form-control" type="text"
						value=<%=memberDTO.getEmail()%> readonly>
				</div>
				<div class="form-group">
					<label>가입일 :</label> <input class="form-control" type="text"
						value=<%=memberDTO.getRegidate()%> readonly>
				</div>
				<button type="button" onclick="deleteAccount();">회원탈퇴</button>
				<button type="button" onclick="location.href='./EditAccount.jsp';">정보수정</button>
				<button type="button" onclick="location.href='../Home.jsp';">홈으로</button>
			</div>
		</div>
	</div>
	<%@ include file="../common/footer.jsp"%>
	<jsp:include page="../common/scripts.jsp" />
</body>
</html>