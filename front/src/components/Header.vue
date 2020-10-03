<template>
  <v-card flat tile>
    <v-toolbar elevation="1" light>
      <v-btn
        icon 
        @click="onClick()"
        color="success"
      >
        <v-icon x-large>mdi-blogger</v-icon>
      </v-btn>
      <v-toolbar-title>メンタルと脳細胞が豆腐</v-toolbar-title>
      <v-spacer></v-spacer>
      <v-text-field
        label="Search..."
        prepend-inner-icon="mdi-magnify"
        rounded
        solo
        dense
        style="max-width: 300px;postion: relative;"
        class="search"
      ></v-text-field>
      <v-btn icon to="manage" color="success">
        <v-icon>mdi-book-open-page-variant</v-icon>
      </v-btn>
    </v-toolbar>
  </v-card>
</template>
<script>
export default {
  data: () => ({
  }),
  methods:{
    onClick(){
      console.log('on click')
      this.$router.push({path:'/'})
    },
  }
}
</script>
<style>
.search{
  position: relative;
  top: 5px;
  bottom: 0;
  left: 0;
  right: 0;
  margin: 0 auto;
  height: 50px;
  width: 50px;
}
</style>
