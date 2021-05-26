<template>
<div id="qna-detail">
	<qna-header></qna-header>
	<b-row>
        <b-col></b-col>
        <b-col cols="8">
			<b-card bg-variant="light" id="sign-card">
				<br>
				<div class="content-detail-content-info">
					<div class="content-detail-content-info-left">
						<div class="content-detail-content-info-left-number">글번호: {{ board.no }}</div>
						<div class="content-detail-content-info-left-subject">제목: {{board.title}}</div>
					</div>
					<div class="content-detail-content-info-right">
						<div class="content-detail-content-info-right-user">글쓴이: {{ board.id }}</div>
						<div class="content-detail-content-info-right-created">작성일: {{ board.wdate }}</div>
						<div class="content-detail-content-info-right-created">조회수: {{ board.count }}</div>
					</div>
				</div>
				<div class="content-detail-content">{{board.content}}</div>
				<br>
				<b-button v-if="id==board.id" variant="primary" @click="updateBoard">수정</b-button>&nbsp;
				<b-button v-if="id==board.id" variant="danger" @click="deleteBoard">삭제</b-button>
			</b-card>
		</b-col>
        <b-col></b-col>
    </b-row>
</div>
</template>

<script>
import QnaHeader from './QnaHeader.vue';
	export default {
  components: { QnaHeader },
		created() {
			//action call
			var no = this.$route.params.no; //이전화면에서 파라메터 받아옴
			console.log(no);
			this.$store.dispatch("SHOWBOARD", { no: no });
		},
		computed: {
			board() {
				return this.$store.state.board;
			},
			id(){
				return localStorage.getItem('id');
			}
		},
		methods: {
		deleteBoard() {
			this.$store.dispatch("DELETEBOARD", { no: this.$route.params.no });
			this.$router.push({
				path: `/board/list`
			});
		},
		updateBoard() {
			this.$router.push({
				path: `/board/input/${this.$route.params.no}`
			});
		}
	},
	};
</script>

<style scoped>
.content-detail-content-info {
  border: 1px solid black;
  display: flex;
  justify-content: space-between;
  font-size: 20px;
}

.content-detail-content-info-left {
  width: 720px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
  padding: 1rem;
}

.content-detail-content-info-right {
  width: 300px;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  padding: 1rem;
}

.content-detail-content {
  border: 1px solid black;
  margin-top: 1rem;
  padding-top: 1rem;
  min-height: 720px;
  font-size: 20px;
}

.content-detail-button {
  border: 1px solid black;
  margin-top: 1rem;
  padding: 2rem;
}

.content-detail-comment {
  border: 1px solid black;
  margin-top: 1rem;
  padding: 2rem;
}

#qna-detail{
    width : 100%;
	font-family: Avenir, Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	text-align: center;
	color: #2c3e50;
    margin-bottom: 4%;
}
</style>