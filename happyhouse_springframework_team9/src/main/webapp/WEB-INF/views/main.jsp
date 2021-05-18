<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var = "root" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>HappyHouse Team9</title>
    <link rel="shortcut icon" href="img/favicon.ico" />

    <!-- 1) bootstrap을 위한 js & css 등록하기 , 사용자 스크립트 파일 'js/cafe.js'도 포함시키기 -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="js/function.js"></script>

</head>

<body>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-sm fixed-top bg-light">
        <div class="container">
            <div id="navb" class="collapse navbar-collapse">
                <a href="/" class="navbar-brand" href="#">
                    <span>HappyHouse Team9</span>
                </a>

				<jsp:include page="loginCheck.jsp"/>

            </div>
        </div>
    </nav>

    <!-- Masthead -->
    <header class="masthead text-white text-center">

        <div class="container">
            <div class="row">
                <div class="col-xl-9 mx-auto mt-5">
                    <h1 style="background-image:url(img/main2.jpg); height:300px; width:100%; padding:100px"><b>행복한 우리
                            집</b></h1>
                </div>

            </div>
        </div>
    </header>
    <div class="container mb-3 mt-2" style="background-color:#e6f2ff;">
    
        <jsp:include page="addressSelect.jsp"/>
        
        <div class="row">
            <div class="col-md-12 col-lg-10 col-xl-10 mx-auto">
                <form>
                    <div class="form-row" style="height:100px;">
                        <div class="col-12 col-md-9 my-auto">
                            <div class="form-group my-auto">
                                <label for="sel2">집 크기 : </label>
                                <select class="form-control-inline selectpicker" style="width:120px;" id="size">
                                    <option>20평 이상</option>
                                    <option>30평 이상</option>
                                    <option>40평 이상</option>
                                </select>
								<label for="sel3">매물 가격 : </label>
                                <select class="form-control-inline" style="width:120px;" id="price">
                                    <option>1억 이하</option>
                                    <option>2억 이하</option>
                                    <option>3억 이하</option>
                                </select>
								<label for="sel4">평균 분석 점수 :</label>
                                <select class="form-control-inline" style="width:120px;" id="score">
                                    <option>3점 이상</option>
                                    <option>4점 이상</option>
                                </select>
                         		<label for="sel5">세부 분석 점수: </label>
                                <select class="form-control-inline" style="width:120px;" id="env">
                                    <option>환경</option>
                                </select>
                             	<select class="form-control-inline" style="width:120px;" id="traffic">
                                    <option>교통</option>
                                </select>
								<select class="form-control-inline" style="width:120px;" id="edu">
                                    <option>교육환경</option>
                                </select>
                             	<select class="form-control-inline" style="width:120px;" id="convin">
                                    <option>편의시설</option>
                                </select>
                          
                            </div>
                        </div>
                    </div>
                        <%--<div class="col-12 col-md-2 my-auto">
                        	<a href="selectDong.bod?dong=x" class="btn btn-block btn-lg btn-primary">Search!</a>
                            <a href="selectDong.bod?" class="btn btn-block btn-lg btn-primary">Search!</a>
                        </div>--%>
                </form>
            </div>
        </div>        
    </div>

    <!-- Image Showcases -->
    <section class="showcase">
        <div class="container">
            <img src="img/bg-masthead.jpg" width=100%>
        </div>
    </section>

    <!-- Testimonials -->
    <section class="testimonials bg-light">
        <div class="container mt-5">
            <div class="row">
                <img src="img/ad.jpg">
                <div style="display:inline; padding:10px 0px 0px 80px;">
                    <h3>지혜롭게 내 집 마련하기</h3>
                    <hr>
                    <p>가용자금 확인 및 대출 계획</p>
                    <p>집 종류 및 지역 선택</p>
                    <p>정보 수집 & 시세파악</p>
                    <p>부동산 방문 & 집구경</p>
                    <p>계약 및 잔금 치르기</p>
                    <p>인테리어 공사</p>
                </div>
                <div style="dispaly:inline; padding:10px 0px 0px 80px;">
                    <h3>오늘의 뉴스</h3>
                    <hr>
                    <p><a href="https://www.naver.com">네이버 기사</a></p>
                    <p><a href="https://www.naver.com">네이버 기사</a></p>
                    <p><a href="https://www.naver.com">네이버 기사</a></p>
                    <p><a href="https://www.naver.com">네이버 기사</a></p>
                    <p><a href="https://www.naver.com">네이버 기사</a></p>

                </div>
            </div>
        </div>
    </section>

    <!-- Footer -->
    <footer class="footer bg-light">
        <div class="container">
            <h3>Find Us</h3>
            <hr>
            <p>(SSAFY) 서울시 강남구 테헤란로 멀티스퀘어</p>
            <p>1544-9001</p>
            <p>admin@ssafy.com</p>
        </div>
    </footer>

	<jsp:include page="modal.jsp"/>
    
</body>


</html>