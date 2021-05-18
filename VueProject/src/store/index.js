import Vue from "vue";
import Vuex from "vuex";

import axios from "./axios-common.js";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    boardlist: [],
    board: null,
  },

  getters: {
    boardlist(state) {
			//todolist return
			return state.boardlist;
		},

		board(state) {
			return state.board;
		},
  },

  actions: {
		ALLBOARD: (store) => {
			axios
				.get("/board")
				.then((response) => {
					store.commit("ALLBOARD", { boardlist: response.data });
				})
				.catch((response) => {
					console.log(response);
				});
    },
    
		DELETEBOARD: (store, payload) => {
			axios
				.delete("/board/" + payload)
				.then(() => {
					console.log("삭제 성공!");
					store.dispatch("ALLBOARD");
				})
				.catch((response) => {
					console.log(response);
				});
		},

		SHOWBOARD: (store, payload) => {
			console.log(payload);
			axios
				.get("/board/" + payload.no)
				.then((response) => {
					console.log("조회 처리하였습니다.");
					store.commit("SHOWBOARD", { board: response.data }); //call mutation
				})
				.catch((exp) => alert("조회 처리에 실패하였습니다." + exp));
    },
    
		ADDBOARD: (store, payload) => {
			//console.log(payload);
			axios
        .post("/board", {
          id: payload.id,
          title: payload.title,
          content: payload.content,
        })
				.then(() => {
					console.log("추가 처리하였습니다.");
					store.dispatch("ALLBOARD"); //call action
				})
				.catch((exp) => alert("추가 처리에 실패하였습니다." + exp));
    },
    UPDATEBOARD: (store, payload) => {
      //console.log(payload);
      axios
        .put("/board", {
          id: payload.id,
          title: payload.title,
          content: payload.content,
        })
        .then(() => {
          console.log("수정 처리하였습니다.");
          store.dispatch("ALLBOARD"); //call action
        })
        .catch((exp) => alert("수정 처리에 실패하였습니다." + exp));
    },
	},
	//메소드 형식. 파라메터로 (state, payload)를 사용할 수 있음
	mutations: {
		ALLBOARD: (state, payload) => {
			state.boardlist = payload.boardlist;
		},
		SHOWBOARD: (state, payload) => {
			state.board = payload.board;
		},
	},
});
