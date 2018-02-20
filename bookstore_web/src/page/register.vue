<template>
<div id="register_page" class="row">
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
                <input type="text" class="form-control" id="inputUsername" v-model="username">
                <p v-if="showUsernameError" class="error">用户名必须为字母开头，4-12位英文数字</p>
                <p id="checkName"></p>
                </div>
            </div>
            <div class="form-group">
                <label for="inputPassword3" class="password_label">密码:</label>
                <div>
                <input type="password" class="form-control" id="inputPassword" v-model="password">
                <p v-if="showPasswordError" class="error">密码为6-16位小写字母和数字组合</p>
                </div>
            </div>
             <div class="form-group">
                <label for="inputPassword3" class="phone_label">手机号码:</label>
                <div>
                <input type="text" class="form-control" id="inputPhone" v-model="phone">
                <p v-if="showPhoneError" class="error">请输入正确手机</p>
                </div>
            </div>
             <div class="form-group">
                <label for="inputPassword3" class="name_label">姓名:</label>
                <div>
                <input type="text" class="form-control" id="inputName" v-model="name">
                <p v-if="showNameError" class="error">名字不能为空</p>
                </div>
            </div>
            <div class="form-group">
              <div class="checkbox">
                <label>
                  <input type="checkbox" id="checkAgree"> 我已阅读同意网站的相关申明
                </label>
              </div>
            </div>
            <div class="form-group">
                <div>
                <button type="button" class="btn btn-default form-control" id="register_btn" @click="submitRegister()">注册</button>
                </div>
            </div>
        </form>
      </div>
      </div>
      <div id="author">@ztsu.sjq.final.design</div>
</div>
</template>

<script>
var self;
import LogoHeader from '@/common/LogoHeader'
export default {
  components:{
    LogoHeader
  },
  data(){
      return{
          username:'',
          password:'',
          phone:'',
          name:'',
          showUsernameError:true,
          showPasswordError:true,
          showPhoneError:true,
          showNameError:true,
          checkName:false,

          
      }
  },
  mounted(){
      self=this;

  },
  watch:{
        username:function(){
            //字母开头，4-12位英文数字
            let reg=/[a-zA-Z][a-zA-Z0-9]{3,11}/
            if(reg.test(this.username)){
                this.showUsernameError=false;
            }else{
                this.showUsernameError=true;
            }
        },
        showUsernameError:function(){
            if(this.showUsernameError===false){
                $.ajax({
                    url:"/zstu/checkName/"+this.username,
                    type:"POST",
                    success:function(result){
                        //console.log(result.extend.va_msg);
                        if(result.code==200){
                            $('#checkName').css('color','red');
                            $('#checkName').html(result.extend.va_msg);
                        }else{
                            $('#checkName').css('color','green');
                            $('#checkName').html(result.extend.va_msg);
                            self.checkName=true;
                        }
                    }
                });
            }else{
                $('#checkName').html('');
            }
        },
        password:function(){
            let reg=/^[a-z0-9]{6,16}$/;
            if(reg.test(this.password)){
                this.showPasswordError=false;
            }else{
                this.showPasswordError=true;
            }
        },
        phone:function(){
            let reg=/^[1][3,4,5,7,8][0-9]{9}$/;
            if(reg.test(this.phone)){
                this.showPhoneError=false;
            }else{
                this.showPhoneError=true;
            }
        },
        name:function(){
            if(this.name!=""){
                this.showNameError=false;
            }else{
                this.showNameError=true;
            }
        },
  },
  methods:{
      submitRegister(){
          if($('#checkAgree').is(':checked')){
              if(!this.showUsernameError&&!this.showPasswordError&&!this.showPhoneError&&!this.showNameError&&this.checkName){
                  let formData=new FormData();
                  formData.append('username',this.username);
                  formData.append('password',this.password);
                  formData.append('phone',this.phone);
                  formData.append('name',this.name);
                  $.ajax({
                    url:"/zstu/registerUser",
                    data:formData,
                    type:"POST",
                    contentType: false,  
                    processData: false,
                    success:function(result){
                        alert("注册成功，跳转到登陆页面！");
                        self.$router.push('/login');
                    }
                  });
              }
          }else{
              alert('请同意网站的相关申明！');
          }
      }

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
    width:100%;
    margin-left: 0;
}
#author{
    margin-top: 120px;
    text-align: center;
}
.error{
    color:red;
}
</style>



