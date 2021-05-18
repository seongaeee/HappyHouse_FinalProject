<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "root" value="${pageContext.request.contextPath}"/>    
<!DOCTYPE html>
<html>
<body>
<%-- 사실 ${empty sessionScope.id} 가 정확한 문장이다. / EL에서 세션 내장객체를 나타내는 이름이 sessionScope이다. --%>
<c:if test="${empty id}">
				<!-- 로그인 전 보여지는 부분 -->
                <ul id="header_nav_confirm_off" class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <button type="button" class="btn btn-primary mr-1" data-toggle="modal"
                            data-target="#SignInModal">Sign In</button>
                    </li>
                    <li class="nav-item">
                        <button type="button" class="btn btn-primary mr-1" data-toggle="modal"
                            data-target="#SignUpModal">Sign Up</button>
                    </li>
                </ul>
</c:if>

<%-- jstl은 else가 없어서 if를 두 번 써줘야 한다. --%>
<c:if test="${!empty id}">
				<!-- 로그인 후 보여지는 부분 -->
                <ul id="header_nav_confirm_on" class="navbar-nav ml-auto">
                    <li class="navbar-brand">
                        <span id='UserID'>${id }</span>
                        <span>님 환영합니다.</span>
                    </li>
                    <li class="nav-item">
                        <button id="MyPageButton" type="button" class="btn btn-primary mr-1" data-toggle="modal"
                            data-target="#MyPageModal">My Page</button>
                    </li>
                    <li class="nav-item">
                        <button id="UserInfoButton" type="button" class="btn btn-primary mr-1" data-toggle="modal"
                            data-target="#UserInfoModal">UserInfo</button>
                    </li>
                    <li class="nav-item">
	                    <a href="/logout">
	                        <button id="SignOutButton" type="button" class="btn btn-primary mr-1">Sign Out</button>
	                    </a>
                    </li>
                </ul>
</c:if>




                

</body>
</html>