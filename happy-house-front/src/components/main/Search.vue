<template>
    <div>
    <b-container>
        <b-row align-v="center">
            
        </b-row>
    </b-container>
    <div class="mt-3">Selected: <strong>{{ selected }}</strong></div>

    <b-container>
        <b-form-row class="vh-50 text-center" align-v="center">
            <b-col-2 ><b-button class="main-navigation-button" variant="primary">Create</b-button></b-col-2>
            <b-col-6>
              <b-form-select v-model="selected1" :options="options" style="width:20%;"></b-form-select>
              <b-form-select v-model="selected2" :options="options" style="width:20%;"></b-form-select>
              <b-form-select v-model="selected3" :options="options" style="width:20%;"></b-form-select>
            </b-col-6>
            <b-col-2><b-button class="main-navigation-button" variant="primary">Edit</b-button></b-col-2>
        </b-form-row>
    </b-container>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        selected1: null,
        selected2: null,
        selected3: null,
        options: [
          { value: null, text: 'Please select an option' },
          { value: 'a', text: 'This is First option' },
          { value: 'b', text: 'Selected Option', disabled: true },
        ]
      }
    }
  }
</script>

<style>
.form{
      width: 70%;
  height: 70%;
  margin: 40px auto;
  background: red;
}


</style>