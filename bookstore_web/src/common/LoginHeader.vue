<template>
  <div class="row">
      <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="col-md-1 col-md-offset-8">
            <button class="btn btn-link" id="login_btn_index" @click='turnLoginPage()'>您好，{{loginUserName}}</button>
            </div>
            <div class="col-md-1">
            <button class="btn btn-link" id="register_btn_index" @click="turnRegisterPage()">{{registerAndLogout}}</button>
            </div>
            <div class="col-md-1">
            <button class="btn btn-link" id="cart_btn">
                <span class="glyphicon glyphicon-shopping-cart" @click="turnCartPage()">购物车</span>
            </button>
            </div>
        </div>
    </nav>
  </div>
</template>

<script>
export default {
  name:"LoginHeader",
  data(){
    return{
        loginUserName:"登陆账户",
        registerAndLogout:"免费注册"

    };
  },
  mounted(){
      this.judgeLogin();
  },
  methods:{
    turnLoginPage(){
        let userId=sessionStorage.getItem('userId');
        if(userId!=null){
            this.$router.push('/userCenter/'+userId);
        }else{
            this.$router.push('/login');
        }
    },
    turnRegisterPage(){
        let userId=sessionStorage.getItem('userId');
        if(userId!=null){
            sessionStorage.removeItem('userId');
            sessionStorage.removeItem('userName');
            this.$router.push('/');
            location.reload();
        }else{
            this.$router.push('/register');
        }
    },
    turnCartPage(){
        let userId=sessionStorage.getItem('userId');
        if(userId!=null){
            //跳转到购物车
            
        }else{
            this.$router.push('/login');
        }
    },
    judgeLogin(){
        let userId=sessionStorage.getItem('userId');
        let userName=sessionStorage.getItem('userName');
        if(userId!=null){
            this.loginUserName=userName;
            this.registerAndLogout="注销";
        }
    }
    
  }
}
</script>


<style>
#login_btn_index{
    margin-top: 5px;
    font-size: 15px;
    font-weight:bolder;
}
#register_btn_index{
    margin-top: 5px;
    margin-left: 20px;
    font-size: 15px;
}
#cart_btn{
    margin-top: 5px;
    font-size: 15px;
}
</style>
