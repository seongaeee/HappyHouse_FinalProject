<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
<title>HappyHouse Team9-Error page</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<script>
	function Modify(){
		document.getElementById("modifyForm").action = "/modifyinfo";
		document.getElementById("modifyForm").submit();
	}
</script>	
	
	
</head>
<body>
	<div class="container">
		<div class="jumbotron">
			<h1>바로 회원 정보를 수정해 주세요.</h1>

			<form id="modifyForm" action="/modifyinfo" method="post">
				<div class="form-group">
					<label for="usr">ID:</label> <input type="text" id="UserID"
						class="form-control" name="id" value=${id }>
				</div>
				<div class="form-group">
					<label for="usr">Password:</label> <input type="password"
						id="UserPW" class="form-control" name="pass" value=${pass }>
				</div>
				<div class="form-group">
					<label for="usr">Name:</label> <input type="text" id="UserName"
						class="form-control" name="name" value=${name }>
				</div>
				<div class="form-group">
					<label for="usr">Email:</label> <input type="text" id="UserEmail"
						class="form-control" name="email" value=${email }>
				</div>
				<div class="form-group">
					<label for="usr">Address:</label> <input type="text"
						id="UserAddress" class="form-control" name="address"
						value=${address }>
				</div>
				<div class="form-group">
					<label for="usr">Tel:</label> <input type="text" id="UserTel"
						class="form-control" name="tel" value=${tel }>
				</div>
				<div class="form-row float-right">
					<Button id="ModifyButton" type="button"
						class="btn btn-primary mr-1" onclick="javascript:Modify();">Modify</Button>
				</div>
			</form>
		</div>
		<p>
			<a href="/">메인으로 가기</a>
		</p>
	</div>
</body>
</html>