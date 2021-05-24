<template>
  <div id="detail">
    <result-header></result-header>
    <section>
      {{aptdetail.no}}
      <b-row>
        <b-col cols="1">
        </b-col>
        <b-col cols="4">
          <div id ="detail-table">
            <b-table striped hover>
              <b-tr>
                <b-th>번호</b-th>
                <b-td>하이</b-td>
              </b-tr>
            </b-table>
          </div>
        </b-col>
        <b-col cols="1">
        </b-col>
        <b-col cols="6">
        </b-col>
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
      var no = this.$route.params.no;
			this.$store.dispatch("DETAIL", {no:no});
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
  #detail-table{
    margin-top : 2%;
    margin-bottom: 5%;
  }

</style>