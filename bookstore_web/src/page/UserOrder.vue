<template>
    <div class="row">
        <app-header/>
        <login-header/>
        <app-footer/>
    </div>
</template>

<script>
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'
import AppFooter from '@/common/AppFooter'

export default {
    components:{
        AppHeader,
        LoginHeader,
        AppFooter
    }
}
</script>

<style>

</style>
