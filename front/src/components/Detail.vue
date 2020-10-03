<template>
  <div v-if="article">
    <h1>{{ this.article.title }}</h1>
    <div>
      <v-chip
        class="my-2 mr-2"
        color="primary"
        outlined
        small
        @click="onCategory(article.category)"
      >
        <v-icon small left>mdi-book-outline</v-icon>
        {{ this.article.category }}
      </v-chip>
    </div>
    <div>
      <v-chip
        v-for="tag in this.article.tags" :key="tag"
        class="my-2 mr-2"
        color="success"
        outlined
        label
        small
        @click="onTag(tag)"
      >
        <v-icon small left>mdi-label</v-icon>
        {{ tag }}
      </v-chip>
    </div>
    <p class="update-date"><v-icon left >mdi-clock-outline</v-icon>{{ getDisplayDate(this.article.updatedDate)}}</p>
    <v-divider></v-divider>
    <mavon-editor
      v-if="article.content"
      language="ja"
      v-model="article.content"
      :subfield="false"
      :editable="false"
      :toolbarsFlag="false"
      :boxShadow="false"
      defaultOpen="preview"
      previewBackground="#fff"
    ></mavon-editor>
  </div>
</template>
<script>

  import axios from 'axios';
  import dateUtils from '../dateUtils';
  export default {
    props: {
      id: Number
    },
    mixins:[dateUtils],
    data(){
      return{
        article:null,
      }
    },
    mounted(){
      this.getArticle(this.id);
    },
    methods:{
      getArticle(num){
        axios.get('/article/'+num)
        .then((response) => {
          this.article=response.data
          this.$emit('changeBreadcrumbs',[
          { icon: 'mdi-home', text: 'Home', disabled: false, to: {name:'home'}, exact: true, },
          { text: this.article.category, disabled: false, to: {name:'articleList', params:{ filterName:this.article.category, filterType:1}}, exact: true, },
          { text: this.article.title, disabled: true, exact: true, },
          ])
        })
        .catch((e) => {
          console.error(e);
        })
      },
      onCategory(category){
        this.$emit('selectCategory',category);
      },
      onTag(tag){
        this.$emit('selectTag',tag);
      }
    }
  }
</script>
<style>
.update-date{
  text-align: right;
}
</style>
