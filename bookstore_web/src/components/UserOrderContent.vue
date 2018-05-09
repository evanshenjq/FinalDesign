<template>
  <div class="row">
      <div class="col-md-offset-1">
          <h2>我的订单</h2>
          <table class="table table-hover order_table">
            <thead>
                <tr>
                    <th>订单号</th>
                    <th>收件人</th>
                    <th>电话号码</th>
                    <th>收货地址</th>
                    <th>创建时间</th>
                    <th>订单状态</th>
                    <th>查看详情</th>
                    <th>确认</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="order in orders">
                    <td>{{order.id}}</td>
                    <td>{{order.userName}}</td>
                    <td>{{order.userPhone}}</td>
                    <td>{{order.userAddress}}</td>
                    <td>{{myDateShow(order.created)}}</td>
                    <td>{{statusShow(order.status)}}</td>
                    <td><button class="btn btn-primary glyphicon glyphicon-star orderBtn" @click="showOrder(order.id)"></button></td>
                    <td><button class="btn btn-warning glyphicon glyphicon-ok orderBtn" @click="confirmOrder(order.id)"></button></td>
                </tr>
            </tbody>
        </table>
      </div>

      <!-- 分页栏 -->
	<div class="row">
	<!-- 分页文字信息 -->
		<div class="col-md-6 col-md-offset-1" id="page_info">
			当前{{nowPage}}页,总{{totalPage}}页,总共{{total}}条记录
		</div>
	<!-- 分页条 -->
		<div class="col-md-5" id="page_nav">
            <ul class="pagination" >
                <li id="firstPageLi">
                <a href="#">
                    首页
                </a>
                </li>
                <li id="prePageLi">
                <a href="#">
                    &laquo;
                </a>
                </li>
                <li v-for="pageNum in pageNums">
                    <a href="#" @click="toPage(pageNum)">{{pageNum}}</a>
                </li>
                <li  id="nextPageLi">
                <a href="#" >
                    &raquo;
                </a>
                </li>
                 <li id="lastPageLi">
                <a href="#" >
                    末页
                </a>
                </li>
            </ul>
		</div>
	</div>
  </div>
</template>

<script>
import {dateShow} from '@/assets/js/time.js'

var self;
var userId;
export default {
    data(){
        return{
            orders:'',
            nowPage:'',
            totalPage:'',
            total:'',
            pageNums:[]
        };
    },
    mounted(){
        userId=sessionStorage.getItem('userId');
        self=this;
        this.toPage(1);
    },
    methods:{
        toPage(pn){
            $.ajax({
				url:"/zstu/getOrder/"+userId,
				data:{'pn':pn},
				type:"POST",
				success:function(result){
                    //console.log(result);
                    self.orders=result.extend.orders.list;
                    //2.解析显示分页信息
                    self.nowPage=result.extend.orders.pageNum;
                    self.totalPage=result.extend.orders.pages;
                    self.total=result.extend.orders.total;
                    //3.解释显示分页条
                    self.buildPageNav(result);
                    
				}
            });
       },
       buildPageNav(result){
           this.resetPage();
           self.pageNums=result.extend.orders.navigatepageNums;
           if(!result.extend.orders.hasPreviousPage){
               $('#firstPageLi').addClass('disabled');
               $('#prePageLi').addClass('disabled');
           }else{
               $('#firstPageLi').click(function(){
                   self.toPage(1)
               });
               $('#prePageLi').click(function(){
                   self.toPage(result.extend.orders.pageNum-1);
               })
           }
            if(!result.extend.orders.hasNextPage){
               $('#lastPageLi').addClass('disabled');
               $('#nextPageLi').addClass('disabled');
           }else{
               $('#lastPageLi').click(function(){
                   self.toPage(result.extend.orders.pages);
               });
               $('#nextPageLi').click(function(){
                   self.toPage(result.extend.orders.pageNum+1);
               })
           }
        },
        resetPage(){
            $('#firstPageLi').removeClass('disabled');
            $('#prePageLi').removeClass('disabled');
            $('#lastPageLi').removeClass('disabled');
            $('#nextPageLi').removeClass('disabled');
        },
        myDateShow(time){
           return dateShow(time);
        },
        statusShow(num){
           if(num==1){
               return "未付款";
           }
           else if(num==2){
               return "已付款";
           }
           else if(num==3){
               return "未发货";
           }
           else if(num==4){
               return "已发货";
           }
           else if(num==5){
               return "交易成功";
           }
           else if(num==6){
               return "交易关闭";
           }
       },
       showOrder(){
           alert("订单详情");
       },
       confirmOrder(){
           alert("确认订单");
       }
    }
  
}
</script>

<style>
.order_table{
    width: 93%;
}
.orderBtn{
    height: 27px;
}
</style>
