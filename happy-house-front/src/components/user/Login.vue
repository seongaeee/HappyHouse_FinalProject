<template>
  <div id="login">
      <login-header></login-header>
      <b-row>
          <b-col cols="3"></b-col>
          <b-col cols="6">
          <b-card bg-variant="light" id="login-card">
            <b-form-group
                label="ID:"
                label-for="id-Input"
                label-cols-sm="3"
            >
                <b-form-input 
                v-model="id" 
                placeholder="Enter your ID"
                :state="idState"
                aria-describedby="input-id-feedback">
                </b-form-input>

                <b-form-invalid-feedback id="input-id-feedback">
                  ID를 입력해주세요.
                </b-form-invalid-feedback>
            </b-form-group>
            <b-form-group
              label="Password:"
              label-for="password-Input"
              label-cols-sm="3"
            >
              <b-form-input 
                v-model="pass" 
                placeholder="Enter your Password" 
                type="password"
                :state="passState"
                aria-describedby="input-pass-feedback"
                ></b-form-input>

              <b-form-invalid-feedback id="input-pass-feedback">
                  비밀번호를 입력해주세요.
              </b-form-invalid-feedback>
            </b-form-group>
          </b-card>
        <b-button style="margin-right:1%; width:150px;">비밀번호 찾기</b-button>
        <b-button @click="loginProcess" style="width:150px;">Login</b-button>
        <div id = "message"></div>
        </b-col>
        <b-col cols="3"></b-col>
        </b-row>
</div>

</template>  

<script>
import LoginHeader from './LoginHeader.vue'
import { mapGetters } from "vuex";
  export default {
  components: { LoginHeader },
    computed: {
      idState() {
        return this.id.length > 3 ? true : false;
      },
      passState() {
        return this.pass.length > 3 ? true : false;
      },
      ...mapGetters(["checklogin"]),
    },
    data() {
      return {
        id: "",
        pass: "",
      }
    },
    methods : {
        loginProcess(){
          this.$store.dispatch("LOGIN", {
            id: this.id,
            pass: this.pass,
          });
          setTimeout(() => {
            this.loginResult();
          }, 100);
        },
        loginResult(){
          if(this.checklogin == false){
            document.getElementById('message').innerText = "입력 값을 확인해 주세요.";
          }else{
            location.href="/";
          }
        }
    }
  }
</script>

<style>

#login{
    width : 100%;
	font-family: Avenir, Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	text-align: center;
	color: #2c3e50;
    margin-bottom: 4%;
}

#login-card{
    margin-top : 2%;
    margin-bottom: 2%;
}

#message{
  margin: 2%;
  color: red;
}

</style>