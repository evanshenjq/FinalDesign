<template>
<div class="row">
<app-header/>
<login-header/>
    <div class="row">
        <book-cat-nav/>
        <books-content/>
    </div>
<app-footer/>
</div>
</template>

<script>
import BookCatNav from '@/components/BookCatNav'
import BooksContent from '@/components/BooksContent'
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'
import AppFooter from '@/common/AppFooter'

export default {
    components:{
        BookCatNav,
        BooksContent,
        AppHeader,
        LoginHeader,
        AppFooter
    }
}
</script>

