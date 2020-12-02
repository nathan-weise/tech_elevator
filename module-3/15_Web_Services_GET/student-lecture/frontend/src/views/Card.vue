<template>
  <div>
      <div class="loading" v-if="isLoading">
        <img src="../assets/ping_pong_loader.gif" />
      </div>

      <card-detail v-else/>

      <div class="board-actions" v-if="!isLoading">
        <router-link v-bind:to="{ name: 'Board', params: { id: $route.params.boardID } }">
          Back to Board
        </router-link>
      </div>
    </div>
</template>

<script>
import CardDetail from '@/components/CardDetail';

export default {
  components: {
    CardDetail
  },
  data() {
    return {
      isLoading: true
    }
  }
};
</script>
