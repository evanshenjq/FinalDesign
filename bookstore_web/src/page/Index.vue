<template>
<div class="row">
<app-header/>
<login-header/>
    <div class="row">
        <book-cat-nav/>
        <index-content/>
    </div>
<app-footer/>
</div>
</template>

<script>
import BookCatNav from '@/components/BookCatNav'
import IndexContent from '@/components/IndexContent'
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'
import AppFooter from '@/common/AppFooter'

export default {
    components:{
        BookCatNav,
        IndexContent,
        AppHeader,
        LoginHeader,
        AppFooter
    }
}
</script>

<style>

</style>
