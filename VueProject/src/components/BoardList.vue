<template>
	<section>
		<transition-group name="list" tag="ul">
			<li v-for="board in boardlist" :key="board.no" class="shadow">
				<span @click="showBoard(board.no)">
					{{ board.no }}. {{ board.title }}
				</span>
				<span class="removeBtn" type="button" @click="removeBoard(board.no)">
					<i class="far fa-trash-alt" aria-hidden="true"></i>
				</span>
			</li>
		</transition-group>
		<boardFooter></boardFooter>
	</section>
</template>

<script>
	import BoardFooter from "../components/BoardFooter";
	import { mapGetters, mapActions } from "vuex";

	export default {
		created() {
			this.$store.dispatch("ALLBOARD");
		},

		computed: {
			...mapGetters(["boardlist"]), 
		},

		methods: {
			...mapActions({removeBoard: "DELETEBOARD"}),
			showBoard(no) {
				this.$router.push("board/detail/" + no);
			},
		},
		components: {
			BoardFooter,
		},
	};
</script>

<style scoped>
	.del {
		text-decoration: line-through;
	}
	ul {
		list-style-type: none;
		padding-left: 0px;
		margin-top: 0;
		text-align: left;
	}
	li {
		display: flex;
		min-height: 50px;
		height: 50px;
		line-height: 50px;
		margin: 0.5rem 0;
		padding: 0 0.9rem;
		background: white;
		border-radius: 5px;
	}
	.checkBtn {
		line-height: 45px;
		color: #62acde;
		margin-right: 5px;
	}
	.removeBtn {
		margin-left: auto;
		color: #de4343;
	}

	.list-enter-active,
	.list-leave-active {
		transition: all 1s;
	}
	.list-enter,
	.list-leave-to {
		opacity: 0;
		transform: translateY(30px);
	}
</style>
