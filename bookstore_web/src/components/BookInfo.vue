<template>
<div>
<app-header/>
<login-header/>
    <div class="row">
        <book-cat-nav/>
        <book-content/>
    </div>
<app-footer/>
</div>
</template>

<script>
import BookCatNav from '@/common/BookCatNav'
import BookContent from '@/common/BookContent'
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'
import AppFooter from '@/common/AppFooter'

export default {
    components:{
        BookCatNav,
        BookContent,
        AppHeader,
        LoginHeader,
        AppFooter
    }
}
</script>

