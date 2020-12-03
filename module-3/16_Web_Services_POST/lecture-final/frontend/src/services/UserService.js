import axios from 'axios';

const http = axios.create({
  baseURL: 'http://localhost:3000'
});

export default {

    getToken(user) {
        return http.post('/token', user);
    }

}