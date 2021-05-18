import Vue from "vue";
import VueRouter from "vue-router";
import BoardInput from "../components/BoardInput.vue";
import BoardList from "../components/BoardList.vue";
import BoardDetail from "../components/BoardDetail.vue";

Vue.use(VueRouter);

export default new VueRouter({
	mode: "history",
	routes: [
		{ path: "/board", component: BoardList },
    { path: "/board/list", component: BoardList },
    { path: "/board/input", component: BoardInput },
    { path: "/board/input/:no", component: BoardInput },
		{ path: "/board/detail/:no", component: BoardDetail },
	],
});