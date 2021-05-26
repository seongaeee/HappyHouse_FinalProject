<template>
  <div id="qna-input">
    <qna-header></qna-header>

    <b-row>
      <b-col cols="2"></b-col>
      <b-col cols="8">
        <b-input
          v-model="title"
          placeholder="제목을 입력해주세요."
          style="margin: bottom 0.1em;%;"
        ></b-input>
        <b-form-textarea
          v-model="content"
          placeholder="내용을 입력해 주세요"
          rows="10"
          max-rows="50"
        ></b-form-textarea>
      </b-col>
      <b-col cols="2"></b-col>
    </b-row>
    <br />
    <b-button @click="updateMode ? updateBoard() : addBoard()">저장</b-button>&nbsp;
    <b-button @click="cancle">취소</b-button>
  </div>
</template>

<script>
import QnaHeader from "./QnaHeader.vue";
export default {
  components: { QnaHeader },
  name: "BoardCreate",

  data() {
    return {
      no: "",
      id: localStorage.getItem("id"),
      title: "",
      content: "",
      //updateObject: null,
      updateMode: this.$route.params.no != null ? true : false,
    };
  },
  created() {
    console.log("notest" + this.updateMode);
    if (this.$route.params.no != null) {
      this.no = this.$route.params.no;
      //this.$store.dispatch("SHOWBOARD", { no: this.no});
      this.title = this.updateObject.title;
      this.content = this.updateObject.content;
    }
  },
  computed: {
    updateObject() {
      return this.$store.getters.board;
    },
  },
  methods: {
    addBoard() {
      if (this.title != "" && this.content != "") {
        this.$store.dispatch("ADDBOARD", {
          id: this.id,
          title: this.title,
          content: this.content,
        });
        this.$router.push("/board/list"); //목록화면으로
      } else alert("내용을 입력하세요!");
    },
    updateBoard() {
      // 수정
      if (this.title != "" && this.content != "") {
        this.$store.dispatch("UPDATEBOARD", {
          no: this.no,
          title: this.title,
          content: this.content,
        });
        this.$router.push("/board/list"); //목록화면으로
      } else alert("내용을 입력하세요!");
    },
    cancle() {
      this.$router.push({
        path: "/board/list",
      });
    },
  },
};
</script>

<style>
#qna-input {
  width: 100%;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-bottom: 4%;
}
</style>
