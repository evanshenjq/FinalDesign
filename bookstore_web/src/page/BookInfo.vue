<template>
    <div>
        <app-header/>
        <login-header/>
        <book-content/>
        <app-footer/>
    </div>
</template>

<script>
import BookContent from '@/components/BookContent'
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'
import AppFooter from '@/common/AppFooter'

export default {
    components:{
        BookContent,
        AppHeader,
        LoginHeader,
        AppFooter
    }
}
</script>

<style>

</style>
