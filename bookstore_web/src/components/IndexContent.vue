<template>
    <div class="col-md-10" id="index_content">
        <!-- 新书推荐栏 -->
        <div id="new_book_div" class="row book_div">
            <span id="new_book_titile" class="col-md-2 book_title">新书推荐</span>
            <!-- <a id="new_book_href" class="col-md-offset-8 col-md-2 blue_href">点击查看更多▶</a> -->
        </div>
        <div id="new_book_info" class="row book_info">
            <ol>
                <li class="col-md-2" v-for="newBook in newBooks">
                    <div>
                        <img class="book_image" :src="newBook.image" @click="turnBookInfoPage(newBook.id)">
                    </div>
                    <div>
                        <a class="blue_href" @click="turnBookInfoPage(newBook.id)">{{newBook.name}}</a>
                    </div>
                    <div>
                        {{newBook.publish}}
                    </div>
                    <div>
                        评分:{{newBook.score}}
                    </div>
                    <div>
                        价格：￥{{newBook.price}}
                    </div>
                </li>

            </ol>

        </div>

        <!-- 热门推荐栏 -->
        <div id="hot_book_div" class="row book_div">
            <span id="hot_book_titile" class="col-md-2 book_title">热门推荐</span>
            <!-- <a id="hot_book_href" class="col-md-offset-8 col-md-2 blue_href">点击查看更多▶</a> -->
        </div>
        <div id="hot_book_info" class="row book_info">
            <ol>
                <li class="col-md-2" v-for="hotBook in hotBooks">
                    <div>
                        <img class="book_image" :src="hotBook.image" @click="turnBookInfoPage(hotBook.id)">
                    </div>
                    <div>
                        <a class="blue_href" @click="turnBookInfoPage(hotBook.id)">{{hotBook.name}}</a>
                    </div>
                    <div>
                        {{hotBook.publish}}
                    </div>
                    <div>
                        评分:{{hotBook.score}}
                    </div>
                    <div>
                        价格：￥{{hotBook.price}}
                    </div>
                </li>
            </ol>
        </div>
    </div>  
</template>

<script>
var self;
export default {
  data(){
      return{
          newBooks:"",
          hotBooks:"",
      }
  },
  mounted(){
      self=this;
      this.getNewBooks();
      this.getHotBooks();
  },
  methods:{
      getNewBooks(){
          $.ajax({
              url:"/zstu/getNewBooks",
              type:"POST",
              success:function(result){
                  self.newBooks=result.extend.newBooks;
              }
          });
      },
      getHotBooks(){
          $.ajax({
              url:"/zstu/getHotBooks",
              type:"POST",
              success:function(result){
                  self.hotBooks=result.extend.hotBooks;
              }
          });
      },
      turnBookInfoPage(id){
          this.$router.push('/bookInfo/'+id);
      }
  }

}
</script>

<style>
.book_div{
    width:100%;
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
    width: 118px;
    cursor: pointer;
}
</style>

