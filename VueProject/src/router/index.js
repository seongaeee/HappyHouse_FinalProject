import Vue from "vue";
import VueRouter from "vue-router";
import BoardInput from "../components/BoardInput.vue";
import BoardList from "../components/BoardList.vue";
import BoardList2 from "../components/BoardList2.vue";
import BoardDetail from "../components/BoardDetail.vue";

Vue.use(VueRouter);

export default new VueRouter({
	mode: "history",
	routes: [
		{ path: "/board", component: BoardList },
    { path: "/board/list", component: BoardList },
    { path: "/board/list2", component: BoardList2 },
    { path: "/board/input", component: BoardInput },
    { path: "/board/input/:no", component: BoardInput },
    { path: "/board/input2", component: BoardInput2 },
    { path: "/board/input2/:no", component: BoardInput2 },
		{ path: "/board/detail/:no", component: BoardDetail },
	],
});