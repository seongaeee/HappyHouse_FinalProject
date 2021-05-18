<template>
	<header>
		<img alt="Vue logo" src="../assets/logo.png" />
		<h1>TODO LIST - Vuex with Router</h1>
		<div>
			<router-link to="/input">추가</router-link> &nbsp;
			<router-link to="/list">목록</router-link>
		</div>
	</header>
</template>

<script>
	export default {};
</script>

<style scoped>
	h1 {
		color: #2f3b52;
		font-weight: 900;
		margin: 2.5rem 0 1.5rem;
	}
</style>
