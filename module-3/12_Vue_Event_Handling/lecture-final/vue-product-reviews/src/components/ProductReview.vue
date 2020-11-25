<template>
  <div class="main" v-on:click="description = 'click in main'">
    <h2>Product Reviews for {{ name }}</h2>

    <p class="description">{{ description }}</p>

    <div class="well-display">
      <div class="well">
        <span class="amount">{{ averageRating }}</span>
        Average Rating
      </div>

      <div class="well" v-on:click="ratingFilter = 1">
        <span class="amount">{{ numberOf1StarReviews }}</span>
        1 Star Review{{ numberOf1StarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well" v-on:click="ratingFilter = 2">
        <span class="amount">{{ numberOf2StarReviews }}</span>
        2 Star Review{{ numberOf2StarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well" v-on:click="ratingFilter = 3">
        <span class="amount">{{ numberOf3StarReviews }}</span>
        3 Star Review{{ numberOf3StarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well" v-on:click="ratingFilter = 4">
        <span class="amount">{{ numberOf4StarReviews }}</span>
        4 Star Review{{ numberOf4StarReviews === 1 ? "" : "s" }}
      </div>

      <div class="well" v-on:click="ratingFilter = 5">
        <span class="amount">{{ numberOf5StarReviews }}</span>
        5 Star Review{{ numberOf5StarReviews === 1 ? "" : "s" }}
      </div>
    </div>

    <a href="#" v-on:click.prevent.stop="showForm = true" v-if="!showForm">Show Form</a>
    <a href="#" v-on:click.prevent="showForm = false" v-else>Hide Form</a>
    <form v-on:submit.prevent="addNewReview()" v-show="showForm">

      <div class="form-element">
        <label for="reviewer">Name: </label>
        <input type="text" id="reviewer" v-model.lazy="newReview.reviewer" />
      </div>
      <div class="form-element">
        <label for="title">Title: </label>
        <input type="text" id="title" v-model.trim="newReview.title" />
      </div>
      <div class="form-element">
        <label for="rating">Rating: </label>
        <select id="rating" v-model.number="newReview.rating">
          <option value="1">1 Star</option>
          <option value="2">2 Stars</option>
          <option value="3">3 Stars</option>
          <option value="4">4 Stars</option>
          <option value="5">5 Stars</option>
        </select>
      </div>
      <div class="form-element">
        <label for="review">Review: </label>
        <textarea id="review" v-model="newReview.review"></textarea>
      </div>

      <button type="submit">Add Review</button>
      <button type="button" v-on:click="resetForm($event)">Clear Form</button>

    </form>

    <div
      class="review"
      v-bind:class="{ favorited: review.favorited }"
      v-for="review in filteredReviews"
      v-bind:key="review.id"
    >
      <h4>{{ review.reviewer }}</h4>
      <div class="rating">
        <img
          src="../assets/star.png"
          v-bind:title="review.rating + ' Star Review'"
          class="ratingStar"
          v-for="n in review.rating"
          v-bind:key="n"
        />
      </div>
      <h3>{{ review.title }}</h3>

      <p>{{ review.review }}</p>

      <p>
        Favorite?
        <input type="checkbox" v-model="review.favorited" />
      </p>
    </div>
  </div>
</template>

<script>
export default {
  name: "product-review",
  data() {
    return {
      name: "Cigar Parties for Dummies",
      description:
        "Host and plan the perfect cigar party for all of your squirrelly friends.",
      newReview: {},
      showForm: false,
      ratingFilter: 0,
      reviews: [
        {
          reviewer: "Malcolm Gladwell",
          title: "What a book!",
          review:
            "It certainly is a book. I mean, I can see that. Pages kept together with glue and there's writing on it, in some language.",
          rating: 3,
          favorited: false,
        },
        {
          reviewer: "Tim Ferriss",
          title: "Had a cigar party started in less than 4 hours.",
          review:
            "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
          rating: 4,
          favorited: false,
        },
        {
          reviewer: "Ramit Sethi",
          title: "What every new entrepreneurs needs. A door stop.",
          review:
            "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
          rating: 1,
          favorited: false,
        },
        {
          reviewer: "Gary Vaynerchuk",
          title: "And I thought I could write",
          review:
            "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
          rating: 3,
          favorited: false,
        },
      ],
    };
  },
  computed: {
    averageRating() {
      let total = this.reviews.reduce((sum, review) => sum + review.rating, 0);
      return total / this.reviews.length;
    },
    numberOf1StarReviews() {
      return this.countReviews(1);
    },
    numberOf2StarReviews() {
      return this.countReviews(2);
    },
    numberOf3StarReviews() {
      return this.countReviews(3);
    },
    numberOf4StarReviews() {
      return this.countReviews(4);
    },
    numberOf5StarReviews() {
      return this.countReviews(5);
    },
    filteredReviews() {
      return this.reviews.filter(review => this.ratingFilter === 0 || review.rating === this.ratingFilter);
    }
  },
  methods: {
    countReviews(rating) {
      let count = 0;
      for (let review of this.reviews) {
        if (review.rating === rating) {
          count++;
        }
      }
      return count;
    },
    addNewReview() {
      this.reviews.unshift(this.newReview);
      this.resetForm();
    },
    resetForm(event) {
      this.newReview = {};
      console.log(event);
    },
    handleKey(event) {
      if (event.key === '1') {
        this.ratingFilter = 1;
      } else if (event.key === '2') {
        this.ratingFilter = 2;
      } else if (event.key === '3') {
        this.ratingFilter = 3;
      }
      
    }
  },
  created() {
    document.body.addEventListener('keyup', this.handleKey);
  },
  destroyed() {
    document.body.removeEventListener('keyup', this.handleKey);
  }
};
</script>

<style scoped>
div.main {
  margin: 1rem 0;
}

div.main div.well-display {
  display: flex;
  justify-content: space-around;
}

div.main div.well-display div.well {
  display: inline-block;
  width: 15%;
  border: 1px black solid;
  border-radius: 6px;
  text-align: center;
  margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
  color: darkslategray;
  display: block;
  font-size: 2.5rem;
}

div.main div.review {
  border: 1px black solid;
  border-radius: 6px;
  padding: 1rem;
  margin: 10px;
}

div.main div.review.favorited {
  background-color: lightyellow;
}

div.main div.review div.rating {
  height: 2rem;
  display: inline-block;
  vertical-align: top;
  margin: 0 0.5rem;
}

div.main div.review div.rating img {
  height: 100%;
}

div.main div.review p {
  margin: 20px;
}

div.main div.review h3 {
  display: inline-block;
}

div.main div.review h4 {
  font-size: 1rem;
}

div.form-element {
  margin-top: 10px;
}
div.form-element > label {
  display: block;
}
div.form-element > input,
div.form-element > select {
  height: 30px;
  width: 300px;
}
div.form-element > textarea {
  height: 60px;
  width: 300px;
}
form > input[type="button"] {
  width: 100px;
}
form > input[type="submit"] {
  width: 100px;
  margin-right: 10px;
}
</style>

