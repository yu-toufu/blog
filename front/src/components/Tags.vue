<template>
  <v-card
  class="ma-5"
    elevation=""
  >
    <v-card-title><v-icon large left color="success">mdi-label</v-icon>Tag</v-card-title>
    <v-chip v-for="tag in tags" :key="tag.name"
      class="ma-2"
      color="success"
      small
      outlined
      label
      @click="selectTag(tag.name)"
      :disabled="tag.disable"
    >
    <v-icon left small>mdi-label</v-icon>
      {{ tag.name }}
    </v-chip>
  </v-card>
</template>

<script>
import axios from 'axios';
export default {
  data: () => ({
    tags:[]
  }),
  mounted(){
    this.getAllTag();
  },
  methods:{
    getAllTag(){
      axios.get('/tag/all').then((response) => {
        this.tags=response.data
        })
    },
    selectTag(tagName){
      this.resetDisable()
      this.$emit('resetCategoryDisable')
      var foundIndex = this.tags.findIndex(v => v.name == tagName)
      this.tags[foundIndex].disable = true;
      this.$router.push({name:'articleList', params:{ filterName:tagName, filterType:2}})
    },
    resetDisable(){
      this.tags.map(item => item.disable=false)
    }
  }
}
</script>
<style>
</style>