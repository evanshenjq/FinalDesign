<template>
  <div class="col-md-10">
    <!-- 功能栏 -->
    <div class="row" id="function_div">
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
            <input type="radio" name="radio" value="2">用户名
        </div>
    </div>

    <!-- 书籍列表 -->
    <table class="table table-hover">
        <thead>
            <tr>
                <th>ID</th>
                <th>用户名</th>
                <th>姓名</th>
                <th>联系电话</th>
                <th>地址</th>
                <th>创建时间</th>
                <th>更新时间</th>
            </tr>
        </thead>
        <tbody>
            <tr v-for="user in users">
                <td>{{user.id}}</td>
                <td>{{user.username}}</td>
                <td>{{user.name}}</td>
                <td>{{user.phone}}</td>
                <td>{{user.address}}</td>
                <td>{{myDateShow(user.created)}}</td>
                <td>{{myDateShow(user.updated)}}</td>
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
            users:'',
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
				url:"/zstu/getAllUsers",
				data:{'pn':pn},
				type:"POST",
				success:function(result){
                    //console.log(result);
                    self.users=result.extend.users.list;
                    //2.解析显示分页信息
                    self.nowPage=result.extend.users.pageNum;
                    self.totalPage=result.extend.users.pages;
                    self.total=result.extend.users.total;
                    //3.解释显示分页条
                    self.buildPageNav(result);
				      }
            });
       },
       buildPageNav(result){
           this.resetPage();
           self.pageNums=result.extend.users.navigatepageNums;
           if(!result.extend.users.hasPreviousPage){
               $('#firstPageLi').addClass('disabled');
               $('#prePageLi').addClass('disabled');
           }else{
               $('#firstPageLi').click(function(){
                   self.toPage(1)
               });
               $('#prePageLi').click(function(){
                   self.toPage(result.extend.users.pageNum-1);
               })
           }
            if(!result.extend.users.hasNextPage){
               $('#lastPageLi').addClass('disabled');
               $('#nextPageLi').addClass('disabled');
           }else{
               $('#lastPageLi').click(function(){
                   self.toPage(result.extend.users.pages);
               });
               $('#nextPageLi').click(function(){
                   self.toPage(result.extend.users.pageNum+1);
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
