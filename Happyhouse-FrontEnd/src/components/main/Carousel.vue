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
        img-src="https://images.velog.io/images/mulgyeol/post/4819b30c-bf77-4327-a51f-fae0de158015/image.png"
      ></b-carousel-slide>

      <!-- Slides with custom text -->
      <b-carousel-slide
        caption="HAPPYHOUSE"
        text="부동산 매물에 개인 맞춤형 점수를 제공해주는 웹 서비스"
        img-src="https://images.velog.io/images/mulgyeol/post/e3b2bd5f-a316-495d-99df-2cc4b44953af/house3.jpg"
      ></b-carousel-slide>

      <b-carousel-slide
        caption="HAPPYHOUSE"
        text="부동산 매물에 개인 맞춤형 점수를 제공해주는 웹 서비스"
        img-src="https://images.velog.io/images/mulgyeol/post/cb301f4f-e920-4327-9da1-9a18144740b9/house2.jpg"
      ></b-carousel-slide>

      <b-carousel-slide caption="HAPPYHOUSE" img-blank img-alt="Blank image">
        <p>부동산 매물에 개인 맞춤형 점수를 제공해주는 웹 서비스</p>
      </b-carousel-slide>
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
