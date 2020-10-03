<template>
  <v-app>
    <!-- Header -->
    <Header 
    @resetCategoryDisable="callCategoryResetDisable"
    @resetTagDisable="callTagResetDisable"
    />
    <v-content>
      <v-container fluid style="width: 100%;">
        <breadcrubs ref="breadcrubs"/>
        <v-row no-gutters>
          <v-col cols="12" lg="8" md="12" sm="12">
            <router-view 
              @changeBreadcrumbs="callChangeBreadcrubs"
              @selectTag="callSelectTag"
              @selectCategory="callSelectCategory"
              />
          </v-col>
          <v-col cols="12" lg="4" md="12" sm="12" id="side-content">
            <profile/>
            <category ref="category" @resetTagDisable="callTagResetDisable"/>
            <tags ref="tags" @resetCategoryDisable="callCategoryResetDisable"/>
          </v-col>
        </v-row>
      </v-container>
    </v-content>
    <!-- Footer -->
    <Footer/>
  </v-app>
</template>
<script>
import Header from '../../components/Header.vue'
import Footer from '../../components/Footer.vue'
import Breadcrubs from '../../components/Breadcrubs.vue'
import Profile from '../../components/Profile.vue';
import Tags from '../../components/Tags.vue';
import Category from '../../components/Category.vue'

export default {
  name: 'Blog',
  components: {
    Header,
    Footer,
    Breadcrubs,
    Profile,
    Tags,
    Category
  },
  data: () => ({
  }),
  methods:{
    callChangeBreadcrubs(breadcrubs){
      this.$refs.breadcrubs.changeBreadcrumbs(breadcrubs);  
    },
    callTagResetDisable(){
      this.$refs.tags.resetDisable();
    },
    callCategoryResetDisable(){
      this.$refs.category.resetDisable();
    },
    callSelectTag(tagName){
      this.$refs.tags.selectTag(tagName)
    },
    callSelectCategory(categoryName){
      this.$refs.category.selectCategory(categoryName)
    }
  }
};
</script>
