	$(document).ready(function(){
		searchCity();
	});
    
    function searchDong(gugun){
    	$.ajax({
    		url:'http://localhost/address/dong/' + gugun.value,
    		type: 'get',
    		dataType: 'json',
    		success: function(result){
    			setDongList(result);
    		},
    		error: function(xhr,status,msg){
				alert("상태:" + status + ", 에러메세지 : " + "해당지역에 매물이 없습니다.");
			}
    	});
    }
    
    function setDongList(result){
    	$('#dong').empty(); //tbody를 찾음, 꺽쇄 없으면 찾는거 // 있으면 만드는거. //아무튼, 테이블 비우고 다시 채울 준비
    	$('#dong').append($('<option>').append("선택"));
		$.each(result, function(index, data){
			$('#dong').append($('<option>').append(data)); //<td>123</td>
		});
    }
    
    function searchGugun(city){
    	$.ajax({
    		url:'http://localhost/address/gugun/' + city.value,
    		type: 'get',
    		dataType: 'json',
    		success: function(result){
    			setGugunList(result);
    		},
    		error: function(xhr,status,msg){
				alert("상태:" + status + ", 에러메세지 : " + "해당지역에 매물이 없습니다.");
			}
    	});
    }
    
    function setGugunList(result){
    	$('#gugun').empty(); //tbody를 찾음, 꺽쇄 없으면 찾는거 // 있으면 만드는거. //아무튼, 테이블 비우고 다시 채울 준비
    	$('#gugun').append($('<option>').append("선택"));
		$.each(result, function(index, data){
			$('#gugun').append($('<option>').append(data)); //<td>123</td>
		});
    }
    
    function searchCity(){
    	$.ajax({
			url:'http://localhost/address', //포트번호 80이라 생략가능
			type: 'get',
			dataType: 'json', //서버가 보내주는 데이터 타입
			success: function(result){ //첫 파라미터 : 서버에서 넘어오는 데이터
				setCityList(result);
			},
			error: function(xhr,status,msg){
				alert("상태:" + status + ", 에러메세지 : " + "해당지역에 매물이 없습니다.");
			}
		});
    }
    
    function setCityList(result){
    	$('#city').empty(); //tbody를 찾음, 꺽쇄 없으면 찾는거 // 있으면 만드는거. //아무튼, 테이블 비우고 다시 채울 준비
    	$('#city').append($('<option>').append("선택"));
		$.each(result, function(index, data){
			$('#city').append($('<option>').append(data)); //<td>123</td>
		});
    }

    function SignIn() {
    	var SignInID = document.getElementById("SignInID").value;
		var SignInPW = document.getElementById("SignInPW").value;
		
		if(SignInID == '' || SignInPW == ''){
			alert("아이디와 패스워드를 입력해주세요.");
    	} else {
    		//document.getElementById("SignInForm").action = "loginProcess.bod";
    		document.getElementById('SignInForm').submit();
    	}
    }
    
    function SignUp() {
    	var SignUpID = document.getElementById("SignUpID").value;
		var SignUpPW = document.getElementById("SignUpPW").value;
		var SignUpPW2 = document.getElementById("SignUpPW2").value;
		var SignUpName = document.getElementById("SignUpName").value;
		var SignUpEmail = document.getElementById("SignUpEmail").value;
		var SignUpAddress = document.getElementById("SignUpAddress").value;
		var SignUpTel = document.getElementById("SignUpTel").value;
		
		if(SignUpID == '' || SignUpPW == '' || SignUpPW2 == '' || SignUpName == '' || SignUpEmail == '' || SignUpAddress == '' || SignUpTel == ''){
			alert("항목을 입력해 입력해주세요.");
    	} else if(SignUpPW != SignUpPW2){
    		alert("비밀번호를 확인해주세요.");
    	}else {
    		document.getElementById("SignUpForm").submit();
    	}
    }
    
    function Modify(){
    	document.getElementById("modifyForm").action = "/modifyinfo";
    	document.getElementById("modifyForm").submit();
    }
    
    function DropOut(){
    	var flag = confirm("정말로 탈퇴하시겠습니까?");
    	if(flag == true){
    		document.getElementById("modifyForm").action = "/dropOut";
    		document.getElementById("modifyForm").submit();
    	}
    }
    
    function findPass(){
    	var FindName = document.getElementById("FindName").value;
		var FindID = document.getElementById("FindID").value;
		var FindTel = document.getElementById("FindTel").value;
		
		if(FindName == '' || FindID == '' || FindTel == ''){
			alert("정보를 입력해주세요.");
    	} else {
    		//document.getElementById("SignInForm").action = "loginProcess.bod";
    		document.getElementById('findPassForm').submit();
    	}
    }
    