import Vue from "vue";
import VueRouter from "vue-router";
import Main from "../components/main/Main.vue";
import Result from "../components/result/Result.vue";
import Detail from "../components/result/Detail.vue";

Vue.use(VueRouter);

const routes = [
  { path: "/", component: Main },
  { path: "/result", component: Result },
  { path: "/detail",component: Detail },

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
