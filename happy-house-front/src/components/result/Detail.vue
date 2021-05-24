<template>
  <div id="detail">
    <detail-header></detail-header>
    <section id="field">
      <div>
        <b-row>
          <b-col cols="1">
          </b-col>
          <b-col cols="4">
            <div>
              <b-table striped hover :items="items"></b-table>
            </div>
          </b-col>
          <b-col cols="1"></b-col>
          <b-col cols="6">
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
      var no = this.$route.params.no;
			this.$store.dispatch("DETAIL", {no:no});
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
  methods: {

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