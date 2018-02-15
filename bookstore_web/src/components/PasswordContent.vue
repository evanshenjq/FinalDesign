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
            <a class="guideHeader" href="/userInfo">
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
        <div class="userInfo_box col-md-offset-4 col-md-4"> 
            <div class="password_controduction">请填写下列表格修改密码</div>
            <form>
                <div class="form-group">
                    <label>当前密码:</label>
                    <input type="email" class="form-control" id="exampleInputEmail1" >
                </div>
                <div class="form-group">
                    <label>新密码:</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" >
                </div>
                <div class="form-group">
                    <label>请再次输入新密码:</label>
                    <input type="password" class="form-control" id="exampleInputPassword1" >
                </div>
                <button type="button" class="btn btn-default password_btn">保存修改</button>
            </form>
        </div>
    </div>
    </div>
</div>
</template>

<script>
export default {
  
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
    max-width: 80%;    
    height:390px;
}
.form-control{
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
</style>
