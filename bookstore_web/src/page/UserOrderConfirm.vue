<template>
    <div class="row">
        <app-header/>
        <login-header/>
        <user-order-confirm-content/>
        <app-footer/>
    </div>
</template>

<script>
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'
import AppFooter from '@/common/AppFooter'
import UserOrderConfirmContent from '@/components/UserOrderConfirmContent'

export default {
    components:{
        AppHeader,
        LoginHeader,
        AppFooter,
        UserOrderConfirmContent
    }
}
</script>

<style>

</style>