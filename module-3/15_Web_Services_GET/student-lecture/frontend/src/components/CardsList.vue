<template>
 <div class="boards">
    <board-column
      title="Planned"
      v-bind:cards="planned"
      v-bind:boardID="this.$route.params.id"
    />
    <board-column
      title="In Progress"
      v-bind:cards="inProgress"
      v-bind:boardID="this.$route.params.id"
    />
    <board-column
      title="Completed"
      v-bind:cards="completed"
      v-bind:boardID="this.$route.params.id"
    />
  </div>
</template>

<script>
import BoardColumn from '@/components/BoardColumn';

export default {
  name: 'cards-list',
  components: {
    BoardColumn
  },
  props: ['cards'],
  computed: {
    planned() {
      return this.cards.filter(card => card.status === 'Planned');
    },
    inProgress() {
      return this.cards.filter(card => card.status === 'In Progress');
    },
    completed() {
      return this.cards.filter(card => card.status === 'Completed');
    }
  }
};
</script>

<style>
.boards {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  grid-gap: 20px;
}
.board-actions {
  text-align: center;
  padding: 20px 0;
}
.board-actions a:link,
.board-actions a:visited {
  color: blue;
  text-decoration: none;
}
.board-actions a:hover {
  text-decoration: underline;
}
</style>
