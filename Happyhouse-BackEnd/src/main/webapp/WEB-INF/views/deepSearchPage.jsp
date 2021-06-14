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
		
		<header>
			<div class="container mt-5" style="height:100px; font-size:20px;padding:30px;">
				<ul class="nav justify-content-end">
				  <li class="nav-item">
				    <a class="nav-link" href="#">공지사항</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" href="#">오늘의 뉴스</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link" href="#">Link</a>
				  </li>
				</ul>
			</div>
		</header>
	
		<div class="container" style="background-color:#e6f2ff;">
		      <jsp:include page="addressSelect.jsp"/>
		</div>	

		<div class="container mt-5">
			<div class="row">
				<!-- 거래정보  -->
				<div class="col-4">
					<section>
	                <form action="/selectDong">
	                <TABLE BORDER=1 CELLSPACING=1 CELLPADDING=1>
						<TR>
							<th width=50 bgcolor=#113366><font color=#ffffee size=2>번호</font></th>
							<th width=200 bgcolor=#113366><font color=#ffffee size=2>동</font></th>
							<th width=250 bgcolor=#113366><font color=#ffffee size=2>아파트명</font></th>
							<th width=100 bgcolor=#113366><font color=#ffffee size=2>코드</font></th>
							<th width=250 bgcolor=#113366><font color=#ffffee size=2>건축년도</font></th>
							<th width=80 bgcolor=#113366><font color=#ffffee size=2>지번</font></th>
							<th width=100 bgcolor=#113366><font color=#ffffee size=2>평수</font></th>
							<th width=100 bgcolor=#113366><font color=#ffffee size=2>면적</font></th>
							<th width=100 bgcolor=#113366><font color=#ffffee size=2>이미지</font></th>
									<c:forEach items="${list}" var="h">
									<tr bgcolor=pink>
										<td align=center bgcolor=pink>&nbsp;<font size=2>${ h.no}</font></td>
										<td align=center bgcolor=pink>&nbsp;<font size=2>${h.dong }</font></td>
										<td align=center bgcolor=pink>&nbsp;<font size=2>${h.aptName }</font></td>
										<td align=center bgcolor=pink>&nbsp;<font size=2>${h.code }</font></td>
										<td align=center bgcolor=pink>&nbsp;<font size=2>${h.buildYear }</font></td>
										<td align=center bgcolor=pink>&nbsp;<font size=2>${h.jibun }</font></td>
										<td align=center bgcolor=pink>&nbsp;<font size=2>${h.lat }</font></td>
										<td align=center bgcolor=pink>&nbsp;<font size=2>${h.lng }</font></td>
										<td align=center bgcolor=pink>&nbsp;<font size=2>${h.img }</font></td>
									</tr>
								</c:forEach>
					</table>
                    </form>
                </section>
				</div>
				
				<!-- 지도  -->
				<div class="col-8">
					 <section>
				<script>
				function geocode(jsonData) {
					let idx = 0;
					$.each(jsonData, function(index, vo) {
						let tmpLat;
						let tmpLng;
						$.get("https://maps.googleapis.com/maps/api/geocode/json"
								,{	key:'AIzaSyCSmVpmQjXSIVfeh72f8c4iBZKlOZr0uCw'
									, address:vo.dong+"+"+vo.aptName+"+"+vo.jibun
								}
								, function(data, status) {
									tmpLat = ${h.lat};
									tmpLng = ${h.lng};
									tmpName = ${h.aptName};
									$("#lat_"+index).text(tmpLat);
									$("#lng_"+index).text(tmpLng);
									addMarker(tmpLat, tmpLng, tmp.aptName);
								}
								, "json"
						);//get
					});//each
				}
				</script>

				<div id="map" style="width: 100%; height: 500px; margin: auto;"></div>
				<script src="https://unpkg.com/@google/markerclustererplus@4.0.1/dist/markerclustererplus.min.js"></script>
				<script defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCSmVpmQjXSIVfeh72f8c4iBZKlOZr0uCw&callback=initMap"></script>
				<script>
					var multi = {lat: 37.5665734, lng: 126.978179};
					var map;
					function initMap() {
						map = new google.maps.Map(document.getElementById('map'), {
							center: multi, zoom: 12
						});
						var marker = new google.maps.Marker({position: muwlti, map: map});
					}
					function addMarker(tmpLat, tmpLng, aptName) {
						var marker = new google.maps.Marker({
							position: new google.maps.LatLng(parseFloat(tmpLat),parseFloat(tmpLng)),
							label: aptName,
							title: aptName
						});
						marker.addListener('click', function() {
							map.setZoom(17);
							map.setCenter(marker.getPosition());
							callHouseDealInfo();
						});
						marker.setMap(map);
					}
					function callHouseDealInfo() {
						alert("you can call HouseDealInfo");
					}
				</script>
				
		</section>
				</div>
				
			</div>
		</div>
		
    <jsp:include page="modal.jsp"/>
</body>


</html>