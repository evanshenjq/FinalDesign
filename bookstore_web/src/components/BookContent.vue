<template>
  <div>
    <!-- 导航条 -->
    <div id="guideHeader">
        <span>
            <a class="guideHeader">
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
                    <img id="book_image"  src="../assets/image/z1.jpg">
                </a> 
            </div>
            <div class="col-md-8" id="book_info">
                <div class="book_basic_info">
                            <div class="book_name">
                                <div>刺杀骑士团长(预售期间购买《刺杀骑士团长》一套，赠《挪威的森林新版》一本)</div>
                            </div>
                            <div class="book_author">
                                <div>村上春树、 林少华</div>
                            </div>
                            <div class="book_publish">
                                <div>渣渣出版社 2013</div>
                            </div>
                            <div class="book_score">
                                <span class="book_score_num">★★★★★</span>
                              </div>
                          </div>
                          <div class="book_info">
                              <div class="book_desc">
                                  <div id="book_desc_title">书籍简介:</div>
                                  <div id="book_desc">《白夜行》讲述了多年以前，大阪的一栋废弃建筑中发现一名遭利器刺死男子的故事。案件扑朔迷离，始终悬而未决。此后20年间，案件滋生出的恶逐渐萌芽生长，绽放出恶之花。案件相关者的人生逐渐被越来越重的阴影笼罩……</div>
                              </div>
                              <div class="book_price">
                                <span class="money">$</span>
                                <span class="book_price_num">8.7</span>
                              </div>
                          </div>
                          <div class="book_function">
                            <div>
                                <button class="btn btn-default btn-sm book_function_add">加入购物车</button>
                            </div>
                          </div>
            </div>
        </div>

    </div>

  </div>
</template>

<script>
export default {
  
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
#book_image{
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
.book_image{
    height: 218px;
    width: 218px;
}

.book_info{
    border-top-style:solid;
    border-top-width: 1px;
    border-top-color: #dddddd;
    width:750px;
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
</style>
