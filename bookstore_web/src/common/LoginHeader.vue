<template>
  <div class="row">
      <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="col-md-1 col-md-offset-8">
            <button class="btn btn-link" id="login_btn">您好，登陆账户</button>
            </div>
            <div class="col-md-1">
            <button class="btn btn-link" id="register_btn">免费注册</button>
            </div>
            <div class="col-md-1">
            <button class="btn btn-link" id="cart_btn">
                <span class="glyphicon glyphicon-shopping-cart">购物车</span>
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

    };
  },
  methods:{
    
  }
}
</script>


<style>
#login_btn{
    margin-top: 5px;
    font-size: 15px;
    font-weight:bolder;
}
#register_btn{
    margin-top: 5px;
    margin-left: 20px;
    font-size: 15px;
}
#cart_btn{
    margin-top: 5px;
    font-size: 15px;
}
</style>
