import axios from 'axios';

const nathan = axios.create({
  baseURL: "http://localhost:3000"
});

export default {

  getBoards() {
    return nathan.get('/boards');
  },

  getCards(boardID) {
    return nathan.get(`/boards/${boardID}`);
  },

  getCard(cardID) {
    return nathan.get('/cards/' + cardID);
  }

}
