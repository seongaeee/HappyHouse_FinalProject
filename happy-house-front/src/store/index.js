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
    checkexist: false,
    checklogin: false,
    user: null,
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

    checkexist(state) {
      return state.checkexist;
    },

    user(state) {
      return state.user;
    },

    checklogin(state) {
      return state.checklogin;
    }
  },

  actions: {
    FINDPASS: (store, payload) => {
			//console.log(payload);
			axios
        .post("/findPass", {
          name: payload.name,
          id: payload.id,
          tel: payload.tel,
        })
        .then((response) => {
          if (response.data == "") {
            store.commit("LOGINFAIL", { check: false });
          }
          else {
            console.log(response.data);
            store.commit("LOGIN", { user: response.data });
          }
				})
				.catch((exp) => alert("회원정보 찾기에 실패하였습니다." + exp));
    },
    SIGNUP: (store, payload) => {
			//console.log(payload);
			axios
        .post("/signUpProcess", {
          id: payload.id,
          pass: payload.pass,
          name: payload.name,
          email: payload.email,
          tel: payload.tel,
          car: payload.car,
          pet: payload.pet,
          scoreCheck: payload.scoreCheck,
          zip : payload.zip,
          address_base: payload.address_base,
          address_detail: payload.address_detail,
          office_zip : payload.office_zip,
          office_address_base : payload.address_base,
          office_address_detail : payload.address_detail,
        })
				.then(() => {
          console.log("회원가입 처리하였습니다.");
          store.commit("LOGIN", { user: payload });
				})
				.catch((exp) => alert("회원가입에 실패하였습니다." + exp));
    },
    LOGIN: (store, payload) => {
			//console.log(payload);
			axios
        .post("/loginProcess", {
          id: payload.id,
          pass: payload.pass,
        })
        .then((response) => {
          if (response.data == "") {
            store.commit("LOGINFAIL", { check: false });
          }
          else {
            console.log(response.data);
            store.commit("LOGIN", { user: response.data });
          }
				})
				.catch((exp) => alert("로그인에 실패하였습니다." + exp));
    },

    UPDATEPROFILE: (store, payload) => {
			//console.log(payload);
			axios
        .post("/modifyinfo", {
          id: payload.id,
          pass: payload.pass,
          name: payload.name,
          email: payload.email,
          tel: payload.tel,
          car: payload.car,
          pet: payload.pet,
          scoreCheck: payload.scoreCheck,
          zip : payload.zip,
          address_base: payload.address_base,
          address_detail: payload.address_detail,
          office_zip : payload.office_zip,
          office_address_base : payload.address_base,
          office_address_detail : payload.address_detail,
        })
				.then(() => {
          console.log("정보를 수정하였습니다.");
          store.commit("LOGIN", { user: payload });
				})
				.catch((exp) => alert("정보 수정에 실패하였습니다." + exp));
    },

    CEHCKEXIST : (store, payload) => {
      axios
        .get("/getMember/" + payload.id)
        .then((response) => {
          store.commit("CEHCKEXIST", { checkexist: response.data });
          console.log(response.data);
        })
        .catch((response) => {
          console.log(response);
        });
    },

    DETAIL: (store, payload) => {
      axios
        .get("/detail/" + payload.dong +"/" + payload.aptName)
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
    CEHCKEXIST: (state, payload) => {
      state.checkexist = payload.checkexist;
    },
    LOGIN: (state, payload) => {
      state.user = payload.user;
      localStorage.setItem('id', payload.user.id);
      localStorage.setItem('name', payload.user.name);
      localStorage.setItem('email', payload.user.email);
      localStorage.setItem('tel', payload.user.tel);
      localStorage.setItem('car', payload.user.car);
      localStorage.setItem('pet', payload.user.pet);
      localStorage.setItem('scoreCheck', payload.user.scoreCheck);
      localStorage.setItem('zip', payload.user.zip);
      localStorage.setItem('address_base', payload.user.address_base);
      localStorage.setItem('address_detail', payload.user.address_detail);
      localStorage.setItem('office_zip', payload.user.office_zip);
      localStorage.setItem('office_address_base', payload.user.office_address_base);
      localStorage.setItem('office_address_detail', payload.user.office_address_detail);
      state.checklogin = true;
    },
    LOGINFAIL: (state, payload) => {
      state.checklogin = payload.check;
      state.checklogin = false;
    },
	},
});
