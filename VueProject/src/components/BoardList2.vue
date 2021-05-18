<template>
  <div>
    <b-table
      striped
      hover
      :items="boardlist"
      :per-page="perPage"
      :current-page="currentPage"
      :fields="fields"
      @row-clicked="rowClick"
    ></b-table>
    <b-pagination v-model="currentPage" :total-rows="rows" :per-page="perPage" align="center"></b-pagination>
    <b-button @click="writeContent">글쓰기</b-button>
  </div>
</template>

<script>
import { mapGetters } from "vuex";

export default {
    name: "BoardList",
    created() {
			this.$store.dispatch("ALLBOARD");
		},
  data() {
    return {
      currentPage: 1, // 현재 페이지
      perPage: 10, // 페이지당 보여줄 갯수
      // bootstrap 'b-table' 필드 설정
      fields: [
        {
          key: "no",
          label: "번호"
        },
        {
          key: "title",
          label: "제목"
        },
        {
          key: "id",
          label: "글쓴이"
        },
        {
          key: "wdate",
          label: "작성일"
        }
      ],
    };
  },
  methods: {
    rowClick() {
    //   this.$router.push({
    //     path: `/board/detail/${item.content_id}`
    //   });
    },
    writeContent() {
      this.$router.push({
        path: `/board/input`
      });
    }
  },
  computed: {
    ...mapGetters(["boardlist"]),
    rows() {
      return this.boardlist.length;
    },
  }
};

</script>