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
                <b-form-input v-model="id" placeholder="Enter your ID"></b-form-input>
            </b-form-group>

            <b-form-group
                label="Password:"
                label-for="password-Input"
                label-cols-sm="3"
            >
                <b-form-input v-model="pass" placeholder="Enter your Password" type="password"></b-form-input>
            </b-form-group>
        </b-card>
        <b-button @click="loginProcess" style="margin-right:1%; width:150px;">비밀번호 찾기</b-button>
        <b-button @click="loginProcess" style="width:150px;">Login</b-button>
        </b-col>
        <b-col cols="3"></b-col>
        </b-row>
</div>

</template>  

<script>
import LoginHeader from './LoginHeader.vue'
  export default {
  components: { LoginHeader },
    computed: {
      nameState() {
        return this.id.length > 2 ? true : false
      }
    },
    data() {
      return {
        id: null,
        pass: null,
      }
    },
    methods : {
        loginProcess(){
        },
    },
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


</style>