<template>
    <div class="row">
        <div class="col-md-offset-1" id="order_confirm_page">
            <h2>确认订单</h2>

            <div class="row" id="order_address_box">
                <div id="order_address_title">送货地址      
                    <a @click="turnOrderAddressPage()">更改</a>
                </div>
                <div class="order_address_info">{{name}} {{phone}}</div>
                <div class="order_address_info">{{address}}</div>
                <div id="order_address_foot"></div>
            </div>

            <div class="row" id="order_books_box">
                <div class="row" id="order_books_info" v-for="(item,index) in items">
                    <div class="order_book_info">
                        <div class="col-md-2">
                            <img class="order_book_img" :src="item.image">
                        </div>
                        <div class="col-md-7">
                            <div class="order_book_name">{{item.name}}</div>
                            <div class="order_book_publish">{{item.publish}}</div>
                            <div class="order_book_price">￥{{item.price}}</div>
                            <div class="order_book_num">
                                数量:{{item.num}}件
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row" id="order_total_box">
                <div id="order_total_box_price">
                    <span class="order_total_name">小计（{{totalNum}}件商品）
                        <span class="order_total_price">
                            ￥ {{getTotalPrice(totalPrice)}}
                        </span>
                    </span>
                </div>
                <div>
                    <button class="btn btn-warning" id="order_submit_btn" @click="submitOrder()">提交订单</button>
                </div>
            </div>

        </div>
    </div>
</template>

<script>
var self;
var userId;
export default {
    data(){
        return{
            name:'',
            phone:'',
            address:'',
            totalNum:0,
            totalPrice:0,
            cartId:'',
            items:''
        }
    },
    mounted(){
        self=this;
        userId=sessionStorage.getItem("userId");
        this.name=this.$route.params.name;
        this.phone=this.$route.params.phone;
        this.address=this.$route.params.address;
        this.getUserCart();
    },
    methods:{
        getUserCart(){
            let userId=sessionStorage.getItem('userId');
            $.ajax({
                url:"/zstu/getCart/"+userId,
                type:"POST",
                success:function(result){
                    self.cartId=result.extend.cart.id;
                    self.getItemsByCartId(self.cartId);
                }
            });
        },
        getItemsByCartId(cartId){
            $.ajax({
                url:"/zstu/getUserCartItem/"+cartId,
                type:"POST",
                success:function(result){
                    self.items=result.extend.cartItems;
                    for(let item of self.items){
                        self.totalNum=self.totalNum+item.num;
                        self.totalPrice=self.totalPrice+item.num*item.price;
                    }
                }
            });
        },
        getTotalPrice(price){
            return price.toFixed(2);
        },
        turnOrderAddressPage(){
            this.$router.push({
                    name:'userOrderAddress',
                    params:{
                        name:this.name,
                        phone:this.phone,
                        address:this.address
                }
            });
        },
        submitOrder(){
            if(confirm("确认提交并支付订单吗?")){
                let formData=new FormData();
                formData.append("userId",sessionStorage.getItem("userId"));
                formData.append("orderName",this.name);
                formData.append("orderPhone",this.phone);
                formData.append("orderAddress",this.address);
                formData.append("total",this.getTotalPrice(this.totalPrice));
                $.ajax({
                    url:"/zstu/addOrder",
                    data:formData,
                    type:"POST",
                    contentType: false,  
                    processData: false,
                    success:function(result){
                        //pay function
                        //....
                        alert("订单提交成功！谢谢惠顾！");
                    }
                });
            }
        }
    }
}
</script>


<style>
#order_address_box{
    margin-top: 20px;
    border-style:solid;
    border-width: 1px;
    border-color: #dddddd;
    width:40%;
    max-height: 999px;
}
#order_address_title{
    font-size: 14px;
    line-height: 19px;
    color: #333;
    font-weight: 600;
    margin-left: 12px;
    margin-top: 15px;
}
#order_submit_btn{
    margin-top:10px;
    width:70%;
    margin-left: 13px;
    margin-bottom: 15px;
}
#order_address_foot{
    margin-bottom: 14px;
}
.order_address_info{
    margin-left: 13px;
    margin-top:5px;
    font-size:13px;
}
#order_books_box{
    margin-top: 30px;
    border-style:solid;
    border-width: 1px;
    border-color: #dddddd;
    width:55%;
    max-height: 999px;
}
#order_books_info{
    margin-top: 20px;
    margin-bottom: 14px;
}
.order_book_info{
    margin-left: 20px;
    margin-bottom: 10px;
}
.order_book_img{
    width:90px;
    height:110px;
}
.order_book_num_input{
    width: 60px;
    height: 23px;
}
.order_book_name{
    font-size: 18px;
    font-weight: 600;
    margin-bottom: 3px;
}
.order_book_publish{
    margin-bottom: 3px;
    font-size: 14px;
    font-weight: 510;
}
.order_book_price{
    color: #b12704;
    font-size: 16px;
    margin-bottom: 3px;
}
.order_book_num{
    margin-bottom: 3px;
    font-size: 14px;
    font-weight: 510;
}
a{
    cursor: pointer;
}
#order_total_box{
    margin-top: 30px;
    border-style:solid;
    border-width: 1px;
    border-color: #dddddd;
    width:20%;
    max-height: 200px;
}
.order_total_name{
    margin-top: 100px;
    margin-left:13px;
    font-weight: 700;
    font-size: 17px;
}
.order_total_price{
    color: #B12704;
}
#order_total_box_price{
    margin-top: 15px;
}

</style>
