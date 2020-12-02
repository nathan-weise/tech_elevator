<template>
  <div>
      <div class="loading" v-if="isLoading">
        <img src="../assets/ping_pong_loader.gif" />
      </div>

      <div v-else>
        <card-detail v-bind:card="activeCard"/>
        <comments-list v-bind:comments="activeCard.comments"/>
      </div>

      <div class="board-actions" v-if="!isLoading">
        <router-link v-bind:to="{ name: 'Board', params: { id: $route.params.boardID } }">
          Back to Board
        </router-link>
      </div>
    </div>
</template>

<script>
import CardDetail from '@/components/CardDetail';
import boardService from '@/services/BoardService.js';
import CommentsList from '@/components/CommentsList.vue';

export default {
  components: {
    CardDetail,
    CommentsList
  },
  data() {
    return {
      isLoading: true,
      activeCard: {title: '', description: ''}
    }
  },
  created() {
    boardService.getCard(this.$route.params.cardID).then(response => {
      this.activeCard = response.data;
      this.isLoading = false;
    });
  }
};
</script>
