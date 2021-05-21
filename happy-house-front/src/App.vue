<template>
  <div id="app">
    <div class="alert alert-success">This is a sweet success message</div>
    <basic-header></basic-header>
    test
    <router-view />
  </div>
</template>

<script>
import BasicHeader from "./components/header/BasicHeader.vue";


	export default {
		name: "app",
		components: {
      BasicHeader,

		},
	};
</script>

