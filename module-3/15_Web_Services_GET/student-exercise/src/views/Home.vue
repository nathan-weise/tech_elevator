<template>
  <div class="home">
    <h1>Topic Message Board</h1>
    <topic-list v-bind:topics="allTopics"/>
  </div>
</template>

<script>
import TopicList from '@/components/TopicList.vue';

export default {
  name: 'Home',
  components: {
    TopicList
  },
  data() {
    return {
      allTopics: []
    }
  }
}
</script>
