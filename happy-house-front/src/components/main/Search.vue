<template>
    <div id="serachContainer">
    <b-container>
      <b-card-text class="text-center">
        <h2>동으로 매매정보 검색하기</h2>
      </b-card-text>
        <b-row class="text-center" align-v="center">
            <b-col></b-col>
            <b-col cols="8">
              <b-form-select v-model="sido" :options="sidolist" style="width:20%; margin:1%;" @change="updategugun">시/도</b-form-select>
              <b-form-select v-model="gugun" :options="gugunlist" style="width:20%; margin:1%;" @change="updatedong"></b-form-select>
              <b-form-select v-model="selected3" :options="donglist" style="width:20%; margin:1%;"></b-form-select>
              <b-button @click="search">search</b-button>
            </b-col>
            <b-col></b-col>
        </b-row>
        
    </b-container>

  </div>
</template>

<script>
  import { mapGetters } from "vuex";

  export default {
    data() {
      return {
        sido: null,
        gugun : null,
        dong : null,
        selected1: null,
        selected2: null,
        selected3: null,
        options: [
          { value: null, text: 'Please select an option' },
          { value: 'a', text: 'This is First option' },
          { value: 'b', text: 'Selected Option', disabled: true },
        ]
      }
    },
    created() {
			this.$store.dispatch("ALLSIDO");
		},
    computed: {
    ...mapGetters(["sidolist"]),
    ...mapGetters(["gugunlist"]),
    ...mapGetters(["donglist"]),
    },
    methods: {
      updategugun(){
        this.$store.dispatch("UPDATEGUGUN", {
          sido : this.sido,
        });
      },
      updatedong(){
        this.$store.dispatch("UPDATEDONG", {
          gugun : this.gugun,
        });
      },
      search(){
        if(this.dong != null){
          this.$store.dispatch("SEARCH", {
            dong : this.dong,
          });
          this.$router.push("/result/" + this.dong);
        }
        
      }
    },
  }
</script>

<style>
#serachContainer{
  padding: 5% 5%;
  min-height: 100%;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}



h2{
  color: rgb(100, 100, 100);
}


</style>