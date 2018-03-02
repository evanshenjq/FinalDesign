<template>
  <div class="row">
      <div class="col-md-offset-1" id="cart_title">
        <h2>购物车</h2>
      
        <div class="row" id="sc_list_title">        
                <div class="col-md-1 col-md-offset-7">价格</div>
                <div class="col-md-1 col-md-offset-2">数量</div>
        </div>

        <div class="row" id="sc_list_body">
            <div class="row sc_list_item">
                <div class="col-md-2">
                    <a>
                        <img class="sc_list_item_img" src="@/assets/image/1.jpg">
                    </a>
                </div>
                <div class="col-md-5">
                    <div class="sc_list_item_book">
                        <a class="sc_list_item_book_name">哈哈哈哈哈</a>
                        <div class="sc_list_item_book_publish">MC阿红</div>
                        <div class="sc_list_item_book_stock">库存:300</div>
                        <a class="sc_list_item_book_del">删除</a>
                    </div>
                </div>
                <div class="col-md-1 sc_list_item_book_price">
                    ￥13.00
                </div>
                <div class="col-md-offset-2 col-md-1 sc_list_item_book_num">
                    <div class="input-group input-group-sm">
                        <input type="text" class="form-control" v-model="num">
                    </div>
                    <button class="btn btn-warning btn-xs sc_book_update_btn">更新</button>
                </div>
            </div>
        </div>

        <div class="row" id="sc_list_foot">
            <div class="col-md-offset-8">
            <span class="sc_list_foot_text">小计 (26 件商品):</span> 
            <span class="sc_list_foot_total">￥ 2,004.44</span>
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
            num:1,
            cartId:'',
        }
    },
    mounted(){
        self=this;
        this.getUserCart();
    },
    wathch:{
        num:function(val){
 
        }
    },
    methods:{
        getUserCart(){
            let userId=sessionStorage.getItem('userId');
            $.ajax({
                url:"/zstu/getCart/"+userId,
                type:"POST",
                success:function(result){
                    if(result.extend.cart==null){
                        let formData=new FormData();
                        formData.append("userId",userId);
                        $.ajax({
                            url:"/zstu/addUserCart",
                            data:formData,
                            type:"POST",
                            contentType: false,  
                            processData: false,
                            success:function(result){
                                self.cartId=result.extend.cartId;
                                self.getItemsByCartId(self.cartId);
                            }
                        });
                    }else{
                        self.cartId=result.extend.cart.id;
                        self.getItemsByCartId(self.cartId);
                    }
                }
            });
        },
        getItemsByCartId(cartId){
            $.ajax({
                url:"/zstu/getUserCartItem/"+cartId,
                type:"POST",
                success:function(result){
                    let items=result.extend.cartItems;
                    items.forEach(function(value,index,array){

                    });
                }
            });
        },
        getBookByBookId(bookId){

        }       
    }
}
</script>

<style>
#sc_list_title{
    border-bottom-style:solid;
    border-bottom-width: 1px;
    border-bottom-color: #dddddd;
    width:85%;
}
.sc_list_item{
    margin-top:10px;
    padding-bottom: 10px;
    border-bottom-style:solid;
    border-bottom-width: 1px;
    border-bottom-color: #dddddd;
    width:85%;
}
.sc_list_item_img{
    width: 100px;
    max-height: 9999px;
}
.sc_list_item_book_name{
    font-weight: 600;
    font-size: 21px;
    cursor: pointer;
}
.sc_list_item_book{
    margin-right: 100px;
}
.sc_list_item_book_publish{
    margin-top:6px;
    line-height: 1.5;
}
.sc_list_item_book_stock{
    margin-top:6px;
    line-height: 1.5;
    margin-bottom: 10px;
}
.sc_list_item_book_del{
    cursor: pointer;
}
.sc_list_item_book_price{
    font-size: 18px;
    color: #B12704;
    font-weight: 700;
}
.sc_book_update_btn{
    margin-top: 10px;
    width: 100%;
}
.sc_list_foot_text{
    font-size: 17px;
    font-weight: 700;
}
.sc_list_foot_total{
    color: #B12704;
    font-size: 17px;
    font-weight: 700;
}
</style>
