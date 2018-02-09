<template>

  <div class="col-md-10" id="book_content">
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
                  <div>
                      
                  </div>

              </li>
          </ul>
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
</style>

