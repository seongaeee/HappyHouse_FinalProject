<template>
  <transition name="modal">
    <div v-if="visible" class="modal-mask">
      <div class="modal-wrapper">
        <div class="modal-container">
          <div class="modal-header">
            <slot name="header"> default header </slot>
          </div>
          <div class="modal-body">
            <slot name="body"> default body </slot>
          </div>
          <div class="modal-footer">
            <slot name="footer">
              default footer
              <button type="button" class="modal-close-button" @click="$emit('close')">
                close
              </button>
            </slot>
          </div>
        </div>
      </div>
    </div>
  </transition>
</template>
<script>
export default {
  props: {
    visible: {
      type: Boolean,
      default: false,
    },
  },
  watch: {
    visible(value) {
      if (value) {
        document.body.style.overflow = "none";
      } else {
        document.body.style.overflow = "auto";
      }
    },
  },
  mounted() {
    const script = document.createElement("script");
    script.src = "//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js";
    document.head.appendChild(script);
  },
  methods: {
    AddressApi() {
      new window.daum.Postcode({
        oncomplete: (data) => {
          // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

          // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
          // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
          let fullRoadAddr = data.roadAddress; //도로명 주소 변수
          let extraRoadAddr = ""; // 도로명 조합형 주소 변수

          // 법정동명이 있을 경우 추가한다. (법정리는 제외)
          // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
          if (data.bname !== "" && /[동|로|가]$/g.test(data.bname)) {
            extraRoadAddr += data.bname;
          }

          // 건물명이 있고, 공동주택일 경우 추가한다.
          if (data.buildingName !== "" && data.apartment === "Y") {
            extraRoadAddr += extraRoadAddr !== "" ? ", " + data.buildingName : data.buildingName;
          }

          // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
          if (extraRoadAddr !== "") {
            extraRoadAddr = " (" + extraRoadAddr + ")";
          }

          // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
          if (fullRoadAddr !== "") {
            fullRoadAddr += extraRoadAddr;
          }

          // 우편번호와 주소 정보를 해당 필드에 넣는다.
          this.zip = data.zonecode; //5자리 새우편번호 사용
          this.address_base = fullRoadAddr;
        },
      }).embed(this.$refs.embed);
    },
  },
};
</script>
<style scoped>
.modal-mask {
  position: fixed;
  z-index: 9998;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: table;
  transition: opacity 0.3s ease;
}

.modal-wrapper {
  display: table-cell;
  vertical-align: middle;
}

.modal-container {
  width: 300px;
  margin: 0 auto;
  padding: 20px 30px;
  background-color: #fff;
  border-radius: 2px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.33);
  transition: all 0.3s ease;
  font-family: Helvetica, Arial, sans-serif;
}

.modal-close-button {
  float: right;
}

.modal-enter-active,
.modal-leave-active {
  transition: opacity 0.5s;
}
.modal-enter,
.modal-leave-to {
  opacity: 0;
}
</style>
