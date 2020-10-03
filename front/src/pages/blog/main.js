import Vue from 'vue'
import Blog from './Blog.vue'
import router from './route.js'
import vuetify from '../../plugins/vuetify';


Vue.config.productionTip = false

new Vue({
  router,
  vuetify,
  render: h => h(Blog)
}).$mount('#app')
