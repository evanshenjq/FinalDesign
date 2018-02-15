<template>
  <div>
      <div class="row function_title">
        <div class="col-md-offset-2 col-md-3">
            <h2>
                我的账户
            </h2>
        </div>
    </div>

    <div class="row">
        <div class="col-md-2 col-md-offset-2">
            <div class="row function_box">
                <div class="col-md-4" >
                    <img class="function_img" src="../assets/image/order.png">
                </div>
                <div class="col-md-8">
                    <div class="function_inner_title">我的订单</div>
                    <div>
                        <span class="function_inner_content">查询、追踪单信息</span>
                    </div>
                </div>
            </div>
        </div>

        <div class="col-md-2 col-md-offset-1">
           <div class="row function_box" @click="turnUserInfoPage()">
                <div class="col-md-4" >
                    <img class="function_img" src="../assets/image/info.png">
                </div>
                <div class="col-md-8">
                    <div class="function_inner_title">登陆和安全</div>
                    <div>
                        <span class="function_inner_content" >编辑用户信息</span>
                    </div>
                </div>
            </div>
        </div>
    </div>

  </div>
</template>

<script>
export default {
    data(){

    },
    methods:{
        turnUserInfoPage(){
            this.$router.push('/userInfo');
        }
    }
  }
</script>

<style>
.function_title{
    margin-bottom: 5px;
}
.function_box{
    border-style:solid;
    border-width: 0.8px;
    border-color: #dddddd;
    width:304px;
    height:70px; 
}
.function_box:hover{
    background: #eee;
    cursor: pointer;
}
.function_img{
    vertical-align: top;
    max-width: 100%;
    width: 100%;
    height:43px;
    margin-top:14px;
}
.function_inner_title{
    margin-top: 8px;
    font-size: 17px;
}
.function_inner_content{
    font-size: 13px;
    color: #555;
}
</style>
