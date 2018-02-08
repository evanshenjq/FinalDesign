<template>
  <div id="login_page">
      <logo-header/>
    <div class="row">
      <div class="col-md-3" id="login_form">
          <form class="form-horizontal">
            <div class="form-group">
                <h1>登录</h1>
            </div>
            <div class="form-group">
                <label for="inputEmail3" class="username_label">用户名:</label>
                <div>
                <input type="email" class="form-control" id="inputUsername" >
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="password_label">密码:</label>
                <div>
                <input type="password" class="form-control" id="inputPassword">
                </div>
            </div>
            <div class="form-group">
                <div>
                <button type="button" class="btn btn-default" id="login_btn">登陆</button>
                </div>
            </div>
        </form>
        <div class="beauty_line">  
            <span style="white-space:pre;">  </span><span class="line"></span>  
            <span style="white-space:pre;">  </span><span class="txt">EShop的新用户？</span>  
            <span style="white-space:pre;">  </span><span class="line"></span>  
        </div>  
            <div class="form-group">
                <div>
                <button type="button" class="btn btn-default" id="turn_register_btn" @click='turnToRegisterPage()'>注册</button>
                </div>
            </div>
         
      </div>
    </div>

    <div id="author">@ztsu.sjq.final.design</div>
  </div>
</template>


<script>
import LogoHeader from '@/common/LogoHeader'
export default {
    components:{
        LogoHeader
    },
    methods:{
        turnToRegisterPage(){
            this.$router.push("/register");
        }
    }
}
</script>


<style>
#login_form{
    border-style: solid;
    border-color: #ddd;
    border-width: 0.8px;
    float:none;
    display: block;
    margin-right: auto;
    margin-left: auto;
}
.form-horizontal{
    padding-left: 30px;
    padding-right: 30px;
    padding-bottom: 10px;
    padding-top: 10px;
}
#login_btn{
    margin-top: 15px;
    background-color: #f0c14b;
    width:345px;
}
.beauty_line {  
   height: 60px;  
   line-height: 60px;  
   text-align: center;  
}  
 .beauty_line .line {  
   display: inline-block;  
   width: 120px;  
   border-top: 1px solid #ccc ;  
}  
.beauty_line .txt {  
   color: #686868;  
   vertical-align: middle;  
}  
#turn_register_btn{
    margin-left:15px;
    background-color: #edeef1;
    width:345px;
    margin-bottom: 20px;
}
#author{
    margin-top: 120px;
    text-align: center;
}
</style>


