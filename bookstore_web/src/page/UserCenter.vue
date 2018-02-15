<template>
  <div class="row">
    <app-header/>
    <login-header/>
    <user-fcuntion/>
    <app-footer/>
  </div>
</template>

<script>
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'
import UserFcuntion from '@/components/UserFunction'
import AppFooter from '@/common/AppFooter'

export default {
    components:{
        AppHeader,
        LoginHeader,
        AppFooter,
        UserFcuntion
    }
}
</script>

<style>

</style>
