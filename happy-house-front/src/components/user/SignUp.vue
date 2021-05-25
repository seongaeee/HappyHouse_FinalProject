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
        <b-form-input v-model="zip" placeholder="우편 번호" disabled style="margin-bottom:1%;">{{zip}}</b-form-input>
        <b-form-input v-model="address_base" placeholder="기본 주소" disabled style="margin-bottom:1%;">{{address_base}}</b-form-input>
        <b-form-input v-model="address_detail" placeholder="상세 주소" style="margin-bottom:1%;">{{address_detail}}</b-form-input>
        <b-button @click="AddressApi(1)">우편번호 검색</b-button>
      </b-form-group>

      <b-form-group
        label="Tel:"
        label-for="Tel-Input"
        label-cols-sm="3"
      >
        <b-form-input v-model="tel" placeholder="Enter your Tel"></b-form-input>
      </b-form-group>


      <hr>

      <h5 id = "select-info"> 선택 정보 입력 </h5>

      <b-form-group
        label="매물 맞춤 점수 제공받기"
        label-for="info-Input"
        label-cols-sm="3"
      >
        <b-row>
          <b-col cols="2"></b-col>
          <b-col cols="4">
            <b-form-radio v-model="scoreCheck" name="score-radios" value="Y">Y</b-form-radio>
          </b-col>
          <b-col cols="1">
            <b-form-radio v-model="scoreCheck" name="score-radios" value="N">N</b-form-radio>
          </b-col>
          <b-col cols="5"></b-col>
        </b-row>
      </b-form-group>

      <hr>

      <b-form-group
        label="Pet:"
        label-for="Pet-Input"
        label-cols-sm="3"
      >
        <b-row>
        <b-col cols="2"></b-col>
        <b-col cols="4">
          <b-form-radio v-model="pet" name="pet-radios" value="Y">Y</b-form-radio>
        </b-col>
        <b-col cols="1">
          <b-form-radio v-model="pet" name="pet-radios" value="N">N</b-form-radio>
        </b-col>
        <b-col cols="5"></b-col>
      </b-row>
      </b-form-group>

      <hr>

      <b-form-group
        label="Car:"
        label-for="Car-Input"
        label-cols-sm="3"
      >
        <b-row>
        <b-col cols="2"></b-col>
        <b-col cols="4">
          <b-form-radio v-model="car" name="car-radios" value="Y">Y</b-form-radio>
        </b-col>
        <b-col cols="1">
          <b-form-radio v-model="car" name="car-radios" value="N">N</b-form-radio>
        </b-col>
        <b-col cols="5"></b-col>
      </b-row>
      </b-form-group>

      <hr>

      <b-form-group
        label="Office:"
        label-for="Office-Input"
        label-cols-sm="3"
      >
        <b-form-input v-model="office_zip" placeholder="우편 번호" disabled style="margin-bottom:1%;">{{office_zip}}</b-form-input>
        <b-form-input v-model="office_address_base" placeholder="기본 주소" disabled style="margin-bottom:1%;">{{office_address_base}}</b-form-input>
        <b-form-input v-model="office_address_detail" placeholder="상세 주소" style="margin-bottom:1%;">{{office_address_detail}}</b-form-input>
        <b-button @click="AddressApi(2)">우편번호 검색</b-button>
      </b-form-group>

      <hr>
    
    <b-button style="width:150px; margin-top:3%;">Sign Up</b-button>
  </b-card>
  
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
        if(this.id.length < 3) {
            //document.getElementById('input-id-feedback').innerText = "ID를 입력해주세요.";
            return false;
        }else if(this.id.length == 3){
            document.getElementById('input-id-feedback').innerText = "ID를 입력해주세요.";
            return false;
        }
        else {
            document.getElementById('input-id-feedback').innerText = "이미 존재하는 아이디 입니다.";
            this.$store.dispatch("CEHCKEXIST", {
              id: this.id,
            });
            return !this.$store.state.checkexist;
        }
      },
      passState() {
        return this.pass.length > 3 ? true : false;
      },
      pass2State() {
        if(this.pass2.length <= 3) {
            return false;
        }else if(this.pass2.length == 3){
            document.getElementById('input-pass2-feedback').innerText = "비밀번호를 입력해주세요.";
            return false;
        }
        else {
            document.getElementById('input-pass2-feedback').innerText = "비밀번호가 일치하지 않습니다.";
            return this.pass2 == this.pass && this.pass2 != "" ? true : false;
        }
      },
      
    },
    mounted() {
      const script = document.createElement('script');
      script.src =
        "//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js";
      document.head.appendChild(script);
    },
    data() {
      return {
        id: "",
        pass: "",
        pass2: "",
        name: "",
        email: "",
        address_base: "",
        address_detail: "",
        zip : "",
        tel : "",
        office_zip : "",
        office_address_base : "",
        office_address_detail : "",
        scoreCheck: "",
      };
    },
    methods: {
      AddressApi(choice) { new window.daum.Postcode({ 
        oncomplete: (data) => {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분. 
          
          // 도로명 주소의 노출 규칙에 따라 주소를 조합한다. 
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          let fullRoadAddr = data.roadAddress; //도로명 주소 변수
          let extraRoadAddr = ''; // 도로명 조합형 주소 변수

          // 법정동명이 있을 경우 추가한다. (법정리는 제외) 
          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다. 
          if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){ 
            extraRoadAddr += data.bname; 
          }

          // 건물명이 있고, 공동주택일 경우 추가한다. 
          if(data.buildingName !== '' && data.apartment === 'Y'){ 
            extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName); 
          }

          // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다. 
          if(extraRoadAddr !== ''){ 
            extraRoadAddr = ' (' + extraRoadAddr + ')'; 
          }

          // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다. 
          if(fullRoadAddr !== ''){ 
            fullRoadAddr += extraRoadAddr; 
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다. 

          if(choice ==1){
            this.zip = data.zonecode; //5자리 새우편번호 사용 
            this.address_base = fullRoadAddr;
          }

          if(choice ==2){
            this.office_zip = data.zonecode; //5자리 새우편번호 사용 
            this.office_address_base = fullRoadAddr;
          }
          

        }
      }).open();
    },

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


#select-info {
		color: #2f3b52;
		margin : 2%;
	}
</style>