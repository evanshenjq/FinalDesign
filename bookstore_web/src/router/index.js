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
import UserCart from '@/page/UserCart'
import UserOrderAddress from '@/page/UserOrderAddress'
import UserOrderConfirm from '@/page/UserOrderConfirm'
import RootLogin from '@/page/RootLogin'


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
      name:'login',
      component:Login
    },
    {
      path:'/rootLogin',
      name:'rootLogin',
      component:RootLogin
    },
    {
      path:'/register',
      name:'register',
      component:Register
    },
    {
      path:'/booksInfo/:catId',
      name:'booksInfo',
      component:BooksInfo
    },
    {
       path:'/bookInfo/:bookId',
       name:'bookInfo',
       component:BookInfo
     },
     {
      path:'/userCenter/:userId',
      name:'userCenter',
      component:UserCenter
     },
     {
      path:'/userOrder/:userId',
      name:'userOrder',
      component:UserOrder
     },
     {
      path:'/userInfo/:userId',
      name:'userInfo',
      component:UserInfo
     },
     {
      path:'/updatePassword/:userId',
      name:'updatePassword',
      component:UpdatePassword
     },
     {
      path:'/bookPage',
      name:'bookPage',
      component:BookPage
     },
     {
       path:'/orderPage',
       name:'orderPage',
       component:OrderPage
     },
     {
      path:'/userPage',
      name:'userPage',
      component:UserPage
    },
    {
      path:'/indexPage',
      name:'indexPage',
      component:IndexPage
    },
    {
      path:'/addBookPage',
      name:'addBookPage',
      component:AddBookPage
    },
    {
      path:'/updateBookPage/:bookId',
      name:'updateBookPage',
      component:UpdateBookPage
    },
    {
      path:'/catPage',
      name:'catPage',
      component:CatPage
    },
    {
      path:'/userCart/:userId',
      name:'userCart',
      component:UserCart
    },
    {
      path:'/userOrderAddress/:userId',
      name:'userOrderAddress',
      component:UserOrderAddress
    },
    {
      path:'/userOrderConfirm',
      name:'userOrderConfirm',
      component:UserOrderConfirm
    }

  ]
})
