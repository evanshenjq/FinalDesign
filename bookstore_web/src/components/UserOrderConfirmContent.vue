<template>
    <div class="row">
        <div class="col-md-offset-1" id="order_confirm_page">
            <h2>确认订单</h2>

            <div class="row" id="order_address_box">
                <div id="order_address_title">送货地址      
                    <a @click="turnOrderAddressPage()">更改</a>
                </div>
                <div class="order_address_info">沈佳琦 15958003138</div>
                <div class="order_address_info">浙江省杭州市江干区四季青街道钱潮路68号金基晓庐5-1-1903</div>
                <div id="order_address_foot"></div>
            </div>

            <div class="row" id="order_books_box">
                <div class="row" id="order_books_info">
                    <div class="order_book_info">
                        <div class="col-md-2">
                            <img class="order_book_img" src="@/assets/image/3.jpg">
                        </div>
                        <div class="col-md-7">
                            <div class="order_book_name">红楼梦</div>
                            <div class="order_book_publish">曹雪芹</div>
                            <div class="order_book_price">￥88.88</div>
                            <div class="order_book_num">
                                数量:20件
                                <a>更改</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row" id="order_total_box">
                <div id="order_total_box_price">
                    <span class="order_total_name">小计（26件商品）
                        <span class="order_total_price">
                            ￥ 2000.74
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
export default {
    data(){
        return{

        }
    },
    mounted(){
        this.test()
    },
    methods:{
        test(){
            console.log(this.$route.params.name);
        },
        turnOrderAddressPage(){

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
