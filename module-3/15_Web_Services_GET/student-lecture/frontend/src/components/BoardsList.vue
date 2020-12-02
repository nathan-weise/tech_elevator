<template>
  <div class="boards">
      <div
        class="board"
        v-for="board in boards" v-bind:key="board.id"
        v-bind:style="{ 'background-color': board.backgroundColor }"
      >
        <router-link v-bind:to="{ name: 'Board', params: { id: board.id } }">
          {{ board.title }}
        </router-link>
      </div>
  </div>
</template>

<script>

export default {
  props: ['boards'],
 
};
</script>

<style scoped>
.boards {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.board {
  background-color: #f7fafc;
  border-radius: 10px;
  padding: 40px;
  flex: 1;
  margin: 0 20px;
  text-align: center;
}

.board a:link,
.board a:visited {
  color: rgb(243, 243, 243);
  text-decoration: none;
}
</style>
