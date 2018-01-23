<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
import AppHeader from '@/common/AppHeader'

export default {
  name: 'app',
  components:{
   
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
