<template>
  <div class="main">
    <h1>{{ product.name }}</h1>
    <p class="description">{{ product.description }}</p>
    <review-list />
    <router-link v-bind:to="{name: 'createReview', params: {id: activeProductID}}">Add Your Review Now!</router-link>
    <div></div>
    <router-link v-bind:to="{name: 'home'}">Back to All Products</router-link>
  </div>
</template>

<script>
import ReviewList from "@/components/ReviewList.vue";
export default {
  components: {
    ReviewList,
  },
  data() {
    return {
      activeProductID: 0,
    };
  },
  computed: {
    product() {
      for (let p of this.$store.state.products) {
        if (p.id === this.activeProductID) {
          return p;
        }
      }
      return {
          name: '',
          description: ''
      };
    }
  },
  created() {
    this.activeProductID = Number(this.$route.params.id);
    this.$store.commit('SET_ACTIVE_PRODUCT', this.activeProductID)
  },
};
</script>

<style>
</style>