import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/page/Index'
import Login from '@/page/Login'
import Register from '@/page/Register'
import BooksInfo from '@/page/BooksInfo'
import BookInfo from '@/page/BookInfo'

Vue.use(Router)

export default new Router({
  mode:'history',
  routes: [
    // {
    //   path: '/',
    //   name: '',
    //   component:
    // },
    {
      path:'/',
      component:Index
    },
    {
      path:'/login',
      name:'Login',
      component:Login
    },
    {
      path:'/register',
      name:'Register',
      component:Register
    },
    {
      path:'/booksInfo',
      name:'BooksInfo',
      component:BooksInfo
    },
    {
      path:'/bookInfo',
      name:'BookInfo',
      component:BookInfo
    }

  ]
})
