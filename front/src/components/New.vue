<template>
    <div id="main">
        <v-row>
            <v-col cols="12" sm="6">
                <v-text-field
                    id="title" 
                    label="Title" 
                    v-model="article.title" 
                    dense
                    solo
                    prepend-inner-icon="mdi-lead-pencil"
                    clearable>
                </v-text-field>
                <v-text-field
                    id="category"
                    label="Category"
                    v-model="article.category"
                    dense
                    solo
                    prepend-inner-icon="mdi-book-outline"
                    clearable>
                </v-text-field>
                <v-combobox
                v-model="article.tags"
                label="Tags"
                multiple
                chips
                solo
                prepend-inner-icon="mdi-label"
                ></v-combobox>
                <div><label>Update Date : <p style="display:inline">{{ getDisplayDate(this.article.updatedDate)}}</p></label></div>
                <div>
                    <label>Published : 
                    <v-icon left color="success" v-if="article.published===true">mdi-check-circle-outline</v-icon>
                    <v-icon left color="warn" v-if="article.published===false">mdi-minus-circle-outline</v-icon>
                </label>
                </div>
            </v-col>
        </v-row>
        <mavon-editor class="editor" v-model="article.content" language="ja" :toolbars="toolbars"/>
        <!-- ボタン郡 -->
        <div style="margin-top:15px;text-align:end;">
            <v-btn
                color="light-blue"
                dark outlined elevation="1"
                style="margin:0px 10px;"
                @click="save()"
            >
                <v-icon left>mdi-content-save-outline</v-icon>
                Save
            </v-btn>
            <v-btn
                color="lime"
                dark outlined
                @click.stop="publishDialog = true"
                style="text-align:right;" elevation="1"
            >
            <v-icon left>mdi-publish</v-icon>
                Publish
            </v-btn>
        </div>
        <!-- 公開確認ダイアログ -->
        <div>
            <v-dialog
                v-model="publishDialog"
                max-width="290"
            >
                <v-card>
                    <v-card-title>記事を公開しますか？</v-card-title>
                    <v-card-actions>
                    <v-spacer></v-spacer>
                    <v-btn
                        color="green darken-1"
                        text
                        @click="publish()"
                    >
                        Yes
                    </v-btn>
                    <v-btn
                        color="green darken-1"
                        text
                        @click="publishDialog = false"
                    >
                        No
                    </v-btn>
                    </v-card-actions>
                </v-card>
            </v-dialog>
        </div>
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
import Vue from 'vue'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import axios from 'axios';
import dateUtils from '../dateUtils';

Vue.use(mavonEditor)
export default {
    props:{
        id : {
            type:Number,
            required:false
        }
    },
    mixins:[dateUtils],
    data() {
        return {
            article:{},
            cancelDialog: false,
            publishDialog: false,
            successSnackbar: false,
            failSnackbar: false,
            toolbars: {
                bold: true,
                italic: true,
                header: true,
                underline: true,
                strikethrough: true,
                mark: true,
                superscript: true,
                subscript: true,
                quote: true,
                ol: true,
                ul: true,
                link: true,
                imagelink: true,
                code: true,
                table: true,
                help: true,
                alignleft: true,
                aligncenter: true,
                alignright: true,
                subfield: true,
                preview: true,
                // false
                undo: false,
                redo: false,
                fullscreen: false,
                readmodel: false,
                htmlcode: false,
                trash: false,
                save: false,
                navigation: false,
            },
        }
    },
    mounted(){
        if(typeof this.id !== "undefined"){
            let self = this
            axios.get('/article/'+this.id)
            .then(response=>{
                self.article=response.data
            })
        }
    },
    methods:{
        save(){
            let self = this
            if(typeof this.article.published === "undefined"){
                this.article.published=false
            }
            let path;
            if(typeof this.article.id === "undefined"){
                path = '/article/add';
            }else{
                path = '/article/update';
            }
            axios.post(path, this.article).then(function(response){
                console.log("response : " + response.data)
                self.article = response.data;
                self.successSnackbar=true;
            }).catch(err=>{
                console.error(err);
                self.failSnackbar =true;
            })
        },
        publish(){
            this.publishDialog = false
            let self = this                
            self.article.published=true;
            let path;

            if(typeof self.article.id === "undefined"){
                path = '/article/add';
            } else {
                path = '/article/update';
            }
            axios.post(path, self.article).then(function(response){
                console.log("response : " + response.data)
                self.article = response.data;
                self.successSnackbar=true;
            }).catch(err=>{
                console.error(err);
                self.failSnackbar =true;
            })
        }
    }
}
</script>

<style>
.editor {
    z-index: 6 !important;
    width: 100%;
    height: 100%;
  }
v-btn{
    margin: 10px;
}
</style>
