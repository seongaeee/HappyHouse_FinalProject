<template>
  <div id="find-pass">
    <find-pass-header></find-pass-header>
    <b-row>
      <b-col cols="3"></b-col>
      <b-col cols="6">
        <b-card bg-variant="light" id="find-pass-card">
          <b-form-group label="Name:" label-for="name-Input" label-cols-sm="3">
            <b-form-input
              v-model="name"
              placeholder="Enter your Name"
              :state="nameState"
              aria-describedby="input-name-feedback"
            ></b-form-input>

            <b-form-invalid-feedback id="input-name-feedback">
              이름를 입력해주세요.
            </b-form-invalid-feedback>
          </b-form-group>
          <b-form-group label="ID:" label-for="id-Input" label-cols-sm="3">
            <b-form-input
              v-model="id"
              placeholder="Enter your ID"
              :state="idState"
              aria-describedby="input-id-feedback"
            >
            </b-form-input>

            <b-form-invalid-feedback id="input-id-feedback">
              ID를 입력해주세요.
            </b-form-invalid-feedback>
          </b-form-group>

          <b-form-group label="Tel:" label-for="Tel-Input" label-cols-sm="3">
            <b-form-input
              v-model="tel"
              placeholder="Enter your Tel"
              :state="telState"
              aria-describedby="input-tel-feedback"
            >
            </b-form-input>

            <b-form-invalid-feedback id="input-tel-feedback">
              전화번호를 입력해주세요.
            </b-form-invalid-feedback>
          </b-form-group>
        </b-card>
        <b-button @click="findPassProcess" style="margin-right: 1%; width: 150px"
          >비밀번호 찾기</b-button
        >
        <div id="message"></div>
      </b-col>
      <b-col cols="3"></b-col>
    </b-row>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import FindPassHeader from "./FindPassHeader.vue";
export default {
  components: { FindPassHeader },
  computed: {
    idState() {
      return this.id.length > 3 ? true : false;
    },
    nameState() {
      return this.name.length > 0 ? true : false;
    },
    telState() {
      return this.tel.length > 0 ? true : false;
    },
    ...mapGetters(["checklogin"]),
  },
  data() {
    return {
      id: "",
      name: "",
      tel: "",
    };
  },
  methods: {
    findPassProcess() {
      this.$store.dispatch("FINDPASS", {
        name: this.name,
        id: this.id,
        tel: this.tel,
      });
      setTimeout(() => {
        this.findResult();
      }, 100);
    },
    findResult() {
      if (this.checklogin == false) {
        document.getElementById("message").innerText = "아이디와 비밀번호를 확인해 주세요.";
      } else {
        location.href = "/profile";
      }
    },
  },
};
</script>

<style>
#find-pass {
  width: 100%;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-bottom: 4%;
}

#find-pass-card {
  margin-top: 2%;
  margin-bottom: 2%;
}

#message {
  margin: 2%;
  color: red;
}
</style>
