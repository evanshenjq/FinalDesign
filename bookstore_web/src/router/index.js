import Vue from 'vue'
import Router from 'vue-router'
import AppHeader from '@/common/AppHeader'
import Index from '@/components/Index'
import Login from '@/components/Login'
import Register from '@/components/Register'
import BookInfo from '@/components/BookInfo'

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
      path:'/bookInfo',
      name:'BookInfo',
      component:BookInfo
    },

  ]
})
