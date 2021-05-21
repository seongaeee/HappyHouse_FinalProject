<template>
  <div id="app">
    <basic-header></basic-header>
    <router-view />
    <basic-footer></basic-footer>
  </div>
</template>

<script>
import BasicFooter from './components/footer/BasicFooter.vue';
import BasicHeader from "./components/header/BasicHeader.vue";


	export default {
		name: "app",
		components: {
      BasicHeader,
      BasicFooter,

		},
	};
</script>

<style>
#app{
  background-color: rgb(212, 212, 212);
  min-height: 100%;
  position: relative;
  padding-bottom: 260px;
}
</style>
