import Vue from 'vue'
import Router from 'vue-router'
import AppHeader from '@/common/AppHeader'
import Index from '@/components/Index'

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
  ]
})
