<template>
  <div>
    <reading-list></reading-list>
    <router-link v-bind:to="{name: 'addBook'}">Add Book</router-link>
  </div>
</template>

<script>
import ReadingList from "@/components/ReadingList.vue";
export default {
  components: {
    ReadingList
  },
};
</script>

<style>
</style>