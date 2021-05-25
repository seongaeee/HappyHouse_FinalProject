<template>
  <div id="nav">
    <b-navbar toggleable="lg" type="dark" variant="secondary">
      <b-navbar-brand><router-link to="/" style="color:white;">HappyHouse Team9</router-link></b-navbar-brand>

      <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

      <b-collapse id="nav-collapse" is-nav>
        <b-navbar-nav>
          <b-nav-item>공지사항</b-nav-item>
          <b-nav-item><router-link to="/board/list" style="color:white;">QnA</router-link></b-nav-item>
        </b-navbar-nav>

        <!-- Right aligned nav items -->
        <b-navbar-nav class="ml-auto">
          <b-nav-item v-if="user==null">
            <router-link to="/login" style="color:white;">Login</router-link>
          </b-nav-item>
          <b-nav-item class ="nav_item" v-else>
            <span style="color:white;">{{user}}님 환영합니다</span>
          </b-nav-item>
          <b-nav-item v-if="user!=null">
            <router-link to="/profile" style="color:white;">Profile</router-link>
          </b-nav-item>
          <b-nav-item class ="nav_item" v-if="user!=null">
            <a @click="logoutProcess" style="color:white;" href="#">Logout</a>
          </b-nav-item>
          <b-nav-item v-else>
            <router-link to="/signup" style="color:white;">Sign Up</router-link>
          </b-nav-item>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>


export default {
  name: "BasicNavbar",
  computed: {
    user(){
      return localStorage.name;
    },
  },
  methods: {
    logoutProcess(){
      localStorage.clear();
      location.href="/";
    }
  },
}
</script>

<style>

#nav{
  width : 100%;
  position: fixed;
  z-index: 1;
}

</style>