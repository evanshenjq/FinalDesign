<template>
    <div class="col-md-10" id="index_content">
        <div id="new_book_div" class="row">
            <span id="new_book_titile" class="col-md-2">新书推荐</span>
            <a id="new_book_href" class="col-md-offset-8 col-md-2">点击查看更多▶</a>
        </div>

    </div>  
</template>

<script>
export default {
  name:'IndexContent',

}
</script>

<style>
#new_book_div{
     border-bottom-style:solid;
    border-bottom-width: 0.8px;
    border-bottom-color: #dddddd;
}
#new_book_titile{
    font-weight: 700;
    font-size: 21px;
    line-height: 1.3;
}
#new_book_href{
    color: #0066c0;
}
</style>

