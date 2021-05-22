<template>
  <div>
    <qna-header></qna-header>
    <b-input v-model="title" placeholder="제목을 입력해주세요."></b-input>
    <b-form-textarea
        v-model="content"
        placeholder="내용을 입력해 주세요"
        rows="3"
        max-rows="6"
    ></b-form-textarea>
    <br>
    <b-button @click="updateMode ? updateBoard() : addBoard()">저장</b-button>&nbsp;
    <b-button @click="cancle">취소</b-button>
  </div>
</template>

<script>
import QnaHeader from './QnaHeader.vue';
export default {
  components: { QnaHeader },
  name: 'BoardCreate',

  data() {
    return {
      no: '',
      id: 'tjddo님',
      title: '',
      content: '',
      //updateObject: null,
      updateMode: this.$route.params.no != null ? true : false,
    }
  },
  created() {
    console.log("notest"+this.updateMode);
      if(this.$route.params.no != null) {
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
    updateBoard() { // 수정
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
        path: '/board/list'
      })
    }
  }
}
</script>

<style>

</style>