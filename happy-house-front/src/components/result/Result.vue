<template>
  <div id="apt-list">
    <result-header></result-header>
    <section>
      <b-row>
        <b-col></b-col>
              <b-col cols="8">
                  <div id="result-table">
                      <b-table
                      striped
                      hover
                      :items="aptlist"
                      :per-page="perPage"
                      :current-page="currentPage"
                      :fields="fields"
                      @row-clicked="rowClick"
                      ></b-table>
                      <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage" align="center"></b-pagination>
                  </div>
              </b-col>
          <b-col></b-col>
      </b-row>
    </section>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import ResultHeader from '../header/ResultHeader.vue';

export default {
  components: { ResultHeader },
    created() {
      var dong = this.$route.params.dong;
			this.$store.dispatch("SEARCH", {dong:dong});
		},
    data() {
    return {
      currentPage: 1, // 현재 페이지
      perPage: 5, // 페이지당 보여줄 갯수
      // bootstrap 'b-table' 필드 설정
      fields: [
        {
          key: "no",
          label: "번호"
        },
        {
          key: "dong",
          label: "동"
        },
        {
          key: "aptName",
          label: "아파트"
        },
        {
          key: "code",
          label: "코드"
        },
        {
          key: "buildYear",
          label: "건축년도"
        },
        {
          key: "jibun",
          label: "지번"
        },
        {
          key: "lat",
          label: "위도"
        },
        {
          key: "lng",
          label: "경도"
        },
      ],
    };
  },
  computed: {
    ...mapGetters(["aptlist"]),
    rows() {
      return this.aptlist.length;
    },
  },
  methods: {
    rowClick(item) {
      this.$router.push({
        path: `/detail/${item.no}`
      });
    },
  },
}
</script>

<style>
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
    margin-bottom : 5%;
  }

</style>