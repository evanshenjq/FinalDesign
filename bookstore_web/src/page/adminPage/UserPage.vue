<template>
<div>
    <admin-page-header/>
  <div class="row" id="BookPage">
      <admin-page-nav/>
      <admin-user-page/>
  </div>
</div>
</template>

<script>
import AdminPageHeader from '@/common/AdminPageHeader'
import AdminPageNav from '@/common/AdminPageNav'
import AdminUserPage from '@/components/adminPage/AdminUserPage'

export default {
    components:{
        AdminPageHeader,
        AdminPageNav,
        AdminUserPage
    }
  
}
</script>

<style>

</style>
