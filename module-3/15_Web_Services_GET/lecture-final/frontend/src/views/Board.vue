<template>
  <div>
    <h1>{{ title }}</h1>

    <div class="loading" v-if="isLoading">
      <img src="../assets/ping_pong_loader.gif" />
    </div>

    <cards-list v-else v-bind:cards="allCards"/>

    <div class="board-actions" v-if="!isLoading">
      <router-link v-bind:to="{name: 'Home'}">Back to Boards</router-link>
    </div>
  </div>
</template>

<script>
import boardsService from '../services/BoardService';
import CardsList from '@/components/CardsList';

export default {
  components: {
    CardsList
  },
   data() {
    return {
      title: '',
      allCards: [],
      isLoading: true
    };
  },
  created() {
    boardsService.getCards(this.$route.params.id).then(response => {
      this.title = response.data.title;
      this.allCards = response.data.cards;
      this.isLoading = false;
    });
  },
};
</script>
