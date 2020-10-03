<template>
  <v-card
  class="ma-5"
    elevation=""
  >
    <v-card-title><v-icon large left color="primary">mdi-book-outline</v-icon>Category</v-card-title>
    <v-list dense>
      <v-list-item-group v-model="item" color="primary">
        <v-list-item
          v-for="category in categories" :key="category.name"
          @click="selectCategory(category.name)"
          :disabled="category.disable"
          >
          <v-list-item-content>
            <v-list-item-title>
              {{ category.name }} ({{ category.count }})
            </v-list-item-title>
          </v-list-item-content>
        </v-list-item>
      </v-list-item-group>
    </v-list>
  </v-card>
</template>
<script>
import axios from 'axios';
  export default {
    data: () => ({
      item:1,//////??????////
      categories:[]
    }),
    mounted(){
      this.getAllCategory()
    },
    methods:{
      getAllCategory(){
        axios.get('/category/all').then((response) => {
        this.categories=response.data
        })
      },
      selectCategory(category){
        this.resetDisable()
        this.$emit('resetTagDisable')
        var foundIndex = this.categories.findIndex(v => v.name == category)
        this.categories[foundIndex].disable = true;
        this.$router.push({name:'articleList', params:{ filterName:category, filterType:1}})
      },
      resetDisable(){
        this.categories.map(item => item.disable=false)
      }
    }
  }
</script>
<style>
</style>