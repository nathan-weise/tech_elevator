<template>
  <div>
    <h1>My Kanban Boards</h1>
    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>
    <boards-list v-else v-bind:boards="allBoards"/>
  </div>
</template>

<script>
import boardsService from '../services/BoardService';
import BoardsList from '@/components/BoardsList';

export default {
  components: {
    BoardsList
  },
   data() {
    return {
      isLoading: true,
      allBoards: []
    };
  },
  created() {
    boardsService.getBoards().then(response => {
      this.allBoards = response.data;
      this.isLoading = false;
    });
  }
};
</script>

