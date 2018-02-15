<template>
<div class="col-md-2">
    <div id="adminPageFunctionNav">
        <div class="funtion_table">
            <table class="table table-hover">
            <thead class="adminNav_title">管理员功能</thead>
            <div class="margin"/>
            <tbody>
                <tr  @click="turnBookPage()">
                    <td class="adminNav_function"><span class="glyphicon glyphicon-book"></span>书籍功能</td>
                </tr>
                <div class="margin"/>
                <tr @click="turnUserPage()">
                    <td class="adminNav_function"><span class="glyphicon glyphicon-user" ></span>用户功能</td>
                </tr>
                <div class="margin"/>
                <tr @click="turnOrderPage()">
                    <td class="adminNav_function"><span class="glyphicon glyphicon-list-alt" ></span>订单功能</td>
                </tr>
                <div class="margin"/>
                <tr  @click="turnIndexRecPage()">
                    <td class="adminNav_function"><span class="glyphicon glyphicon-bullhorn"></span>首页推荐</td>
                </tr>
            </tbody>
            </table> 
        </div>
    </div>
</div>
</template>

<script>
export default {
    methods:{
        turnBookPage(){
            this.$router.push('/bookPage');
        },
        turnUserPage(){
            this.$router.push('/userPage');
        },
        turnOrderPage(){
            this.$router.push('/orderPage');
        },
        turnIndexRecPage(){
            this.$router.push('/indexRecPage');
        }
    }
  
}
</script>

<style>
#adminPageFunctionNav{
    background-color: #fafafa;
    height:600px;
    width:230px;
}
.adminNav_title{
    margin-top:5px;
    font-size: 18px;
    font-weight: 600;
}
.funtion_table{
    margin-top: 20px;
}
.margin{
    margin-top:10px;
}
.adminNav_function{
    cursor: pointer;
    font-weight: 600;
}
</style>

