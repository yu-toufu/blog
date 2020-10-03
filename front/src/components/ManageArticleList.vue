
<template>
  <div>
    <v-data-table
        :headers="headers"
        :items="articles"
        sort-by="calories"
        class="elevation-1"
    >
        <template v-slot:top>
            <v-toolbar flat color="white">
                <v-toolbar-title>Management</v-toolbar-title>
                <v-divider
                    class="mx-4"
                    inset
                    vertical
                ></v-divider>
                <v-spacer></v-spacer>
                    <v-btn
                        color="primary"
                        dark
                        class="mb-2"
                        to="new"
                    >New Item</v-btn>
            </v-toolbar>
        </template>
        <template v-slot:item.actions="{ item }">
            <v-icon
                small
                class="mr-2"
                @click="editItem(item)"
            >
                mdi-pencil
            </v-icon>
            <v-icon
                small
                @click="deleteItem(item)"
            >
                mdi-delete
            </v-icon>
        </template>
        <template v-slot:item.published="{ item }">
            <v-icon v-if="item.published===true" color="green">mdi-check-circle-outline</v-icon>
        </template>
        <template v-slot:item.tags="{ item }">
            <v-chip v-for="tag in item.tags" :key="tag"
                class="ma-2"
                color="success"
                outlined
                x-small
            >
            <v-icon x-small left>mdi-label</v-icon>
                {{ tag }}
            </v-chip>
        </template>
        <template v-slot:no-data>
            <v-btn color="primary" @click="initialize">Reset</v-btn>
        </template>
    </v-data-table>
    <div class="text-center">
            <v-snackbar
                v-model="successSnackbar"
                :timeout=2000
                absolute
                bottom
                color="success"
                left
            >
            Success!
            </v-snackbar>
            <v-snackbar
                v-model="failSnackbar"
                :timeout=2000
                absolute
                bottom
                color="error"
                left
            >
            Fail!
            </v-snackbar>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
import dateUtils from '../dateUtils';

  export default {
    mixins:[dateUtils],
    data: () => ({
      articles:[],
      successSnackbar: false,
      failSnackbar: false,
      headers: [
        { text: 'Title', align: 'start', sortable: false, value: 'title',},
        { text: 'Published', value: 'published' },
        { text: 'Category', value: 'category' },
        { text: 'Tags', value: 'tags' },
        { text: 'Update Date', value: 'updatedDate' },
        { text: 'Actions', value: 'actions', sortable: false },
      ],
    }),
    mounted () {
      this.initialize()
    },
    methods: {
      initialize () {
        axios.get('/article/all')
        .then((response) => {
          this.articles = response.data.map((article) =>({
            ...article,
            updatedDate: this.getDisplayDate(article.updatedDate),
          }))
          console.log(this.articles);
        }).catch((err) => {
          console.error(err)
        })
      },
      editItem (item) {
        this.$router.push({name:'edit', params:{id: item.id}})
      },
      deleteItem (item) {
        const isDelete = confirm('Are you sure you want to delete this item?')
        if(isDelete){
          const index = this.articles.indexOf(item)
          let self = this
          axios.post('/article/delete',{id:item.id}).then(function(response){
              console.log("response : " + response.data)
              self.articles.splice(index, 1)
              self.successSnackbar=true;
          }).catch(err=>{
              console.error(err);
              self.failSnackbar =true;
          })
        }
      },
    },
  }
</script>