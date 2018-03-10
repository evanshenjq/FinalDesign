<template>
  <div>
    <!-- 导航条 -->
    <div id="guideHeader">
        <span>
            <a class="guideHeader" @click="turnIndexPage()">
                图书
            </a>    
        </span>>
        <span>
            <a class="guideHeader">
                小说
            </a>
            </span>
    </div>
    <!-- 内容 -->
    <div id="book_content">
        <div class="row">
            <div class="col-md-2 book_image_div">
                <a>
                    <img id="book_image_one"  :src="book.image">
                </a> 
            </div>
            <div class="col-md-8" id="book_info_one">
                <div class="book_basic_info">
                            <div class="book_name">
                                <div>{{book.name}}</div>
                            </div>
                            <div class="book_author">
                                <div>{{book.publish}}</div>
                            </div>
                            <div class="book_sell">
                                  <span id="book_sell_title">销量:</span>
                                  <span id="book_sell_num">{{book.sell}}</span>
                            </div>
                            <div class="book_score">
                                <span class="book_score_num">{{showScoreStars(book.score)}}</span>
                            </div>
                          </div>
                          <div class="book_info_one">
                              <div class="book_desc">
                                  <div id="book_desc_title">书籍简介:</div>
                                  <div id="book_desc">{{book.descr}}</div>
                              </div>
                              <div class="book_price">
                                <span class="money">￥</span>
                                <span class="book_price_num">{{book.price}}</span>
                              </div>
                              
                          </div>
                          <div class="book_num_choose">
                                <div class="input-group">
                                    <div class="input-group-addon">数量</div>
                                    <input type="text" value="1" class="form-control" id="book_num_input" v-model="bookNum"
                                    onkeyup="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'')}else{this.value=this.value.replace(/\D/g,'')}"  
                                    onafterpaste="if(this.value.length==1){this.value=this.value.replace(/[^1-9]/g,'0')}else{this.value=this.value.replace(/\D/g,'')}" />  
                                    <div id="book_num">(库存:{{book.num}})</div>
                                </div>
                                <p v-if="showBookNumError">数量不能为空</p>
                          </div>
                          <div class="book_function">
                            <div>
                                <button class="btn btn-default btn-sm book_function_add" @click="addBookToCart()">加入购物车</button>
                            </div>
                          </div>
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
            book:"",
            bookNum:1,
            showBookNumError:false,
        }
    },
    mounted(){
        self=this;
        this.getBookInfo();
    },
    methods:{
        turnIndexPage(){
            this.$router.push("/")
        },
        getBookInfo(){
            let bookId=this.$route.params.bookId;
            $.ajax({
                url:"/zstu/getBook/"+bookId,
                type:"POST",
                success:function(result){
                    self.book=result.extend.book;
                }
            });
        },
        showScoreStars(score){
            if(score<1){
                return "☆"+score;
            }
            else if(score=1){
                return "★"+score;
            }
            else if(score<2&&score>1){
                return "★☆"+score;
            }
            else if(score=2){
                return "★★"+score;
            }
             else if(score<3&&score>2){
                return "★★☆"+score;
            }
            else if(score=3){
                return "★★★"+score;
            }
            else if(score<4&&score>3){
                return "★★★☆"+score;
            }
            else if(score=5){
                return "★★★★"+score;
            }
            else if(score<5&&score>4){
                return "★★★★☆"+score;
            }
            else if(score=5){
                return "★★★★★"+score;
            }
        },
        addBookToCart(){
            let userId=sessionStorage.getItem('userId');
            if(userId==null){
                this.$router.push('/login');
            }else{
                if(this.bookNum==""){
                this.showBookNumError=true;
                }else{
                    this.showBookNumError=false;
                }
                if(!this.showBookNumError){
                    $.ajax({
                        url:"/zstu//getCart/"+userId,
                        type:"POST",
                        success:function(result){
                            let cartId=result.extend.cart.id;
                            let formData=new FormData();
                            formData.append("cartId",cartId);
                            formData.append("bookId",self.book.id);
                            formData.append("num",self.bookNum);
                            $.ajax({
                                url:"/zstu/addUserCartItem",
                                data:formData,
                                type:"POST",
                                contentType: false,  
                                processData: false,
                                success:function(result){
                                    alert("添加成功");
                                }
                            });
                        }
                    });
                }
            }
           
        }
    }
  
}
</script>

<style>
a{
    cursor: pointer;
}
.guideHeader{
    color: #767676;
}
#guideHeader{
    margin-left: 14px;
    margin-top: 10px;
}
.book_image_div{
    margin-left: 50px;
    margin-top:40px;
}
#book_image_one{
    width:190px;
    height: 270px;
}
.book_content{
    border-bottom-style:solid;
    border-bottom-width: 1px;
    border-bottom-color: #dddddd;
    width:700px;
    margin-top:25px;
}

.book_info_one{
    border-top-style:solid;
    border-top-width: 1px;
    border-top-color: #dddddd;
    width:100%;
}
.book_name{
    font-size: 28px;
    line-height: 1.2;
    margin-bottom: 3px;
}
.book_author{
    margin-bottom: 3px;
}
.book_publish{
    margin-bottom: 4px;
}
.book_price{
    color: #B12704;
    margin-bottom: 1px;
}
.book_sell{
    color: #b12704;
    margin-bottom: 5px;
    font-size:15px;
    margin-top:5px;
}
.money{
    font-size: 12px;
}
.book_price_num{
    font-size: 21px;
}
.book_score{
    color: #ffb700;
    margin-bottom: 8px;
}
.score{
    font-size: 12px;
}
.book_score_num{
    font-size: 21px;
}
.book_function_add{
    background-color: #f9c647;
}
#book_desc_title{
    font-size: 20px;
    color:#E47911;
    margin-bottom: 4px;
}
#book_desc{
    margin-bottom: 10px;
}
.book_price{
    margin-bottom: 10px;
}
.book_num_choose{
    margin-bottom:20px;
}
#book_num_input{
    width:10%;
}
#book_num{
    margin-top:6px;
    font-size:14px;
}
p{
    color:red;
}
</style>
