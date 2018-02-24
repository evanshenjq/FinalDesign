<template>
  <div class="row">
    <app-header/>
    <login-header/>
    <user-cart-content/>
    <app-footer/>
  </div>
</template>


<script>
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'
import UserCartContent from '@/components/UserCartContent'
import AppFooter from '@/common/AppFooter'

export default {
    components:{
        AppHeader,
        LoginHeader,
        AppFooter,
        UserCartContent
    }
}
</script>

<style>

</style>
