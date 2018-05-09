<template>
<div>
    <admin-page-header/>
  <div class="row" id="BookPage">
      <admin-page-nav/>
      <admin-order-page/>
  </div>
</div>
</template>

<script>
import AdminPageHeader from '@/common/AdminPageHeader'
import AdminPageNav from '@/common/AdminPageNav'
import AdminOrderPage from '@/components/adminPage/AdminOrderPage'

export default {
    components:{
        AdminPageHeader,
        AdminPageNav,
        AdminOrderPage
    }
  
}
</script>

<style>

</style>
