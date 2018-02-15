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
                                沈佳琦
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
                                    <input type="email" class="form-control" id="input_name" placeholder="name">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputPassword1">手机号码:</label>
                                    <input type="password" class="form-control" id="input_phone" placeholder="phone">
                                </div>
                                 <div class="form-group">
                                    <label for="exampleInputPassword1">地址:</label>
                                    <input type="password" class="form-control" id="input_address" placeholder="address">
                                </div>
                                <button type="button" class="btn btn-default userInfo_save_btn">保存</button>
                            </form>
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
        return{

        }
    },
    methods:{
        turnUpdatePassWordPage(){
            this.$router.push('/updatePassword');
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
    height:290px;
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
</style>
