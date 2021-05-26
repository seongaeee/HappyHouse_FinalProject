<template>
	<div id="detail">
		<detail-header></detail-header>
		<section id="field">
			<div>
				<b-row>
					<b-col cols="1"> </b-col>
					<b-col cols="5">
						<div>
							<h1>매물 정보</h1>
							<table class="info-table">
								<thead>
									<tr>
										<th scope="cols">구분</th>
										<th scope="cols">정보</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<th scope="row">번호</th>
										<td>{{no}}</td>
									</tr>
									<tr>
										<th scope="row" class="even">동</th>
										<td class="even">{{dong}}</td>
									</tr>
									<tr>
										<th scope="row" >아파트</th>
										<td>{{aptName}}</td>
									</tr>
									<tr>
										<th scope="row" class="even">코드</th>
										<td class="even">{{code}}</td>
									</tr>
									<tr>
										<th scope="row">건축년도</th>
										<td>{{buildYear}}</td>
									</tr>
									<tr>
										<th scope="row" class="even">지번</th>
										<td class="even">{{jibun}}</td>
									</tr>
									<tr>
										<th scope="row">위도</th>
										<td>{{lat}}</td>
									</tr>
									<tr>
										<th scope="row" class="even">경도</th>
										<td class="even">{{lng}}</td>
									</tr>
									<tr v-if="value!=null">
										<th scope="row">개인 맞춤 점수</th>
										<td>{{score}}</td>
									</tr>
								</tbody>
							</table>
						</div>
					</b-col>
					<b-col cols="5">
						<h1>매물 위치</h1>
						<div id="map" style="width: 100%; height: 100%"></div>
					</b-col>
					<b-col col="1"> </b-col>
				</b-row>
				<b-row>
					<b-col col="4"></b-col>
					<b-col col="4">
						<div
							id="stars"
							v-if="value != null"
							style="margin-top: 15%"
						>
							<h2 class="mt-3">개인 맞춤 점수</h2>
							<b-progress :max="10" height="2rem">
								<b-progress-bar
									:value="value"
									:label="`${((value / 10) * 10).toFixed(2)}점`"
								></b-progress-bar>
							</b-progress>
						</div>
					</b-col>
					<b-col col="4"></b-col>
				</b-row>
			</div>
		</section>
	</div>
</template>

<script>
	//	import { mapGetters } from "vuex";
	import DetailHeader from "../header/DetailHeader.vue";

	export default {
		components: { DetailHeader },
		created() {
			this.dong = this.$route.params.dong;
			this.aptName = this.$route.params.aptName;
			this.id = localStorage.id;
			this.car = localStorage.car;
			this.pet = localStorage.pet;
			this.scoreCheck = localStorage.scoreCheck;
			this.office_address_base = localStorage.office_address_base;
			this.office_zip = localStorage.office_zip;

			if (this.id != null) {
				this.$store
					.dispatch("UPGRADEDETAIL", {
						dong: this.dong,
						aptName: this.aptName,
						id: this.id,
						car: this.car,
						pet: this.pet,
						scoreCheck: this.scoreCheck,
						office_address_base: this.office_address_base,
						office_zip: this.office_zip,
					})
					.then(() => {
						//this.mapCheck();
						this.aptdetail = this.$store.state.aptdetail;
            			this.value = this.$store.state.aptdetail.score;
						this.mapCheck();
						this.getItems();
					});
			} else {
				//일단 로그인 안한 경우만 처리
				this.$store
					.dispatch("DETAIL", {
						dong: this.dong,
						aptName: this.aptName,
					})
					.then(() => {
						this.aptdetail = this.$store.state.aptdetail;
						this.mapCheck();
						this.getItems();
					});
			}
		},
		mounted() {
			//this.mapCheck();
		},
		methods: {
			getItems() {
				this.no = this.aptdetail.no;
				this.dong = this.aptdetail.dong;
				this.aptName = this.aptdetail.aptName;
				this.code = this.aptdetail.code;
				this.buildYear = this.aptdetail.buildYear;
				this.jibun = this.aptdetail.jibun;
				this.lat = this.aptdetail.lat;
				this.lng = this.aptdetail.lng;
				if(this.aptdetail.score != null){
					this.score = this.aptdetail.score;
				}
			},
			mapCheck() {
				if (window.kakao && window.kakao.maps) {
					this.initMap();
				} else {
					const script = document.createElement("script");
					/* global kakao */
					script.onload = () => kakao.maps.load(this.initMap);
					script.src =
						"http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=242fb4c309b28366b554b85bdd482fc5";
					document.head.appendChild(script);
				}
			},
			initMap() {
				var mapContainer = document.getElementById("map"), // 지도를 표시할 div
					mapOption = {
						center: new kakao.maps.LatLng(
							this.aptdetail.lat,
							this.aptdetail.lng
						), // 지도의 중심좌표
						level: 3, // 지도의 확대 레벨
					};

				var map = new kakao.maps.Map(mapContainer, mapOption);

				var markerPosition = new kakao.maps.LatLng(
					this.aptdetail.lat,
					this.aptdetail.lng
				);
				var marker = new kakao.maps.Marker({
					position: markerPosition,
				});
				marker.setMap(map);
			},
		},
		data() {
			return {
				aptdetail: null,
				max: 10,
				id: "",
				car: "",
				pet: "",
				scoreCheck: "",
				office_address_base: "",
				office_zip: "",
				items: null,
        		value: null,
				no: null,
				dong: null,
				aptName: null,
				code: null,
				buildYear: null,
				jibun: null,
				lat: null,
				lng: null,
				score :null,
			};
		},
	};
</script>

<style>
	#detail {
		width: 100%;
		font-family: Avenir, Helvetica, Arial, sans-serif;
		-webkit-font-smoothing: antialiased;
		-moz-osx-font-smoothing: grayscale;
		text-align: center;
		color: #2c3e50;
	}
	h1 {
		color: #2f3b52;
		font-weight: 900;
		margin: 2.5rem 0 1.5rem;
	}
	img {
		margin-top: 8%;
	}
	#field {
		margin-top: 2%;
		margin-bottom: 5%;
	}

	table.info-table {
  border-collapse: collapse;
  text-align: center;
  line-height: 3;
  border-top: 1px solid #ccc;
  border-bottom: 1px solid #ccc;
  width: 100%;
  height: 30%;
}
table.info-table thead th {
  width: 45%;
  padding: 10px;
  font-weight: bold;
  vertical-align: top;
  color: #fff;
  background: #6c757d;
  margin: 20px 10px;
}

table.info-table .even {
  background: #c5c5c5;
}
</style>
