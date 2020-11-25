<template>
  <div class="well" v-on:click="updateFilter()">
    <span class="amount">{{ numberOfReviews }}</span>
    {{ rating }} Star Review{{ numberOfReviews === 1 ? '' : 's' }}
  </div>
</template>

<script>
export default {
  name: 'star-summary',
  props: ['rating'],
  methods: {
    updateFilter() {
    }
  },
  computed: {
    numberOfReviews() {
      const reviews = [];
      return reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === parseInt(this.rating) ? 1 : 0);
      }, 0);
    }
  }
};
</script>

