<template>
  <div id="signup">
      <sign-up-header></sign-up-header>
      <b-row>
          <b-col cols="3"></b-col>
          <b-col cols="6">
  <b-card bg-variant="light" id="sign-card">
    
      <b-form-group
        label="ID:"
        label-for="id-Input"
        label-cols-sm="3"
      >
        <b-form-input 
        v-model="id" 
        placeholder="Enter your ID"
        :state="idState"
        aria-describedby="input-id-feedback"
        ></b-form-input>

        <b-form-invalid-feedback id="input-id-feedback">
            id를 입력해주세요.
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

      <b-form-group
        label="password:"
        label-for="password-Input"
        label-cols-sm="3"
      >
        
        <b-form-input 
        v-model="pass2" 
        placeholder="Enter your Password" 
        type="password" 
        :state="pass2State"
        aria-describedby="input-pass2-feedback"
        trim
        >
        
        </b-form-input>

        <b-form-invalid-feedback id="input-pass2-feedback">
            비밀번호를 입력해주세요.
        </b-form-invalid-feedback>
      </b-form-group>

      <b-form-group
        label="Name:"
        label-for="name-Input"
        label-cols-sm="3"
      >
        <b-form-input v-model="name" placeholder="Enter your Name"></b-form-input>
      </b-form-group>

      <b-form-group
        label="E-mail:"
        label-for="email-Input"
        label-cols-sm="3"
      >
        <b-form-input v-model="email" placeholder="Enter your E-mail"></b-form-input>
      </b-form-group>

      <b-form-group
        label="Address:"
        label-for="address-Input"
        label-cols-sm="3"
      >
        <b-form-input v-model="address" placeholder="Enter your Address"></b-form-input>
      </b-form-group>

      <b-form-group
        label="Tel:"
        label-for="Tel-Input"
        label-cols-sm="3"
      >
        <b-form-input v-model="tel" placeholder="Enter your Tel"></b-form-input>
      </b-form-group>
    
  </b-card>
  <b-button style="width:150px;">Sign Up</b-button>
  </b-col>
  <b-col cols="3"></b-col>
  </b-row>
</div>

</template>  

<script>
import SignUpHeader from './SignUpHeader.vue'
  export default {
  components: { SignUpHeader },
    computed: {
      idState() {
        if(this.pass2.length <= 3) {
            //document.getElementById('input-id-feedback').innerText = "ID를 입력해주세요.";
            return false;
        }
        else {
            document.getElementById('input-id-feedback').innerText = "이미 존재하는 아이디 입니다.";
            //비동기로 아이디가 존재하는지 확인해야함.
            return true;
        }
      },
      passState() {
        return this.pass.length > 3 ? true : false;
      },
      pass2State() {
        if(this.pass2.length <= 3) {
            //document.getElementById('input-pass2-feedback').innerText = "비밀번호를 입력해주세요.";
            return false;
        }
        else {
            document.getElementById('input-pass2-feedback').innerText = "비밀번호가 일치하지 않습니다.";
            return this.pass2 == this.pass && this.pass2 != "" ? true : false;
        }
      },
      
    },
    data() {
      return {
        id: "",
        pass: "",
        pass2: "",
        name: "",
        email: "",
        address: "",
        tel : "",
      }
    },
    methods: {
        
    },
  }
</script>


<style>
#signup{
    width : 100%;
	font-family: Avenir, Helvetica, Arial, sans-serif;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
	text-align: center;
	color: #2c3e50;
    margin-bottom: 4%;
}

#sign-card{
    margin-top : 2%;
    margin-bottom: 2%;
}
</style>