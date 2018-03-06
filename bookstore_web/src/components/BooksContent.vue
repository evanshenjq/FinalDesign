<template>

  <div class="col-md-10">
      <div id="filter">
          <nav class="navbar navbar-default row" id="filter_nav">
              <div class="col-md-2">
                  <div class="filter">当前{{nowPage}}页,总{{totalPage}}页,总共{{total}}条记录</div>
              </div>
              <div class="col-md-2 col-md-offset-1">
                  <div class="filter">图书:{{cat.name}}</div>
              </div>
              <div id="search_sort" class="col-md-offset-9">
                             <ul class="nav navbar-nav">
                                <!-- 下拉过滤器 -->
                                 <li class="dropdown">
                                    <a href=" " class="dropdown-toggle search_con" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false" id="filter_choose">评分 <span class="caret"></span></a >
                                         <ul class="dropdown-menu"> 
                                             <li><a href="#" @click="search_sort($event)">评分</a></li>
                                             <li><a href="#" @click="search_sort($event)">销量</a></li>                             
                                         </ul>
                                </li>
                </ul>
            </div>
            </nav>
      </div>

      <div id="books_content_div">
          <ul id="books_content">

              <li class="books_content" v-for="book in books">
                  <div class="row">
                      <div class="col-md-3">
                        <a>
                            <img class="book_image_books" :src="book.image" @click="turnToBookPage(book.id)">
                        </a>    
                      </div>
                      <div class="col-md-7">
                          <div class="book_basic_info">
                            <div class="book_name">
                                <a class="blue_href" @click="turnToBookPage(book.id)">{{book.name}}</a>
                            </div>
                            <div class="book_publish">
                                <div>{{book.publish}}</div>
                            </div>
                             <div class="book_publish">
                                <div>销量:{{book.sell}}本</div>
                            </div>
                          </div>
                          <div class="books_info">
                              <div class="book_price">
                                <span class="money">￥</span>
                                <span class="book_price_num">{{book.price}}</span>
                              </div>
                              <div class="book_score">
                                <span class="book_score_num">{{showScoreStars(book.score)}}</span>
                              </div>
                          </div>
                          <div class="book_function">
                            <div>
                                <button class="btn btn-default btn-sm book_function_show" @click="turnToBookPage(book.id)">查看详情</button>
                                <button class="btn btn-default btn-sm book_function_add">加入购物车</button>
                            </div>
                          </div>
                      </div>
                  </div>
              </li>
          </ul>
      </div>
    <div class="col-md-offset-4" id="page_nav">
        <nav aria-label="Page navigation">
            <ul class="pagination">
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
            </nav>
    </div>
  </div>
</template>


<script>
var self;
export default {
    data(){
        return{
            books:'',
            nowPage:'',
            totalPage:'',
            total:'',
            pageNums:[],
            cat:''
        }
    },
    mounted(){
        self=this;
        this.getCatName();
        this.toPage(1);
    },
    methods:{
        toPage(pn){
            let catId=this.$route.params.catId;
            console.log(catId);
            $.ajax({
				url:"/zstu/getOnBooksByCat/"+catId,
				data:{'pn':pn},
				type:"POST",
				success:function(result){
                    //console.log(result);
                    self.books=result.extend.books.list;
                    //2.解析显示分页信息
                    self.nowPage=result.extend.books.pageNum;
                    self.totalPage=result.extend.books.pages;
                    self.total=result.extend.books.total;
                    //3.解释显示分页条
                    self.buildPageNav(result);
				}
            });
       },
       buildPageNav(result){
           this.resetPage();
           self.pageNums=result.extend.books.navigatepageNums;
           if(!result.extend.books.hasPreviousPage){
               $('#firstPageLi').addClass('disabled');
               $('#prePageLi').addClass('disabled');
           }else{
               $('#firstPageLi').click(function(){
                   self.toPage(1)
               });
               $('#prePageLi').click(function(){
                   self.toPage(result.extend.books.pageNum-1);
               })
           }
            if(!result.extend.books.hasNextPage){
               $('#lastPageLi').addClass('disabled');
               $('#nextPageLi').addClass('disabled');
           }else{
               $('#lastPageLi').click(function(){
                   self.toPage(result.extend.books.pages);
               });
               $('#nextPageLi').click(function(){
                   self.toPage(result.extend.books.pageNum+1);
               })
           }
        },
        resetPage(){
            $('#firstPageLi').removeClass('disabled');
            $('#prePageLi').removeClass('disabled');
            $('#lastPageLi').removeClass('disabled');
            $('#nextPageLi').removeClass('disabled');
        },
        turnToBookPage(id){
            this.$router.push("/bookInfo/"+id);
        },
        getCatName(){
            let catId=this.$route.params.catId;
            $.ajax({
                url:"/zstu/getBookCat/"+catId,
                type:"POST",
                success:function(result){
                    self.cat=result.extend.cat;
                }
            })
        },
        showScoreStars(score){
            if(score<1){
                return "☆"+score;
            }
            else if(socre=1){
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
        }
    }
  
}
</script>

<style>
.filter{
    font-size: 14px;
    font-weight: 600;
    margin-top: 16px;
}
#filter_nav{
    background-color: white;
    
}
#filter_choose{
    font-size: 14px;
}
.books_content{
    border-bottom-style:solid;
    border-bottom-width: 1px;
    border-bottom-color: #dddddd;
    width:100%;
    margin-top:25px;
    margin-bottom:10px;
}
.book_image_books{
    height: 210px;
    width: 175px;
}
.blue_href{
    color: #0066c0;
}
.books_info{
    border-top-style:solid;
    border-top-width: 1px;
    border-top-color: #dddddd;
    width:80%;
}
.book_name{
    font-size: 18px;
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
#page_nav{
    margin-top: 18px;
    font-size: 16px;
}
</style>

