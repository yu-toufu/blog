// TOP main.js
import Vue from 'vue';
import Manage from './Manage.vue';
import router from './route.js'
import vuetify from '../../plugins/vuetify';

Vue.config.productionTip = false;

new Vue({
  router,
  vuetify,
  render: h => h(Manage),
}).$mount('#app');