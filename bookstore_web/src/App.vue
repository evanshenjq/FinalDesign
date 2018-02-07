<template>
  <div id="app">
    <app-header/>
    <login-header/>
    <router-view/>
    <app-footer/>
  </div>
</template>

<script>
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'
import AppFooter from '@/common/AppFooter'

export default {
  name: 'app',
  components:{
    AppHeader,
    LoginHeader,
    AppFooter
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
