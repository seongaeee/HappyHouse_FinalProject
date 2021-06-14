<template>
  <div id="qna-list">
    <qna-header></qna-header>
    <section>
      <b-row>
        <b-col></b-col>
        <b-col cols="8">
          <div>
            <b-table
              striped
              hover
              :items="boardlist"
              :per-page="perPage"
              :current-page="currentPage"
              :fields="fields"
              @row-clicked="rowClick"
            ></b-table>
            <b-pagination
              v-model="currentPage"
              :total-rows="rows"
              :per-page="perPage"
              align="center"
            ></b-pagination>
            <b-button
              v-if="user != null"
              variant="primary"
              @click="writeContent"
              style="margin-bottom: 5%; margin-top: 1%"
              >글쓰기</b-button
            >
          </div>
        </b-col>
        <b-col></b-col>
      </b-row>
    </section>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import QnaHeader from "./QnaHeader.vue";

export default {
  components: { QnaHeader },
  name: "BoardList",
  created() {
    this.$store.dispatch("ALLBOARD");
  },
  data() {
    return {
      currentPage: 1, // 현재 페이지
      perPage: 10, // 페이지당 보여줄 갯수
      // bootstrap 'b-table' 필드 설정
      fields: [
        {
          key: "no",
          label: "번호",
        },
        {
          key: "title",
          label: "제목",
        },
        {
          key: "id",
          label: "글쓴이",
        },
        {
          key: "wdate",
          label: "작성일",
        },
        {
          key: "count",
          label: "조회수",
        },
      ],
    };
  },
  methods: {
    rowClick(item) {
      this.$router.push({
        path: `/board/detail/${item.no}`,
      });
    },
    writeContent() {
      this.$router.push({
        path: `/board/input`,
      });
    },
  },
  computed: {
    ...mapGetters(["boardlist"]),
    rows() {
      return this.boardlist.length;
    },
    user() {
      return localStorage.id;
    },
  },
};
</script>

<style>
#qna-list {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-bottom: 5%;
}
</style>
