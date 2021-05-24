import Vue from "vue";
import VueRouter from "vue-router";
import Main from "../components/main/Main.vue";
import Result from "../components/result/Result.vue";
import Detail from "../components/result/Detail.vue";
import QnaInput from "../components/qna/QnaInput.vue";
import QnaList from "../components/qna/QnaList.vue";
import QnaDetail from "../components/qna/QnaDetail.vue";
import Login from "../components/user/Login.vue";
import SignUp  from "../components/user/SignUp.vue";

Vue.use(VueRouter);

const routes = [
  { path: "/", component: Main },
  { path: "/result/:dong", component: Result },
  { path: "/detail/:dong/:aptName", component: Detail },
  { path: "/board", component: QnaList },
  { path: "/board/list", component: QnaList },
  { path: "/board/detail/:no", component: QnaDetail },
  { path: "/board/input", component: QnaInput },
  { path: "/board/input/:no", component: QnaInput },
  { path: "/login", component: Login },
  { path: "/signup", component: SignUp},
  

];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
