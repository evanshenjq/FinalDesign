<template>
    <div class="row">
        <app-header/>
        <login-header/>
        <user-order-content/>
        <app-footer/>
    </div>
</template>

<script>
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'
import AppFooter from '@/common/AppFooter'
import UserOrderContent from '@/components/UserOrderContent'

export default {
    components:{
        AppHeader,
        LoginHeader,
        AppFooter,
        UserOrderContent
    }
}
</script>

<style>

</style>
