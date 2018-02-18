<template>
<div>
    <admin-page-header/>
  <div class="row" id="BookPage">
      <admin-page-nav/>
      <admin-cat-page/>
  </div>
</div>
</template>

<script>
import AdminPageHeader from '@/common/AdminPageHeader'
import AdminPageNav from '@/common/AdminPageNav'
import AdminCatPage from '@/components/adminPage/AdminCatPage'

export default {
    components:{
        AdminPageHeader,
        AdminPageNav,
        AdminCatPage
    }
  
}
</script>

<style>

</style>
