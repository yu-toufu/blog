import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue'
import VueRouter from "vue-router"
import Detail from "./components/Detail.vue"
import ArticleList from './components/ArticleList';
import New from "./components/New.vue"
import ManageArticleList from "./components/ManageArticleList.vue"
import Login from "./components/Login.vue"
import Blog from "./Blog.vue"


Vue.use(VueRouter)
Vue.use(BootstrapVue)
import 'bootstrap/dist/css/bootstrap.css' // added
import 'bootstrap-vue/dist/bootstrap-vue.css' // added

const routes = [
    {
        path:'/',
        component:Blog,
        children:[
            {
                path: '',
                name: 'home',
                component: ArticleList, 
            },
            {
                path: '/list/:filterName',
                name: 'articleList',
                component: ArticleList,
                props: route =>({
                    filterName: Object(route.params.filterName),
                    filterType: Number(route.params.filterType)
                })
            },
            {
                path: '/detail/:id',
                name:'detail',
                component: Detail,
                props: route => ({
                    id: Number(route.params.id)
                })
            },
        ],
    },
    {
        path:'/manage/',
        component:ManageArticleList,
        name:'manage',
    },
    {
        path: '/new/',
        name:'new',
        component:New
    },
    {
        path: '/edit/:id',
        name:'edit',
        component:New,
        props: route => ({
            id: Number(route.params.id)
        })
    },
    {
        path: '/login',
        name:'login',
        component:Login
    }
]

const router = new VueRouter({
    routes: routes
})

export default router