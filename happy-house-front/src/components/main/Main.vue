<template>
  <div id="main-page">
    <carousel></carousel>
    <search></search>
    
  </div>
</template>

<script>

import Carousel from './Carousel.vue';
import Search from './Search.vue';

export default {
  components: { Carousel, Search },
  

}
</script>

<style>
#main-page{
  width : 100%;
  height : 100%;
  position: relative;
}

</style>