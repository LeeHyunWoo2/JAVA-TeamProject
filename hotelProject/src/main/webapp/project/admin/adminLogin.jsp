<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Login</title>
</head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">

<body>


		<div class="modal-header">
			<h4 class="modal-title" id="loginModalLabel">Admin Login</h4>
			<button type="button" class="close" data-bs-dismiss="modal"
				aria-label="Close">
			</button>
		</div>
		<div class="modal-body">
			<div class="container">
			<%
				String error = request.getParameter("error");
				if (error != null) {
					out.println("<div class='alert alert-danger'>");
					out.println("아이디와 비밀번호를 확인해 주세요");
					out.println("</div>");
				}
			%>
          	<form class="form-signin" action="j_security_check" method="post">
   
    			<div class="form-floating  mb-3 row">     
      				<input type="text"  class="form-control" name='j_username' required autofocus>
      				<label for="floatingInput">ID</label>      
    			</div>
    			<div class="form-floating  mb-3 row">      
     	 			<input type="password" class="form-control" name='j_password' >
    				<label for="floatingInput">Password</label>
			 	</div>
   
  				<button class="btn btn-lg btn-success" type="submit">로그인</button>
   				
  			</form>
			</div>

		</div>
</body>
</html>