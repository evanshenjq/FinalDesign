<template>
<div>
    <app-header/>
    <login-header/>
    <user-info-content/>
    <app-footer/>
</div>
</template>

<script>
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'
import UserInfoContent from '@/components/UserInfoContent'
import AppFooter from '@/common/AppFooter'

export default {
    components:{
        AppHeader,
        LoginHeader,
        AppFooter,
        UserInfoContent
    }
}
</script>

<style>

</style>
