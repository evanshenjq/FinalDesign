<template>
<div>
    <app-header/>
    <login-header/>
    <password-content/>
    <app-footer/>
</div>
  
</template>

<script>
import AppHeader from '@/common/AppHeader'
import LoginHeader from '@/common/LoginHeader'
import PasswordContent from '@/components/PasswordContent'
import AppFooter from '@/common/AppFooter'

export default {
    components:{
        AppHeader,
        LoginHeader,
        AppFooter,
        PasswordContent
    }
}
</script>

