<template>
  <div class="col-md-10">
    <!-- 功能栏 -->
    <div class="row" id="function_div">
        <div class="col-md-1">
            <button type="button" class="btn btn-success glyphicon glyphicon-plus" @click="showAddBookPage()"></button>
        </div>
        <div class="input-group input-group-sm col-md-offset-8 col-md-3">
            <input type="text" class="form-control" aria-label="...">
            <div class="input-group-btn">
               <button type="button" class="btn btn-default">搜索</button>
            </div>
        </div>
    </div>
    <div class="row" id="search_choice">
        <div class="col-md-offset-8">
            <input type="radio" name="radio" value="1">ID
            <input type="radio" name="radio" value="2">书名
            <input type="radio" name="radio" value="3" checked>状态
        </div>
    </div>

    <!-- 书籍列表 -->
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>书名</th>
                <th>价格</th>
                <th>数量</th>
                <th>状态</th>
                <th>发布时间</th>
                <th>更新时间</th>
                <th>操作</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="book in books">
                <td>{{book.id}}</td>
                <td>{{book.name}}</td>
                <td>￥{{book.price}}</td>
                <td>{{book.num}}</td>
                <td>{{statusShow(book.status)}}</td>
                <td>{{myDateShow(book.created)}}</td>
                <td>{{myDateShow(book.updated)}}</td>
                <td>
                    <button class="btn btn-info glyphicon glyphicon-pencil" @click="updateBook(book.id)"></button>
                    <button class="btn btn-danger glyphicon glyphicon-remove" @click="delBook(book.id)"></button>
                </td>
            </tr>
        </tbody>
    </table>

    <!-- 分页栏 -->
	<div class="row">
	<!-- 分页文字信息 -->
		<div class="col-md-6" id="page_info">
			当前{{nowPage}}页,总{{totalPage}}页,总共{{total}}条记录
		</div>
	<!-- 分页条 -->
		<div class="col-md-6" id="page_nav">
            <ul class="pagination" >
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
		</div>
	</div>
	
  </div>
</template>

<script>
import {dateShow} from '@/assets/js/time.js'

var self;
export default {
    data(){
        return{
            books:'',
            nowPage:'',
            totalPage:'',
            total:'',
            pageNums:[]
        };
    },
    mounted(){
        self=this;
        this.toPage(1);
    },
    methods:{
        toPage(pn){
            $.ajax({
				url:"/zstu/getAllBooks",
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
        myDateShow(time){
           return dateShow(time);
        },
        statusShow(num){
           if(num==1){
               return "上架中";
           }
           else if(num==2){
               return "待上架";
           }
           else if(num==3){
               return "下架";
           }
       },
       showAddBookPage(){
           this.$router.push('/addBookPage');
       },
       delBook(id){
           if(confirm("确认删除ID为"+id+"的书籍吗?")){
               $.ajax({
                   url:"/zstu/deleteBook/"+id,
                   type:"POST",
                   success:function(result){
                       alert(result.extend.mes);
                       location.reload();
                   }
               })
           }
       },
       updateBook(id){
           this.$router.push("/updateBookPage/"+id);
       }
       

    }
}
</script>

<style>
#function_div{
    margin-top:5px;
}
#search_choice{
    margin-bottom: 8px;
}
</style>
