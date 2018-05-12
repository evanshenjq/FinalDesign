<template>
  <div class="row" id="adminPageHeader">
      <div class="col-md-2" id="admin_logo">
          <a href="/bookPage">
				<img id="logo_image" src="../assets/image/logo-big.png">
		</a>
      </div>
      <div class="col-md-2 col-md-offset-7">
          <div class="admin_info">
              欢迎回来,{{loginRootName}}
              <button @click="exitRoot()" class="btn btn-link" id="exit_btn">退出</button>
          </div>
          
      </div>
  </div>
</template>

<script>
export default {
    data(){
        return{
            loginRootName:''
        }
    },
    mounted(){
        this.loginRootName=sessionStorage.getItem('rootName');
    },
    methods:{
        exitRoot(){
            sessionStorage.removeItem('rootName');
            sessionStorage.removeItem('rootId');
            this.$router.push("/");
        }
    }
  
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
#exit_btn{
    color: white;
}
</style>
