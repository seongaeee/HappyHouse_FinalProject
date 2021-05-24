<template>
  <div id="detail">
    <result-header></result-header>
    <section>
      <div>
        <b-table striped hover :items="items"></b-table>
      </div>
    </section>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import ResultHeader from '../header/ResultHeader.vue';

export default {
  components: { ResultHeader },
    created() {
      var aptName = this.$route.params.aptName;
			this.$store.dispatch("DETAIL", {aptName:aptName});
		},
    data() {
      return {
        items: [
            { 구분: '번호', 정보: 'no'},
            { 구분: '동', 정보: 'Dickerson'},
            { 구분: '아파트', 정보: 'Dickerson'},
            { 구분: '코드', 정보: 'Dickerson'},
            { 구분: '건축년도', 정보: 'Dickerson'},
            { 구분: '지번', 정보: 'Dickerson'},
            { 구분: '위도', 정보: 'Dickerson'},
            { 구분: '경도', 정보: 'Dickerson'},
        ],
      };
  },
  computed: {
    ...mapGetters(["aptdetail"]),
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
  #result-table{
    margin-top : 2%;
  }

</style>