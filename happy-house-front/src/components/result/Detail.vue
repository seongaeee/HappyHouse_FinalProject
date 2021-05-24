<template>
  <div id="detail">
    <detail-header></detail-header>
    <section id="field">
      <div>
        <b-row>
          <b-col cols="1">
          </b-col>
          <b-col cols="5">
            <div>
              <h1>매물 정보</h1>
              <b-table striped hover :items="items"></b-table>
            </div>
          </b-col>
          <b-col cols="5">
            <h1>매물 위치</h1>
            <div id ="map" style="width:100%;height:100%;"></div>
          </b-col>
          <b-col col="1">
          </b-col>
        </b-row>
      </div>
    </section>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import DetailHeader from '../header/DetailHeader.vue';

export default {
  components: { DetailHeader },
    created() {
      var dong = this.$route.params.dong;
      var aptName = this.$route.params.aptName;
			this.$store.dispatch("DETAIL", {dong:dong, aptName:aptName});
		},
  computed: {
    ...mapGetters(["aptdetail"]),
    items(){
      var items = [
          { 구분 : '번호', 정보: this.aptdetail.no},
          { 구분 : '동', 정보: this.aptdetail.dong},
          { 구분 : '아파트', 정보: this.aptdetail.aptName},
          { 구분 : '코드', 정보: this.aptdetail.code},
          { 구분 : '건축년도', 정보: this.aptdetail.buildYear},
          { 구분 : '지번', 정보: this.aptdetail.jibun},
          { 구분 : '위도', 정보: this.aptdetail.lat},
          { 구분 : '경도', 정보: this.aptdetail.lng},
        ];
      return items;
    }
  },
  mounted() {
    if (window.kakao && window.kakao.maps) {
      this.initMap();
    } else {
      const script = document.createElement('script');
      /* global kakao */
      script.onload = () => kakao.maps.load(this.initMap);
      script.src =
        'http://dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=242fb4c309b28366b554b85bdd482fc5';
      document.head.appendChild(script);
    }
  },
  methods: {
    initMap() {
      var mapContainer = document.getElementById('map'), // 지도를 표시할 div
          mapOption = {
            center: new kakao.maps.LatLng(this.aptdetail.lat, this.aptdetail.lng), // 지도의 중심좌표
            level: 3, // 지도의 확대 레벨
          };

      var map2 = new kakao.maps.Map(mapContainer, mapOption);

            var markerPosition  = new kakao.maps.LatLng(this.aptdetail.lat, this.aptdetail.lng); 
            var marker = new kakao.maps.Marker({
                 position: markerPosition
            });
            marker.setMap(map2);
      console.log(map2);
    }
  },
}
</script>

<style>
#detail{
	width : 100%;
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
	img{
		margin-top: 8%;
	}
  #field{
    margin-top : 2%;
    margin-bottom: 5%;
  }

</style>