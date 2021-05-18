<template>
	<div class="inputBox shadow">
		<input
			type="text"
			v-model="newBoard.title"
			placeholder="제목을 입력하세요"
		/>
		<input
			type="text"
			v-model="newBoard.content"
			placeholder="내용을 입력하세요"
		/>
		<span class="addContainer" @click="addBoard">
			<i class="addBtn fas fa-plus" aria-hidden="true"></i>
		</span>
	</div>
</template>

<script>
	export default {
		data() {
			return {
				newBoard: {
					title : "",
					content : "",
					id : "tjddo님",
				},
			};
		},
		methods: {
			addBoard() {
				if (this.newBoard.title != "" && this.newBoard.content != "") {
					this.$store.dispatch("ADDBOARD", this.newBoard);
					this.clearInput();
					this.$router.push("/board/list"); //목록화면으로
				} else alert("내용을 입력하세요!");
			},
			clearInput() {
				this.newBoard.title = "";
				this.newBoard.content = "";
			},
		},
	};
</script>

<style scoped>
	input {
		outline: none;
		background: gainsboro;
	}
	.inputBox {
		background: white;
		height: 50px;
		line-height: 50px;
		border-radius: 5px;
	}
	.inputBox input {
		border-style: none;
		font-size: 0.9rem;
	}
	.addContainer {
		float: right;
		background: linear-gradient(to right, #6478fb, #8763fb);
		display: inline-block;
		width: 3rem;
		border-radius: 0 5px 5px 0;
	}
	.addBtn {
		color: white;
		vertical-align: middle;
	}
</style>
