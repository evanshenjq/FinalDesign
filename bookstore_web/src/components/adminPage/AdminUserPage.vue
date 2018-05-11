<template>
  <div class="col-md-10">
    <!-- 功能栏 -->
    <div class="row" id="function_div">
        <div class="input-group input-group-sm col-md-offset-8 col-md-3">
            <input type="text" class="form-control" aria-label="..." v-model="searchContent">
            <div class="input-group-btn">
               <button type="button" class="btn btn-default" @click="searchByContent()">搜索</button>
            </div>
        </div>
    </div>
    <div class="row" id="search_choice">
        <div class="col-md-offset-8">
            <input id="check_id" type="radio" name="radio" value="1" checked>ID
            <input id="check_name" type="radio" name="radio" value="2">用户名
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
var searchStatus;
var self;
export default {
    data(){
        return{
            users:'',
            nowPage:'',
            totalPage:'',
            total:'',
            pageNums:[],
            searchContent:""
        };
    },
    mounted(){
        self=this;
        this.toPage(1);
    },
    methods:{
        toPage(pn){
            if(searchStatus=="name"){
                this.toNamePage(pn,self.searchContent);
            }
            else if(searchStatus=="id"){
                this.toIdPage(pn,self.searchContent);
            }else{
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
            }
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
        toIdPage(pn,searchContent){
           $.ajax({
                    url:"/zstu/getUserByIdPage/"+searchContent,
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
                        self.buildIdPageNav(result);
                    }
            });        
       },
       toNamePage(pn,searchContent){
           $.ajax({
                    url:"/zstu/getUsersByNamePage/"+searchContent,
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
                        self.buildNamePageNav(result);
				    }
                    });
       },
       buildIdPageNav(result){
           this.resetPage();
           self.pageNums=result.extend.users.navigatepageNums;
           if(!result.extend.users.hasPreviousPage){
               $('#firstPageLi').addClass('disabled');
               $('#prePageLi').addClass('disabled');
           }else{
               $('#firstPageLi').click(function(){
                   self.toIdPage(1,this.searchContent)
               });
               $('#prePageLi').click(function(){
                   self.toIdPage(result.extend.users.pageNum-1,this.searchContent);
               })
           }
            if(!result.extend.users.hasNextPage){
               $('#lastPageLi').addClass('disabled');
               $('#nextPageLi').addClass('disabled');
           }else{
               $('#lastPageLi').click(function(){
                   self.toIdPage(result.extend.users.pages,this.searchContent);
               });
               $('#nextPageLi').click(function(){
                   self.toIdPage(result.extend.users.pageNum+1,this.searchContent);
               })
           }
        },
        buildNamePageNav(result){
           this.resetPage();
           self.pageNums=result.extend.users.navigatepageNums;
           if(!result.extend.users.hasPreviousPage){
               $('#firstPageLi').addClass('disabled');
               $('#prePageLi').addClass('disabled');
           }else{
               $('#firstPageLi').click(function(){
                   self.toNamePage(1,this.searchContent)
               });
               $('#prePageLi').click(function(){
                   self.toNamePage(result.extend.users.pageNum-1,this.searchContent);
               })
           }
            if(!result.extend.users.hasNextPage){
               $('#lastPageLi').addClass('disabled');
               $('#nextPageLi').addClass('disabled');
           }else{
               $('#lastPageLi').click(function(){
                   self.toNamePage(result.extend.users.pages,this.searchContent);
               });
               $('#nextPageLi').click(function(){
                   self.toNamePage(result.extend.users.pageNum+1,this.searchContent);
               })
           }
        },
        searchByContent(){
           let searchContent=this.searchContent;
           console.log(searchContent);
            if(searchContent==""){
                searchStatus="";
                console.log(searchStatus);
                this.toPage(1);
            }else{
                if($("#check_id").is(":checked")){
                    searchStatus="id";
                    this.toIdPage(1,searchContent);
                }else{
                    searchStatus="name";
                    this.toNamePage(1,searchContent);
                }
            }           
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
