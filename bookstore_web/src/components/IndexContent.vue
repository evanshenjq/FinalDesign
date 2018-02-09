<template>
    <div class="col-md-10" id="index_content">
        <!-- 新书推荐栏 -->
        <div id="new_book_div" class="row book_div">
            <span id="new_book_titile" class="col-md-2 book_title">新书推荐</span>
            <a id="new_book_href" class="col-md-offset-8 col-md-2 blue_href">点击查看更多▶</a>
        </div>
        <div id="new_book_info" class="row book_info">
            <ol>
                <li class="col-md-2">
                    <div>
                        <img class="book_image" src="../assets/image/1.jpg">
                    </div>
                    <div>
                        <a class="blue_href">默读</a>
                    </div>
                    <div>
                        黄河出版社
                    </div>
                    <div>
                        评分:4.7
                    </div>
                    <div>
                        价格：100元
                    </div>
                </li>

                <li class="col-md-2">
                    <div>
                        <img class="book_image" src="../assets/image/2.jpg">
                    </div>
                    <div>
                        <a class="blue_href">默读</a>
                    </div>
                    <div>
                        黄河出版社
                    </div>
                    <div>
                        评分:4.7
                    </div>
                    <div>
                        价格：100元
                    </div>
                </li>

                <li class="col-md-2">
                    <div>
                        <img class="book_image" src="../assets/image/3.jpg">
                    </div>
                    <div>
                        <a class="blue_href">默读</a>
                    </div>
                    <div>
                        黄河出版社
                    </div>
                    <div>
                        评分:4.7
                    </div>
                    <div>
                        价格：100元
                    </div>
                </li>
                <li class="col-md-2">
                    <div>
                        <img class="book_image" src="../assets/image/4.jpg">
                    </div>
                    <div>
                        <a class="blue_href">默读</a>
                    </div>
                    <div>
                        黄河出版社
                    </div>
                    <div>
                        评分:4.7
                    </div>
                    <div>
                        价格：100元
                    </div>
                </li>
                <li class="col-md-2">
                    <div>
                        <img class="book_image" src="../assets/image/5.jpg">
                    </div>
                    <div>
                        <a class="blue_href">默读</a>
                    </div>
                    <div>
                        黄河出版社
                    </div>
                    <div>
                        评分:4.7
                    </div>
                    <div>
                        价格：100元
                    </div>
                </li>
                <li class="col-md-2">
                    <div>
                        <img class="book_image" src="../assets/image/6.jpg">
                    </div>
                    <div>
                        <a class="blue_href">默读</a>
                    </div>
                    <div>
                        黄河出版社
                    </div>
                    <div>
                        评分:4.7
                    </div>
                    <div>
                        价格：100元
                    </div>
                </li>
            </ol>

        </div>

        <!-- 热门推荐栏 -->
        <div id="hot_book_div" class="row book_div">
            <span id="hot_book_titile" class="col-md-2 book_title">热门推荐</span>
            <a id="hot_book_href" class="col-md-offset-8 col-md-2 blue_href">点击查看更多▶</a>
        </div>
        <div id="hot_book_info" class="row book_info">
            <ol>
                <li class="col-md-2">
                    <div>
                        <img class="book_image" src="../assets/image/a.jpg">
                    </div>
                    <div>
                        <a class="blue_href">默读</a>
                    </div>
                    <div>
                        黄河出版社
                    </div>
                    <div>
                        评分:4.7
                    </div>
                    <div>
                        价格：100元
                    </div>
                </li>

                <li class="col-md-2">
                    <div>
                        <img class="book_image" src="../assets/image/b.jpg">
                    </div>
                    <div>
                        <a class="blue_href">默读</a>
                    </div>
                    <div>
                        黄河出版社
                    </div>
                    <div>
                        评分:4.7
                    </div>
                    <div>
                        价格：100元
                    </div>
                </li>

                <li class="col-md-2">
                    <div>
                        <img class="book_image" src="../assets/image/c.jpg">
                    </div>
                    <div>
                        <a class="blue_href">默读</a>
                    </div>
                    <div>
                        黄河出版社
                    </div>
                    <div>
                        评分:4.7
                    </div>
                    <div>
                        价格：100元
                    </div>
                </li>
                <li class="col-md-2">
                    <div>
                        <img class="book_image" src="../assets/image/d.jpg">
                    </div>
                    <div>
                        <a class="blue_href">默读</a>
                    </div>
                    <div>
                        黄河出版社
                    </div>
                    <div>
                        评分:4.7
                    </div>
                    <div>
                        价格：100元
                    </div>
                </li>
                <li class="col-md-2">
                    <div>
                        <img class="book_image" src="../assets/image/e.jpg">
                    </div>
                    <div>
                        <a class="blue_href">默读</a>
                    </div>
                    <div>
                        黄河出版社
                    </div>
                    <div>
                        评分:4.7
                    </div>
                    <div>
                        价格：100元
                    </div>
                </li>
                <li class="col-md-2">
                    <div>
                        <img class="book_image" src="../assets/image/f.jpg">
                    </div>
                    <div>
                        <a class="blue_href">默读</a>
                    </div>
                    <div>
                        黄河出版社
                    </div>
                    <div>
                        评分:4.7
                    </div>
                    <div>
                        价格：100元
                    </div>
                </li>
            </ol>
        </div>
    </div>  
</template>

<script>
export default {
  name:'IndexContent',

}
</script>

<style>
.book_div{
    border-bottom-style:solid;
    border-bottom-width: 0.8px;
    border-bottom-color: #dddddd;
}
.book_info{
    margin-top:30px;
    margin-bottom: 40px;
}
.book_title{
    font-weight: 700;
    font-size: 21px;
    line-height: 1.3;
    color: #0066c0;
}
.blue_href{
    color: #0066c0;
}
.book_image{
    height: 150px;
    width: 118px;;
}
</style>

