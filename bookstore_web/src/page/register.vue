<template>
<div id="register_page">
  <logo-header/>
  <div class="row">
      <div class="col-md-3" id="register_form">
          <form class="form-horizontal">
            <div class="form-group">
                <h1>注册</h1>
            </div>
            <div class="form-group">
                <label for="inputEmail3" class="username_label">用户名:</label>
                <div>
                <input type="text" class="form-control" id="inputUsername" >
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="password_label">密码:</label>
                <div>
                <input type="password" class="form-control" id="inputPassword">
                </div>
            </div>
             <div class="form-group">
                <label for="inputPassword3" class="phone_label">手机号码:</label>
                <div>
                <input type="text" class="form-control" id="inputPhone">
                </div>
            </div>
             <div class="form-group">
                <label for="inputPassword3" class="name_label">姓名:</label>
                <div>
                <input type="text" class="form-control" id="inputName">
                </div>
            </div>
            <div class="form-group">
              <div class="checkbox">
                <label>
                  <input type="checkbox"> 我已阅读同意网站的相关申明
                </label>
              </div>
            </div>
            <div class="form-group">
                <div>
                <button type="button" class="btn btn-default" id="register_btn">注册</button>
                </div>
            </div>
        </form>
      </div>
      </div>
</div>
</template>

<script>
import LogoHeader from '@/common/LogoHeader'
export default {
  components:{
    LogoHeader
  }
}
</script>

<style>
#register_form{
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
#register_btn{
    
    background-color: #f0c14b;
    width:345px;
}
</style>



