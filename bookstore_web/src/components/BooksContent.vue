<template>

  <div class="col-md-10">
      <div id="filter">
          <nav class="navbar navbar-default row" id="filter_nav">
              <div class="col-md-2">
                  <div class="filter">共有10000条结果</div>
              </div>
              <div class="col-md-2">
                  <div class="filter">图书:小说</div>
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

              <li class="book_content">
                  <div class="row">
                      <div class="col-md-3">
                        <a>
                            <img class="book_image" src="../assets/image/x.jpg">
                        </a>    
                      </div>
                      <div class="col-md-7">
                          <div class="book_basic_info">
                            <div class="book_name">
                                <a class="blue_href" >刺杀骑士团长(预售期间购买《刺杀骑士团长》一套，赠《挪威的森林新版》一本)</a>
                            </div>
                            <div class="book_author">
                                <div>村上春树、 林少华</div>
                            </div>
                            <div class="book_publish">
                                <div>渣渣出版社 2013</div>
                            </div>
                          </div>
                          <div class="book_info">
                              <div class="book_price">
                                <span class="money">$</span>
                                <span class="book_price_num">8.7</span>
                              </div>
                              <div class="book_score">
                                <span class="book_score_num">★★★★★</span>
                              </div>
                          </div>
                          <div class="book_function">
                            <div>
                                <button class="btn btn-default btn-sm book_function_show">查看详情</button>
                                <button class="btn btn-default btn-sm book_function_add">加入购物车</button>
                            </div>
                          </div>
                      </div>
                  </div>
              </li>
            
                <li class="book_content">
                  <div class="row">
                      <div class="col-md-3">
                        <a>
                            <img class="book_image" src="../assets/image/y.jpg">
                        </a>    
                      </div>
                      <div class="col-md-7">
                          <div class="book_basic_info">
                            <div class="book_name">
                                <a class="blue_href" >刺杀骑士团长(预售期间购买《刺杀骑士团长》一套，赠《挪威的森林新版》一本)</a>
                            </div>
                            <div class="book_author">
                                <div>村上春树、 林少华</div>
                            </div>
                            <div class="book_publish">
                                <div>渣渣出版社 2013</div>
                            </div>
                          </div>
                          <div class="book_info">
                              <div class="book_price">
                                <span class="money">$</span>
                                <span class="book_price_num">8.7</span>
                              </div>
                              <div class="book_score">
                                <span class="book_score_num">★★★★★</span>
                              </div>
                          </div>
                          <div class="book_function">
                            <div>
                                <button class="btn btn-default btn-sm book_function_show">查看详情</button>
                                <button class="btn btn-default btn-sm book_function_add">加入购物车</button>
                            </div>
                          </div>
                      </div>
                  </div>
              </li>

              <li class="book_content">
                  <div class="row">
                      <div class="col-md-3">
                        <a>
                            <img class="book_image" src="../assets/image/z.jpg">
                        </a>    
                      </div>
                      <div class="col-md-7">
                          <div class="book_basic_info">
                            <div class="book_name">
                                <a class="blue_href" >刺杀骑士团长(预售期间购买《刺杀骑士团长》一套，赠《挪威的森林新版》一本)</a>
                            </div>
                            <div class="book_author">
                                <div>村上春树、 林少华</div>
                            </div>
                            <div class="book_publish">
                                <div>渣渣出版社 2013</div>
                            </div>
                          </div>
                          <div class="book_info">
                              <div class="book_price">
                                <span class="money">$</span>
                                <span class="book_price_num">8.7</span>
                              </div>
                              <div class="book_score">
                                <span class="book_score_num">★★★★★</span>
                              </div>
                          </div>
                          <div class="book_function">
                            <div>
                                <button class="btn btn-default btn-sm book_function_show">查看详情</button>
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
                <li>
                <a href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                <a href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
                </li>
            </ul>
            </nav>
    </div>
  </div>
</template>


<script>
export default {
  
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
.book_content{
    border-bottom-style:solid;
    border-bottom-width: 1px;
    border-bottom-color: #dddddd;
    width:100%;
    margin-top:25px;
}
.book_image{
    height: 218px;
    width: 218px;
}
.blue_href{
    color: #0066c0;
}
.book_info{
    border-top-style:solid;
    border-top-width: 1px;
    border-top-color: #dddddd;
    width:300px;
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

