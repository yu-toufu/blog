<template>
  <div>
  <v-row dense justify="center">
    <v-col cols="12" md="12" v-if="filterName">
      <v-card class="mx-2 mb-2">
        <v-card-text class="d-inline pr-0">Category / Tag :</v-card-text>
        <v-card-text class="font-weight-black d-inline px-2">{{ this.filterName }}</v-card-text><v-card-text class="d-inline pl-0">の記事</v-card-text>
      </v-card>
    </v-col>
    <v-col v-for="article of displayArticles" :key="article.id" cols="12" md="12">
      <v-card
        class="mx-2 mb-2" 
        @click="getArticleDetail(article.id)"
        >
        <div class="d-flex flex-no-wrap justify-space-between">
          <div>
            <v-card-title class="headline mt-0 pt-1" v-text="article.title"></v-card-title>
            <v-card-subtitle v-text="getDisplayDate(article.updatedDate)" class="py-0"></v-card-subtitle>
            <v-card-text class="py-0 pl-2">
              <div>
                <v-chip
                  class="ma-1"
                  color="primary"
                  outlined
                  small
                >
                  <v-icon small left>mdi-book-outline</v-icon>
                  {{ article.category }}
                </v-chip>
              </div>
              <div>
                <v-chip
                  v-for="tag in article.tags" :key="tag"
                  class="ma-1"
                  color="success"
                  small
                  label
                  outlined
                >
                <v-icon left small>mdi-label</v-icon>
                  {{ tag }}
                </v-chip>
              </div>
            </v-card-text>
            <v-card-text v-text="article.content" class="py-0"></v-card-text>
          </div>
          <v-avatar class="ma-3" size="150" tile>
            <v-img src="https://cdn.vuetifyjs.com/images/cards/plane.jpg"></v-img>
          </v-avatar>
        </div>
      </v-card>
    </v-col>
  </v-row>
  <v-pagination
      v-model="page"
      :length="length"
      @input="change(page)"
    ></v-pagination>
  </div>
</template>

<script>
import axios from 'axios';
import dateUtils from '../dateUtils';

export default {
  name: 'SearchIp',
  props:{
    filterName:String,
    filterType:Number,
  },
  mixins:[dateUtils],
  data(){
    return {
      page:1,
      length:0,
      articles:[],
      displayArticles:[],
      maxSize:5,
    }
  },
  mounted() {
    this.getArticleList(this.filterName, this.filterType);
  },
  watch:{
    filterName: function(){
        this.getArticleList(this.filterName, this.filterType);
      },
  },
  methods:{
    getArticleList(filterName, filterType){
      let path;
      if(typeof filterName !== 'undefined'){
        if(filterType == 1){
          path = '/article/category/' + filterName;
        }
        if(filterType == 2){
          path = '/article/tag/' + filterName; 
        }
      } else {
        path = '/article/published';
      }
      axios.get(path).then((response) => {
        this.articles=response.data
        this.length = Math.ceil(this.articles.length/this.maxSize);
        this.displayArticles = this.articles.slice(this.maxSize*(this.page -1), this.maxSize*(this.page));
        var breadcrumbs = null;
        if(filterName !== undefined){
          breadcrumbs=[
            { icon: 'mdi-home', text: 'Home', disabled: false, to: {name:'home'}, exact: true, },
            { text: filterName.toString(), disabled: true }
          ]
        }else{
          breadcrumbs=[
            { text: 'Home', disabled: true, exact: true, }
          ]
        }
        this.$emit('changeBreadcrumbs',breadcrumbs)
      }).catch((e) => {
        console.log(e)
      })
    },
    getArticleDetail(id){
      this.$router.push({
        name:'detail', 
        params:{
          id: id
          }})
    },
    change(pageNumber){
      this.displayArticles = this.articles.slice(this.maxSize*(pageNumber -1), this.maxSize*(pageNumber));
    }
  }
}
</script>