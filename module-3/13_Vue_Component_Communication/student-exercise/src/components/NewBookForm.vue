<template>
  <form action="" class="new-book-form">
    <input
      :type="field.type"
      :class="field.class"
      :required="field.required"
      v-for="(field, i) in inputFields"
      :key="i"
      :placeholder="field.placeholder"
      v-model="field.value"
    />
    <button @click="addBook(field)">Save</button>
  </form>
</template>

<script>
export default {
  data() {
    return {
      inputFields: [
        {
          class: "title-input",
          type: "text",
          required: true,
          placeholder: "TITLE",
          value: "",
        },
        {
          class: "author-input",
          type: "text",
          required: true,
          placeholder: "AUTHOR",
          value: "",
        },
        {
          class: "isbn-input",
          type: "text",
          required: true,
          placeholder: "ISBN",
          value: "",
        },
      ],
    };
  },
  methods: {
    addBook(b) {
      const book = {
        title: this.individualField(b).value,
        author: this.individualField(b).value,
        read: false,
        isbn: this.individualField(b).value,
      }
      this.$store.commit('ADD_BOOK',book)
    },
    individualField(singleField) {
        this.inputFields.filter((field) =>{
            return field.class === singleField.class
        }) [0]
    }
  }
}
</script>

<style>
</style>