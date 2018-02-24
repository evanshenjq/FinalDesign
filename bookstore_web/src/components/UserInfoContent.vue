<template>
<div>
    <div class="row">
           <div id="guideHeader" class="col-md-offset-4">
                <span>
                    <a class="guideHeader" @click="turnToUserCenterPage()">
                        我的账户
                    </a>    
                </span>>
                <span>
                    <span class="guideSpan">
                        个人信息
                    </span>
                </span>
            </div>

            <div>
                <div class="col-md-offset-4">
                    <h3>个人信息</h3>
                </div>
            </div>

            <div>
                <div class="userInfo_box col-md-offset-4 col-md-4">
                    <div class="row">
                        <div class="col-md-9">
                            <div class="userInfo_title">
                                用户名 :
                            </div>
                            <div>
                                {{user.username}}
                            </div>
                        </div>
                    </div>
                </div>
                <div class="userInfo_box col-md-offset-4 col-md-4">
                    <div class="row">
                        <div class="col-md-9">
                            <div class="userInfo_title">
                                密码:
                            </div>
                            <div>
                                ******
                            </div>
                        </div>
                        <div class="col-md-3">
                            <button class="btn btn-default userInfo_btn" type="button" @click="turnUpdatePassWordPage()">编辑</button>
                        </div>
                    </div>
                </div>
                <div class="userInfo_big_box col-md-offset-4 col-md-4">
                    <div class="row">
                        <div class="col-md-12 userInfo_form">
                            <form>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">姓名:</label>
                                    <input type="text" class="form-control" id="input_name" v-model="name">
                                    <p v-if="showNameError">姓名不能为空</p>
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">手机号码:</label>
                                    <input type="text" class="form-control" id="input_phone" v-model="phone">
                                    <p v-if="showPhoneError">请输入正确的手机号码</p>
                                </div>
                                 <div class="form-group">
                                    <label for="exampleInputPassword1">地址:</label>
                                    <input type="text" class="form-control" id="input_address" v-model="address">
                                </div>
                                <h5>更新于{{myDateShow(user.updated)}}</h5>
                                <button type="button" class="btn btn-default userInfo_save_btn" @click="saveUpdateUserInfo()">保存</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>

    </div>
</div>
</template>

<script>
var self;
import {dateShow} from '@/assets/js/time.js'

export default {
    data(){
        return{
            user:'',
            name:'',
            phone:'',
            address:'',
            showNameError:false,
            showPhoneError:false
        };
    },
    watch:{
        phone:function(){
            let reg=/^[1][3,4,5,7,8][0-9]{9}$/;
            if(reg.test(this.phone)){
                this.showPhoneError=false;
                 $('.userInfo_big_box').css('height','335px');
            }else{
                this.showPhoneError=true;
                 $('.userInfo_big_box').css('height','355px');
            }
        },
        name:function(){
            if(this.name!=""){
                this.showNameError=false;
                 $('.userInfo_big_box').css('height','335px');
            }else{
                this.showNameError=true;
                $('.userInfo_big_box').css('height','355px');
            }
        },
    },
    mounted(){
        self=this;
        this.getUserInfoById();
    },
    methods:{
        turnUpdatePassWordPage(){
            let userId=sessionStorage.getItem('userId');
            this.$router.push('/updatePassword/'+userId);
        },
        turnToUserCenterPage(){
            let userId=sessionStorage.getItem('userId');
            this.$router.push('/userCenter/'+userId);
        },
        getUserInfoById(){
            let userId=sessionStorage.getItem('userId');
            $.ajax({
                url:"/zstu/getUserById/"+userId,
                type:"POST",
                success:function(result){
                    self.user=result.extend.user;
                    self.name=result.extend.user.name;
                    self.phone=result.extend.user.phone;
                    self.address=result.extend.user.address;
                }
            });
        },
        saveUpdateUserInfo(){
            if(!this.showNameError&&!this.showPhoneError){
                let formData=new FormData();
                let userId=sessionStorage.getItem('userId');
                formData.append('id',userId);
                formData.append('name',this.name);
                formData.append('phone',this.phone);
                formData.append('address',this.address);
                $.ajax({
                    url:"/zstu/updateUser",
                    type:"POST",
                    data:formData,
                    contentType: false,
                    processData: false,
                    success:function(result){
                        alert("更新成功！");
                        location.reload();
                    }
                });
            }
        },
        myDateShow(time){
           return dateShow(time);
        },
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
.userInfo_box{
    border-style:solid;
    border-width: 0.8px;
    border-color: #dddddd;
    max-width: 100%;    
    height:80px;
}
.userInfo_big_box{
    border-style:solid;
    border-width: 0.8px;
    border-color: #dddddd;
    max-width: 100%;    
    height:335px;
}
.userInfo_title{
    margin-top:10px;
    font-size: 15px;
    font-weight: 800;
}
.userInfo_btn{
    margin-top:20px;
}
.userInfo_form{
    margin-top: 15px;
}
.userInfo_save_btn{
    margin-top:8px;
    background-color: #f1c556;
}
p{
    color: red;
}
h5{
    margin-top: 23px;
}
</style>
