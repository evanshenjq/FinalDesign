<template>
  <div id="app">
    <app-header/>
    <login-header/>
    <router-view/>
  </div>
</template>

<script>
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'

export default {
  name: 'app',
  components:{
    AppHeader,
    LoginHeader
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
