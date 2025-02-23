<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head><meta charset="UTF-8">
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<title>Insert title here</title></head>

<body>
    <form id="test-form" class="white-popup-block mfp-hide" action="${pageContext.request.contextPath}/project/reservation/insert.jsp" method="post" onsubmit="return validateForm(this);">
    <div class="popup_box">
        <div class="popup_inner">
            <h3>Enter information</h3>
            <div class="row">
                <div class="col-xl-6">
                    <input type="text" id="datepicker" name="date1" placeholder="Check in">
                </div>
                <div class="col-xl-6">
                    <input type="text" id="datepicker2" name="date2" placeholder="Check out">
                </div>
                <div class="col-xl-6">
                    <select class="form-select wide" id="default-select" name="adult" class="">
                        <option data-display="성인">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                    </select>
                </div>
                <div class="col-xl-6">
                    <select class="form-select wide" id="default-select" name="children" class="">
                        <option data-display="어린이">0</option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>
                    </select>
                </div>
                <div class="col-xl-12">
                    <select class="form-select wide" id="default-select" name="roomType" class="">
                        <option data-display="Room type">Room type</option>
                        <option value="Laxaries Rooms">Laxaries Rooms</option>
                        <option value="Deluxe Room">Deluxe Room</option>
                        <option value="Signature Room">Signature Room</option>
                        <option value="Couple Room">Couple Room</option>
                    </select>
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" name="id" placeholder="ID" aria-label="ID" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" name="name" placeholder="Username" aria-label="Username" aria-describedby="basic-addon1">
                </div>
                <div class="input-group mb-3">
                    <input type="text" class="form-control" name="num" placeholder="Phonenumber" aria-label="num" aria-describedby="basic-addon1">
                </div>
                <div class="col-xl-12">
                    <button type="submit" class="boxed-btn3">Reservation</button>
                </div>
            </div>
        </div>
    </div>
</form>
      <!-- form itself end -->
      
<form id=reservation class="white-popup-block mfp-hide" action="reservation/list.jsp" method="post" onsubmit="return validateForm2(this);">
		<div class="popup_box " >
			<div class="popup_inner">
				<h3 >Reservation information</h3>
				<div class="form-floating mb-3">
				  <input type="text" class="form-control" name="name" placeholder="Name">
				</div>
				<div class="form-floating">
				  <input type="text" class="form-control" name="num" placeholder="PhoneNumber">
				</div><br/>
				<button type="submit" class="boxed-btn3" >Search</button>
			</div>
		</div>
	</form>
	
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.min.js"></script>
    <script>
        $(function() {
            $("#datepicker").datepicker();
        });
    </script>
    	<script type="text/javascript">
    	
    	
    function validateForm(form) {  // 폼 내용 검증
        // 체크인 날짜가 비어있는지 확인
        if (form.date1.value == "") {
            alert("체크인 날짜를 선택해주세요.");
            form.date1.focus();
            return false;
        }
        
        // 체크아웃 날짜가 비어있는지 확인
        if (form.date2.value == "") {
            alert("체크아웃 날짜를 선택해주세요.");
            form.date2.focus();
            return false;
        }
        
        // 방 타입이 선택되었는지 확인
        if (form.roomType.value == "Room type") {
            alert("방 타입을 선택해주세요.");
            form.roomType.focus();
            return false;
        }
        
        // ID가 입력되었는지 확인
        if (form.id.value == "") {
            alert("ID를 입력해주세요.");
            form.id.focus();
            return false;
        }
        
        // 이름이 입력되었는지 확인
        if (form.name.value == "") {
            alert("이름을 입력해주세요.");
            form.name.focus();
            return false;
        }
        
        // 번호가 입력되었는지 확인
        if (form.num.value == "") {
            alert("번호를 입력해주세요.");
            form.num.focus();
            return false;
        }
        
        // 모든 검증을 통과한 경우
        return true;
    }
    function validateForm2(form) {  // 폼 내용 검증
        // 체크인 날짜가 비어있는지 확인
        if (form.name.value == "") {
            alert("이름을 입력해주세요.");
            form.name.focus();
            return false;
        }
        
        // 체크아웃 날짜가 비어있는지 확인
        if (form.num.value == "") {
            alert("전화번호를 입력해주세요.");
            form.num.focus();
            return false;
        }
        // 모든 검증을 통과한 경우
        return true;
    }
</script>
</body>
</html>