// @ts-nocheck

import Vue from 'vue';
import VueRouter from 'vue-router';

import Products from '@/views/Products.vue';
import Details from '@/views/Details.vue';
import Create from '@/views/Create.vue';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'home',
    component: Products
  },
  {
    path: '/products/:id',
    name: 'productDetails',
    component: Details
  },
  {
    path: '/products/:id/new-review',
    name: 'createReview',
    component: Create
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router;
