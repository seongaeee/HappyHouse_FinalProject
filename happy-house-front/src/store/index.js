import Vue from "vue";
import Vuex from "vuex";

import axios from "./axios-common.js";

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    boardlist: [],
    board: null,
    sidolist: [],
    gugunlist: [],
    donglist: [],
    aptlist: [],
    aptdetail: null,
  },

  getters: {
    boardlist(state) {
			//todolist return
			return state.boardlist;
		},

		board(state) {
			return state.board;
    },
    
    sidolist(state) {
      return state.sidolist;
    },

    gugunlist(state) {
      return state.gugunlist;
    },

    donglist(state) {
      return state.donglist;
    },

    aptlist(state) {
      return state.aptlist;
    },

    aptdetail(state) {
			return state.aptdetail;
    },
  },

  actions: {
    DETAIL: (store, payload) => {
      axios
        .get("/detail/no/" + payload.no)
        .then((response) => {
          store.commit("DETAIL", { aptdetail: response.data });
          console.log(response.data);
        })
        .catch((response) => {
          console.log(response);
        });
    },

    SEARCH: (store, payload) => {
      axios
        .post("/search/" + payload.dong)
        .then((response) => {
          store.commit("SEARCH", { aptlist: response.data });
        })
        .catch((response) => {
          console.log(response);
        });
    },

    ALLSIDO: (store) => {
      axios
        .get("/address")
        .then((response) => {
          store.commit("ALLSIDO", { sidolist: response.data });
        })
        .catch((response) => {
          console.log(response);
        });
    },

    UPDATEGUGUN: (store, payload) => {
      axios
        .get("/address/gugun/" + payload.sido)
        .then((response) => {
          store.commit("UPDATEGUGUN", { gugunlist: response.data });
        })
        .catch((response) => {
          console.log(response);
        });
    },

    UPDATEDONG: (store, payload) => {
      axios
        .get("/address/dong/" + payload.gugun)
        .then((response) => {
          store.commit("UPDATEDONG", { donglist: response.data });
        })
        .catch((response) => {
          console.log(response);
        });
    },

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
				.delete("/board/" + payload.no)
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
      axios
        .put("/board", {
          no: payload.no,
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
    ALLSIDO:(state, payload) => {
      state.sidolist = payload.sidolist;
    },
    UPDATEGUGUN: (state, payload) => {
      state.gugunlist = payload.gugunlist;
    },
    UPDATEDONG: (state, payload) => {
      state.donglist = payload.donglist;
    },
    SEARCH: (state, payload) => {
      state.aptlist = payload.aptlist;
    },
    DETAIL: (state, payload) => {
      state.aptdetail = payload.aptdetail;
    },
	},
});
