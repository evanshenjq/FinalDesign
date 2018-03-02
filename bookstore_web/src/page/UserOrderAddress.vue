<template>
    <div class="row">
        <app-header/>
        <login-header/>
        <user-order-address-content/>
        <app-footer/>
    </div>
</template>

<script>
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'
import AppFooter from '@/common/AppFooter'
import UserOrderAddressContent from '@/components/UserOrderAddressContent'

export default {
    components:{
        AppHeader,
        LoginHeader,
        AppFooter,
        UserOrderAddressContent
    }
}
</script>

<style>

</style>