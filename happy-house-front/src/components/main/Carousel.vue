<template>
  <div id="carousel">
    <b-carousel
      id="carousel-1"
      v-model="slide"
      :interval="4000"
      controls
      indicators
      background="#ababab"
      style="text-shadow: 1px 1px 2px #333"
      @sliding-start="onSlideStart"
      @sliding-end="onSlideEnd"
    >
      <!-- Text slides with image -->
      <b-carousel-slide
        caption="HAPPYHOUSE"
        text="부동산 매물에 개인 맞춤형 점수를 제공해주는 웹 서비스"
        img-src="https://picsum.photos/1024/480/?image=52"
      ></b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide
        img-src="https://images.velog.io/images/mulgyeol/post/4819b30c-bf77-4327-a51f-fae0de158015/image.png"
      >
        <h1>HAPPYHOUSE</h1>
      </b-carousel-slide>

      <b-carousel-slide caption="HAPPYHOUSE" img-blank img-alt="Blank image">
        <p>부동산 매물에 개인 맞춤형 점수를 제공해주는 웹 서비스</p>
      </b-carousel-slide>

      <!-- Slides with image only -->
      <b-carousel-slide
        img-src="https://images.velog.io/images/mulgyeol/post/4819b30c-bf77-4327-a51f-fae0de158015/image.png"
      ></b-carousel-slide>
    </b-carousel>
  </div>
</template>

<script>
export default {
  data() {
    return {
      slide: 0,
      sliding: null,
    };
  },
  methods: {
    onSlideStart() {
      this.sliding = true;
    },
    onSlideEnd() {
      this.sliding = false;
    },
  },
};
</script>

<style>
.carousel-item img {
  height: 400px !important;
  width: 800px !important;
  margin: auto;
}

#carousel {
  padding-top: 55px;
}
</style>
