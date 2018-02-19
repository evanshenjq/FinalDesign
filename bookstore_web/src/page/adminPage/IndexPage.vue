<template>
<div>
    <admin-page-header/>
  <div class="row" id="BookPage">
      <admin-page-nav/>
      <admin-index-page/>
  </div>
</div>
</template>

<script>
import AdminPageHeader from '@/common/AdminPageHeader'
import AdminPageNav from '@/common/AdminPageNav'
import AdminIndexPage from '@/components/adminPage/AdminIndexPage'

export default {
    components:{
        AdminPageHeader,
        AdminPageNav,
        AdminIndexPage
    }
  
}
</script>

<style>

</style>
