<template>
    <div class="col-md-2" id="book_cat_nav">
        <ul>
            <li id="book_cats_title">
                图书:
            </li>
            <li v-for="cat in cats" class="book_cats">
                <a>
                {{cat.name}}
                </a>>
            </li>
        </ul>
    </div>
</template>

<script>
export default {
  name:'BookCatNav',
  data(){
      return{
          cats:"",
      };
  },
  mounted(){
      this.cats=[
          {id:1,name:"科学"},
          {id:2,name:"小说"},
          {id:3,name:"青春文学"},
      ]
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
        
    }
</style>




