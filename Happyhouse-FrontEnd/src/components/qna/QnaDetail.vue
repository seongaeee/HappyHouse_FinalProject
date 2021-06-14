<template>
  <div id="qna-detail">
    <qna-header></qna-header>
    <b-row>
      <b-col></b-col>
      <b-col cols="8">
        <b-card id="sign-card">
          <br />
          <table class="detail-table">
            <thead>
              <tr>
                <th rowspan="3">글번호</th>
                <td rowspan="3">{{ board.no }}</td>
                <th rowspan="3">제목</th>
                <td rowspan="3">{{ board.title }}</td>
                <th>작성자</th>
                <td>{{ board.id }}</td>
              </tr>
              <tr>
                <th>작성일</th>
                <td>{{ board.wdate }}</td>
              </tr>
              <tr>
                <th>조회수</th>
                <td>{{ board.count }}</td>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th colspan="6">내용</th>
              </tr>
              <tr>
                <td colspan="6">
                  {{ content }}
                </td>
              </tr>
            </tbody>
          </table>
          <br />
          <b-button v-if="id == board.id" variant="primary" @click="updateBoard">수정</b-button
          >&nbsp;
          <b-button v-if="id == board.id" variant="danger" @click="deleteBoard">삭제</b-button>
        </b-card>
      </b-col>
      <b-col></b-col>
    </b-row>
  </div>
</template>

<script>
import QnaHeader from "./QnaHeader.vue";
export default {
  components: { QnaHeader },
  created() {
    //action call
    var no = this.$route.params.no; //이전화면에서 파라메터 받아옴
    this.id = localStorage.getItem("id");
    console.log(no);
    this.$store
      .dispatch("SHOWBOARD", {
        no: no,
      })
      .then(() => {
        this.board = this.$store.state.board;
        this.content = this.$store.state.board.content;
      });
  },
  methods: {
    deleteBoard() {
      this.$store.dispatch("DELETEBOARD", { no: this.$route.params.no });
      this.$router.push({
        path: `/board/list`,
      });
    },
    updateBoard() {
      this.$router.push({
        path: `/board/input/${this.$route.params.no}`,
      });
    },
  },
  data() {
    return {
      board: null,
      id: null,
      content: null,
    };
  },
};
</script>

<style scoped>
#qna-detail {
  width: 100%;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-bottom: 4%;
}

table.detail-table {
  border-collapse: collapse;
  text-align: center;
  border: 1px solid rgb(204, 204, 204);
  width: 100%;
  height: 30%;
}
table.detail-table thead th {
  padding: 10px;
  font-weight: bold;
  color: #fff;
  background: #6c757d;
}
table.detail-table tbody th {
  padding: 10px;
  font-weight: bold;
  color: #fff;
  background: #6c757d;
}
table.detail-table tbody td {
  height: 500px;
  text-align: initial;
  padding: 20px;
  vertical-align: top;
}

table.detail-table td {
  border: 1px solid rgb(204, 204, 204);
}

table.detail-table th {
  border: 1px solid rgb(204, 204, 204);
}

#sign-card {
  background-color: #f8f8f8;
}
</style>
