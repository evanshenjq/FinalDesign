<template>
  <div class="col-md-10">
    <div>
          <table class="table table-hover order_table">
            <thead>
                <tr>
                    <th>订单号</th>
                    <th>用户id</th>
                    <th>收件人名</th>
                    <th>电话号码</th>
                    <th>收货地址</th>
                    <th>创建时间</th>
                    <th>订单状态</th>
                    <th>查看详情</th>
                    <th>状态操作</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="order in orders">
                    <td>{{order.id}}</td>
                    <td>{{order.userId}}</td>
                    <td>{{order.userName}}</td>
                    <td>{{order.userPhone}}</td>
                    <td>{{order.userAddress}}</td>
                    <td>{{myDateShow(order.created)}}</td>
                    <td>{{statusShow(order.status)}}</td>
                    <td><button class="btn btn-primary glyphicon glyphicon-star orderBtn" @click="showOrder(order.id)"></button></td>
                    <td><button class="btn btn-warning glyphicon glyphicon-hand-left orderBtn" @click="openStatusModal(order.id)"></button></td>
                </tr>
            </tbody>
        </table>
      </div>

      <!-- 分页栏 -->
	<div class="row">
	<!-- 分页文字信息 -->
		<div class="col-md-6" id="page_info">
			当前{{nowPage}}页,总{{totalPage}}页,总共{{total}}条记录
		</div>
	<!-- 分页条 -->
		<div class="col-md-6" id="page_nav">
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
    <!-- order status modal -->
    <!-- 模态框 -->
      <!-- 添加模态框 -->
      <div class="modal fade" tabindex="-1" role="dialog" id="orderStatusModal">
        <div class="modal-dialog modal-sm" role="document">
            <div class="modal-content">
            <div class="modal-body">
                <div class="form-group">
                    <label>订单状态</label>
                    <select class="form-control" v-model="orderStatus">
                        <option value=1>未付款</option>
                        <option value=2>已付款</option>
                        <option value=3>未发货</option>
                        <option value=4>已发货</option>
                        <option value=5>交易成功</option>
                        <option value=6>交易关闭</option>
                    </select>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" @click="changeOrderStatus()">保存</button>
            </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->

    <!-- show order modal -->
        <div class="modal fade" id="order_modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">订单详情</h4>
            </div>
            <div class="modal-body">
                <!-- books info -->
                <div id="order_books">
                <div class="row" id="order_show_books_info" v-for="(item,index) in orderItems">
                    <div class="order_show_book_info">
                        <div class="col-md-2">
                            <img class="order_show_book_img" :src="item.image">
                        </div>
                        <div class="col-md-7">
                            <div class="order_show_book_name">{{item.name}}</div>
                            <div class="order_show_book_publish">{{item.publish}}</div>
                            <div class="order_show_book_price">￥{{item.price}}</div>
                            <div class="order_show_book_num">
                                数量:{{item.num}}件
                            </div>
                        </div>
                    </div>
                </div>
                </div>
                <!-- order total -->
                <div id="order_total" class="col-md-offset-9">总价:¥{{order.total}}
                </div>
            </div>
            </div>
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
            pageNums:[],
            orderIdNow:'',
            orderItems:[],
            order:'',
            orderStatus:''
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
				url:"/zstu/getAllOrder",
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
       showOrder(id){
           this.orderIdNow=id;
           $.ajax({
                url:"/zstu/getUserOrderItem/"+self.orderIdNow,
			    type:"POST",
				success:function(result){
                    self.orderItems=result.extend.orderItems;
				}
           });
            $("#order_modal").modal('show');
       },
       openStatusModal(id){
           this.orderIdNow=id;
           $.ajax({
                url:"/zstu/getOrderById/"+self.orderIdNow,
			    type:"POST",
				success:function(result){
                    self.orderStatus=result.extend.order.status;
				}
           });
            $("#orderStatusModal").modal('show');
        },
        changeOrderStatus(){
            let formData=new FormData();
            formData.append("orderId",this.orderIdNow);
            formData.append("orderStatus",this.orderStatus);
            $.ajax({
                    url:"/zstu/updateOrder",
                    data:formData,
                    type:"POST",
                    contentType: false,  
                    processData: false,
                    success:function(result){
                        alert("状态修改成功");
                        location.reload();
                    }
            });
        }
    },
}
</script>

<style>
.orderBtn{
  height: 25px;
}
#order_show_books_info{
    margin-top: 20px;
    margin-bottom: 14px;
}
#order_books{
    border-bottom-style:solid;
    border-bottom-width: 1px;
    border-bottom-color: #dddddd;
}
.order_show_book_info{
    margin-left: 20px;
    margin-bottom: 10px;
}
.order_show_book_img{
    width:90px;
    height:110px;
}
.order_show_book_name{
    font-size: 18px;
    font-weight: 600;
    margin-bottom: 3px;
}
.order_show_book_publish{
    margin-bottom: 3px;
    font-size: 14px;
    font-weight: 510;
}
.order_show_book_price{
    color: #b12704;
    font-size: 16px;
    margin-bottom: 3px;
}
.order_show_book_num{
    margin-bottom: 3px;
    font-size: 14px;
    font-weight: 510;
}
#order_total{
    margin-top: 20px;
    margin-bottom: 15px;
    font-size: 16px;
    color: #b12704;
}
</style>
