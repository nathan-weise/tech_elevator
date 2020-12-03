<template>
  <form v-on:submit.prevent="handleLogin">
        <div>
          <label for="username">Username:</label>
          <input id="username" type="text" v-model="user.username">
        </div>
        <div>
          <label for="password">Password:</label>
          <input id="password" type="password" v-model="user.password">
        </div>
        <button>Log In</button>
  </form>
</template>

<script>
import userService from '@/services/UserService.js';

export default {
    data() {
        return {
            user: {
                username: '',
                password: ''
            }
        }
    },
    methods: {
        handleLogin() {
            userService.getToken(this.user).then(response => {
                console.log(response.data.token);
                localStorage.setItem('token', response.data.token);
                this.$router.push({name: 'Home'});
            }).catch(error => {
                console.log(error);
            })
        }
    }

}
</script>

<style>

</style>