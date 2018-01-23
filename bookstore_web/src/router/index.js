import Vue from 'vue'
import Router from 'vue-router'
import AppHeader from '@/common/AppHeader'

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
      path: '/AppHeader',
      name: 'AppHeader',
      component: AppHeader
    }
  ]
})
