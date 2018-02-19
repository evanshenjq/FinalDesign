<template>
    <div class="col-md-2" id="book_cat_nav">
        <ul>
            <li id="book_cats_title">
                图书:
            </li>
            <li v-for="cat in cats" class="book_cats">
                <a @click="turnBooksInfoPage(cat.id)">
                {{cat.name}}
                </a>>
            </li>
        </ul>
    </div>
</template>

<script>
var self;
export default {
  name:'BookCatNav',
  data(){
      return{
          cats:"",
      };
  },
  mounted(){
      self=this;
      this.getBookCats();
  },
  methods:{
      getBookCats(){
          $.ajax({
              url:"/zstu/getBookCatsNoPage",
              type:"POST",
              success:function(result){
                  self.cats=result.extend.cats;
              }
          });
      },
      turnBooksInfoPage(id){
          this.$router.push("/booksInfo/"+id);
          location.reload();
      }
  }

}
</script>

<style>
    li{
        list-style-type: none;
    }
    a{
        cursor: pointer;
        color:#333333;
    }
    #book_cat_nav{
        border-right-style:solid;
        border-right-width: 0.8px;
        border-right-color: #dddddd;
    }
    #book_cats_title{
        font-size: 16px;
        color: #999;
    }
    .book_cats{
        margin-left: 10px;
        margin-bottom: 3px;
        
    }
</style>




