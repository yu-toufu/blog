<template>
  <v-app>
    <!-- Header -->
    <Header/>
    <v-content>
      <v-container fluid style="width: 100%;">
        <router-view/>
      </v-container>
    </v-content>
    <!-- Footer -->
    <Footer/>
  </v-app>
</template>
<script>
import Header from './components/Header.vue'
import Footer from './components/Footer.vue'

export default {
  name: 'App',
  components: {
    Header,
    Footer,
  },
  data: () => ({
  }),
  methods:{
  }
};
</script>
