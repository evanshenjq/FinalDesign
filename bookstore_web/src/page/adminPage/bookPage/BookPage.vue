<template>
<div>
    <admin-page-header/>
  <div class="row" id="BookPage">
      <admin-page-nav/>
      <admin-book-page/>
  </div>
</div>
</template>

<script>
import AdminPageHeader from '@/common/AdminPageHeader'
import AdminPageNav from '@/common/AdminPageNav'
import AdminBookPage from '@/components/adminPage/AdminBookPage'

export default {
    components:{
        AdminPageHeader,
        AdminPageNav,
        AdminBookPage
    }
  
}
</script>

<style>

</style>
