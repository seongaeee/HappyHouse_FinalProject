<template>
  <div>
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
export default {
  name: 'BoardCreate',

  data() {
    return {
      no: '',
      title: '',
      content: '',
      updateObject: null,
      updateMode: this.$route.params.no != "" ? true : false,
    }
  },
  created() {
      if(this.$route.params.no != "") {
        this.no = this.$route.params.no;
        this.$store.dispatch("SHOWBOARD", { no: this.no});
        this.updateObject = this.$store.getters.board;
        this.title = this.updateObject.title;
        this.content = this.updateObject.content;
      } 
  },
  methods: {
    addBoard() {
				if (this.title != "" && this.content != "") {
					this.$store.dispatch("ADDBOARD", {
                        title: this.title,
                        content: this.content,
                    });
					this.clearInput();
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
			this.clearInput();
			this.$router.push("/board/list"); //목록화면으로
		} else alert("내용을 입력하세요!");
    },
    cancle() {
      this.$router.push({
        path: '/list'
      })
    }
  }
}
</script>

<style>

</style>