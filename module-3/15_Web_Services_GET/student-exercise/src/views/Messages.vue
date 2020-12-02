<template>
  <div class="messages">
    <topic-details v-bind:topic="activeTopic" />
  </div>
</template>

<script>
import TopicDetails from '@/components/TopicDetails.vue';

export default {
  name: 'Messages',
  components: {
    TopicDetails
  },
  data() {
    return {
      activeTopic: {
        id: 0,
        title: '',
        messages: []
      },
    }
  }
}
</script>
