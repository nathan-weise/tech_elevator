<template>
  <div>
    <h1>{{ card.title }}</h1>
    <p>{{ card.description }}</p>
  </div>
</template>

<script>
export default {
  name: "card-detail",
  props: ['card']
};
</script>
