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
          <b-nav-item><router-link to="/login" style="color:white;">Login</router-link></b-nav-item>
          <b-nav-item>Sign Up</b-nav-item>

          <b-nav-item-dropdown right>
            <!-- Using 'button-content' slot -->
            <template #button-content>
              <em>User</em>
            </template>
            <b-dropdown-item href="#">Profile</b-dropdown-item>
            <b-dropdown-item href="#">Sign Out</b-dropdown-item>
          </b-nav-item-dropdown>
        </b-navbar-nav>
      </b-collapse>
    </b-navbar>
  </div>
</template>

<script>


export default {
  name: "BasicNavbar",
}
</script>

<style>

#nav{
  width : 100%;
  position: fixed;
  z-index: 1;
}

</style>