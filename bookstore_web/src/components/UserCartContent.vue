<template>
  <div class="row" >
      <div class="col-md-offset-1" id="cart_title">
        <h2>购物车</h2>
      
        <div class="row" id="sc_list_title">        
                <div class="col-md-1 col-md-offset-7">单价</div>
                <div class="col-md-1 col-md-offset-2">数量</div>
        </div>

        <div class="row" id="sc_list_body">
            <div class="row sc_list_item" v-for="(item,index) in items">
                <div class="col-md-2">
                    <a>
                        <img class="sc_list_item_img" :src="item.image">
                    </a>
                </div>
                <div class="col-md-5">
                    <div class="sc_list_item_book">
                        <a class="sc_list_item_book_name">{{item.name}}</a>
                        <div class="sc_list_item_book_publish">{{item.publish}}</div>
                        <div class="sc_list_item_book_stock">库存:{{getBookNum(item.bookNum)}}</div>
                        <a class="sc_list_item_book_del" @click="deleteCartItem(item.id,item.name)">删除</a>
                    </div>
                </div>
                <div class="col-md-1 sc_list_item_book_price">
                    ￥{{item.price}}
                </div>
                <div class="col-md-offset-2 col-md-1 sc_list_item_book_num">
                    <div class="input-group input-group-sm">
                        <input type="text" class="form-control" v-model="item.num">
                    </div>
                    <button class="btn btn-warning btn-xs sc_book_update_btn" @click="updateBookNum(item.id,item.num)">更新</button>
                </div>
            </div>
        </div>

        <div class="row" id="sc_list_foot">
            <div class="col-md-offset-8">
            <span class="sc_list_foot_text">合计 ( {{totalNum}}件商品):</span> 
            <span class="sc_list_foot_total">￥ {{getTotalPrice(totalPrice)}}</span>
            </div>
            <div class="col-md-offset-8">
                <button id="cartSubmitBtn" type="submit" class="btn btn-warning" @click="turnOrderAdderssPage()">结算</button>
            </div>
        </div>
      </div>
  </div>
</template>

<script>
var self;
var cartNum;
export default {
    data(){
        return{
            cartId:'',
            items:'',
            totalNum:0,
            totalPrice:0
        }
    },
    mounted(){
        self=this;
        this.getUserCart();
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
                    self.items=result.extend.cartItems;
                    for(let item of self.items){
                        self.totalNum=self.totalNum+item.num;
                        self.totalPrice=self.totalPrice+item.num*item.price;
                    }
                }
            });
        },
        getCartNum(num){
            cartNum=cartNum+num;
            return cartNum;
        },
        getTotalPrice(price){
            return price.toFixed(2);
        },
        getBookNum(num){
            if(num<0){
                return "库存不足";
            }else{
                return num;
            }
        },
        updateBookNum(itemId,num){
            if(num<=0){
                alert("请输入正确的数目！！");
            }
            else{
                if(confirm("确认要更新数量吗？")){
                    let formData=new FormData();
                    formData.append("cartItemId",itemId);
                    formData.append("num",num);
                    $.ajax({
                        url:"/zstu/updateUserCartItem",
                        data:formData,
                        type:"POST",
                        contentType: false,  
                        processData: false,
                        success:function(result){
                            alert("更新成功");
                            location.reload();
                        }
                    });
                }
            }
        },
        deleteCartItem(id,name){
            if(confirm("确认要删除"+name+"吗？")){
                let formData=new FormData();
                $.ajax({
                    url:"/zstu/deleteUserCartItem/"+id,
                    type:"POST",
                    success:function(result){
                        alert("删除成功");
                        location.reload();
                    }
                })
            }
        },
        turnOrderAdderssPage(){
            this.$router.push('/userOrderAddress/'+sessionStorage.getItem('userId'));
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
.sc_list_item_book_del{
    color: #4a6bc0;
}
#cartSubmitBtn{
    margin-top: 10px;
    width:120px;
}
</style>
