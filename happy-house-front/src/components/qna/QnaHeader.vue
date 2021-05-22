<template>
	<div id="qna-header">
		<img alt="Qna logo" src="../../assets/qna/qna.png" />
		<h1>HappyHouse Team9 QnA</h1>
		<div>
			<router-link to="/board/list">
				<b-button variant="primary" style="margin-bottom:1%; margin-top:1%">목록</b-button>
			</router-link>
			
		</div>
	</div>
</template>

<script>
	export default {};
</script>

<style>
	#qna-header{
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
</style>
