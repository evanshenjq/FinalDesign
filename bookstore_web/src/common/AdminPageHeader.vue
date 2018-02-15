<template>
  <div class="row" id="adminPageHeader">
      <div class="col-md-2" id="admin_logo">
          <a href="/bookPage">
				<img id="logo_image" src="../assets/image/logo-big.png">
		</a>
      </div>
      <div class="col-md-2 col-md-offset-8">
          <div class="admin_info">
              欢迎回来,admin!!
          </div>
      </div>
  </div>
</template>

<script>
export default {
  
}
</script>

<style>
#adminPageHeader{
    background-color: #737d92be;
}
#admin_logo{
    background-color: #5d61699d;
}
.admin_info{
    margin-top: 12px;
    font-size: 16px;
    color: white;
}
#logo_image{
    width: 190px;
	height: 54px;
	margin-left: 8px;
	margin-top: 3px;
}
</style>
