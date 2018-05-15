<template>
<div>
    <div class="row">
    <div id="guideHeader" class="col-md-offset-4">
        <span>
            <a class="guideHeader" href="/userCenter">
                我的账户
            </a>    
        </span>>
         <span>
            <a class="guideHeader" @click="turnUserInfoPage()">
                个人信息
            </a>    
        </span>>
        <span>
            <span class="guideSpan">
                修改密码
            </span>
        </span>
    </div>

     <div>
        <div class="col-md-offset-4">
            <h3>修改密码</h3>
        </div>
    </div>

    <div>
        <div class="password_box col-md-offset-4 col-md-4"> 
            <div class="password_controduction">请填写下列表格修改密码</div>
            <form>
                <div class="form-group">
                    <label>当前密码:</label>
                    <input type="password" class="form-control form-control-password" v-model="oldPassword">
                    <p v-if="checkOldPassword" id="showOldPasswordError">请输入正确的密码</p>
                </div>
                <div class="form-group">
                    <label>新密码:</label>
                    <input type="password" class="form-control form-control-password" v-model="newPassword">
                    <p v-if="showNewPasswordError">密码为6-16位小写字母和数字组合</p>
                </div>
                <div class="form-group">
                    <label>请再次输入新密码:</label>
                    <input type="password" class="form-control form-control-password" v-model="newPasswordAgain">
                    <p v-if="showNewPasswordAgainError">请输入两次相同的密码</p>
                </div>
                <button type="button" class="btn btn-default password_btn" @click="submitUpdatePassword()">保存修改</button>
            </form>
        </div>
    </div>
    </div>
</div>
</template>

<script>
var self;
export default {
    data(){
        return{
            oldPassword:'',
            newPassword:'',
            newPasswordAgain:'',
            showNewPasswordError:true,
            showNewPasswordAgainError:true,
            checkOldPassword:false,
            userPassword:''
        };
    },
    watch:{
        newPassword:function(){
            let reg=/^[a-z0-9]{6,16}$/;
            if(reg.test(this.newPassword)){
                this.showNewPasswordError=false;
            }else{
                this.showNewPasswordError=true;
            }
        },
        newPasswordAgain:function(){
            if(this.newPasswordAgain!=this.newPassword){
                this.showNewPasswordAgainError=true;
            }else{
                this.showNewPasswordAgainError=false;
            }
        },
    },
    mounted(){
        self=this;
        this.getUserInfoById();
    },
    methods:{
        getUserInfoById(){
            let userId=sessionStorage.getItem('userId');
            $.ajax({
                url:"/zstu/getUserById/"+userId,
                type:"POST",
                success:function(result){
                    self.userPassword=result.extend.user.password;
                }
            });
        },
        submitUpdatePassword(){
            if(this.oldPassword!=this.userPassword){
                this.checkOldPassword=true;
            }else{
                this.checkOldPassword=false;
            }


            if(!this.showNewPasswordError&&!this.showNewPasswordAgainError&&!this.checkOldPassword){
                if(confirm("改变密码需要重新登录，确定吗？")){
                    let formData=new FormData();
                    formData.append('password',this.newPassword);
                    let userId=sessionStorage.getItem('userId');
                    formData.append('id',userId);
                    $.ajax({
                        url:"/zstu/updateUser",
                        type:"POST",
                        data:formData,
                        contentType: false,
                        processData: false,
                        success:function(result){
                            sessionStorage.removeItem('userId');
                            sessionStorage.removeItem('userName');
                            alert("更新成功,返回首页");
                            self.$router.push('/');
                        }
                    });
                }
            }
        },
        turnUserInfoPage(){
            let userId=sessionStorage.getItem("userId");
            this.$router.push('/userInfo/'+userId);
        }
    }
}
</script>

<style>
.guideHeader{
    cursor: pointer;
}
.guideSpan{
    color: #c45500;
}
.password_box{
    border-style:solid;
    border-width: 0.8px;
    border-color: #dddddd;
    max-width: 80%;    
    height:405px;
}
.form-control-password{
    width: 45%;
}
.password_btn{
    margin-top: 5px;
    background-color: #f1c556;
}
label{
    margin-top: 5px;
    margin-bottom: 10px;
}
.password_controduction{
    margin-top: 12px;
    margin-bottom: 15px;
    font-size: 15px;
    font-weight: 700;
}
p{
    color: red;
}
</style>
