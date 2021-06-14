<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "root" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<body>
  <!-- The 로그인 Modal -->
    <div class="modal" id="SignInModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Sign In</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form id="SignInForm" method = "post" action="/loginProcess">
                        <div class="form-group">
                            <label for="usr">ID:</label>
                            <input type="text" id="SignInID" class="form-control" name="SignInID" placeholder="login">
                        </div>
                        <div class="form-group">
                            <label for="usr">Password:</label>
                            <input type="password" id="SignInPW" class="form-control" name="SignInPW"
                                placeholder="password">
                        </div>
                        <div class="form-row float-right">
                            <button type="button" class="btn btn-primary mr-1" data-toggle="modal" data-target="#PwSearchModal">find PW</button>
                            <button type="button" id="SignInButton" class="btn btn-primary" onclick="javascript:SignIn();">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
    <!-- 비밀번호 찾기 Modal -->
    <div class="modal" id="PwSearchModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">비밀번호 찾기</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form id="findPassForm" action = "/findPass" method="post">
                        <div class="form-group">
                            <label for="usr">Name:</label>
                            <input type="text" id="FindName" class="form-control" name="name"
                                placeholder="이름">
                        </div>                    
                        <div class="form-group">
                            <label for="usr">ID:</label>
                            <input type="text" id="FindID" class="form-control" name="id" placeholder="아이디">
                        </div>
                        <div class="form-group">
                            <label for="usr">Tel:</label>
                            <input type="text" id="FindTel" class="form-control" name="tel"
                                placeholder="전화번호">
                        </div>
                        <div class="form-row float-right">
                            <button id="PwSearchButton2" type="button" class="btn btn-primary mr-2" onclick="javascript:findPass()">비밀번호찾기</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- The 마이페이지 Modal -->
    <div class="modal" id="MyPageModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">MyPage</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form id="modifyForm" action = "/modifyinfo" method="post">
                        <div class="form-group">
                            <label for="usr">ID:</label>
                            <input type="text" id="UserID" class="form-control" name="id" value=${id }>
                        </div>
                        <div class="form-group">
                            <label for="usr">Password:</label>
                            <input type="password" id="UserPW" class="form-control" name="pass" value=${pass }>
                        </div>
                        <div class="form-group">
                            <label for="usr">Name:</label>
                            <input type="text" id="UserName" class="form-control" name="name"
                                value=${name }>
                        </div>
                        <div class="form-group">
                            <label for="usr">Email:</label>
                            <input type="text" id="UserEmail" class="form-control" name="email"
                                value=${email }>
                        </div>
                        <div class="form-group">
                            <label for="usr">Address:</label>
                            <input type="text" id="UserAddress" class="form-control" name="address"
                                value=${address }>
                        </div>
                        <div class="form-group">
                            <label for="usr">Tel:</label>
                            <input type="text" id="UserTel" class="form-control" name="tel" value=${tel }>
                        </div>
                        <div class="form-row float-right">
                            <Button id="ModifyButton" type="button" class="btn btn-primary mr-1" onclick="javascript:Modify();">Modify</Button>
                            <Button id="DropOutButton" type="button" class="btn btn-primary" onclick="javascript:DropOut();">Drop Out</Button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    
        <!-- The Modal -->
    <div class="modal" id="UserInfoModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">UserInfo for Search</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form>
                        <div class="form-group">
                            <label for="usrAge">연령대</label>
                            <input type="number" id="UserAge" class="form-control" name="age" placeholder="age">
                        </div>
                        <div class="form-group">
                            <label for="usrFamily">가족형태:</label>
                            <select class="form-control-inline" style="width:120px;" id="family">
                                    <option>1인가구</option>
                                    <option>2인가구</option>
                                    <option>3~4인가구</option>
                                    <option>대가족</option>
                            </select>
                        </div>
                        <div class="form-group">
                        	<label for="usr">자녀 여부</label><br>
	                        <div class="form-check-inline">
							  <label class="form-check-label">
							    <input type="radio" class="form-check-input" name="optradio">O
							  </label>
							</div>
							<div class="form-check-inline">
							  <label class="form-check-label">
							    <input type="radio" class="form-check-input" name="optradio">X
							  </label>
							</div>
						</div>
                        <div class="form-group">
                        	<label for="usr">자가용 여부</label><br>
	                        <div class="form-check-inline">
							  <label class="form-check-label">
							    <input type="radio" class="form-check-input" name="optradio">O
							  </label>
							</div>
							<div class="form-check-inline">
							  <label class="form-check-label">
							    <input type="radio" class="form-check-input" name="optradio">X
							  </label>
							</div>
						</div>
                        <div class="form-group">
                        	<label for="usr">반려동물 여부</label><br>
	                        <div class="form-check-inline">
							  <label class="form-check-label">
							    <input type="radio" class="form-check-input" name="optradio">O
							  </label>
							</div>
							<div class="form-check-inline">
							  <label class="form-check-label">
							    <input type="radio" class="form-check-input" name="optradio">X
							  </label>
							</div>
						</div>
                        <div class="form-row float-right">
                            <button id="ModifyButton" type="button" class="btn btn-primary">Apply</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    

    <!-- The 회원 가입 Modal -->
    <div class="modal" id="SignUpModal">
        <div class="modal-dialog">
            <div class="modal-content">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Sign Up</h4>
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <form id="SignUpForm" action="/signUpProcess" method="post">
                        <div class="form-group">
                            <label for="usr">ID:</label>
                            <input type="text" id="SignUpID" class="form-control" name="id" placeholder="login">
                        </div>
                        <div class="form-group">
                            <label for="usr">Password:</label>
                            <input type="password" id="SignUpPW" class="form-control" name="pass"
                                placeholder="password">
                        </div>
                        <div class="form-group">
                            <label for="usr">Password Again:</label>
                            <input type="password" id="SignUpPW2" class="form-control" name="pass2"
                                placeholder="password">
                        </div>
                        <div class="form-group">
                            <label for="usr">Name:</label>
                            <input type="text" id="SignUpName" class="form-control" name="name" placeholder="name">
                        </div>
                        <div class="form-group">
                            <label for="usr">Email:</label>
                            <input type="text" id="SignUpEmail" class="form-control" name="email"
                                placeholder="15, Deoksugung-gil, Jung-gu, Seoul, Republic of Korea">
                        </div>
                        <div class="form-group">
                            <label for="usr">Address:</label>
                            <input type="text" id="SignUpAddress" class="form-control" name="address"
                                placeholder="address">
                        </div>
                        <div class="form-group">
                            <label for="usr">Tel:</label>
                            <input type="text" id="SignUpTel" class="form-control" name="tel" placeholder="010-">
                        </div>
                        <div class="form-row float-right">
                            <button id="SignUpButton" type="button"class="btn btn-primary" onclick="javascript:SignUp();">Submit</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

  

</body>
</html>