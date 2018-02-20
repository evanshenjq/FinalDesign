import Vue from 'vue'
import Router from 'vue-router'
import Index from '@/page/Index'
import Login from '@/page/Login'
import Register from '@/page/Register'
import BooksInfo from '@/page/BooksInfo'
import BookInfo from '@/page/BookInfo'
import UserCenter from '@/page/UserCenter'
import UserInfo from '@/page/UserInfo'
import UserOrder from '@/page/UserOrder'
import UpdatePassword from '@/page/UpdatePassword'
import BookPage from '@/page/adminPage/bookPage/BookPage'
import OrderPage from '@/page/adminPage/OrderPage'
import IndexPage from '@/page/adminPage/IndexPage'
import UserPage from '@/page/adminPage/UserPage'
import CatPage from '@/page/adminPage/catPage/CatPage'
import AddBookPage from '@/page/adminPage/bookPage/AddBookPage'
import UpdateBookPage from '@/page/adminPage/bookPage/UpdateBookPage'

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
      path:'/booksInfo/:catId',
      name:'BooksInfo',
      component:BooksInfo
    },
    {
       path:'/bookInfo/:bookId',
       name:'BookInfo',
       component:BookInfo
     },
     {
      path:'/userCenter/:userId',
      name:'UserCenter',
      component:UserCenter
     },
     {
      path:'/userOrder/:userId',
      name:'UserOrder',
      component:UserOrder
     },
     {
      path:'/userInfo/:userId',
      name:'UserInfo',
      component:UserInfo
     },
     {
      path:'/updatePassword/:userId',
      name:'UpdatePassword',
      component:UpdatePassword
     },
     {
      path:'/bookPage',
      name:'BookPage',
      component:BookPage
     },
     {
       path:'/orderPage',
       name:'OrderPage',
       component:OrderPage
     },
     {
      path:'/userPage',
      name:'UserPage',
      component:UserPage
    },
    {
      path:'/indexPage',
      name:'IndexPage',
      component:IndexPage
    },
    {
      path:'/addBookPage',
      name:'AddBookPage',
      component:AddBookPage
    },
    {
      path:'/updateBookPage/:bookId',
      name:'UpdateBookPage',
      component:UpdateBookPage
    },
    {
      path:'/catPage',
      name:'CatPage',
      component:CatPage
    },

  ]
})
