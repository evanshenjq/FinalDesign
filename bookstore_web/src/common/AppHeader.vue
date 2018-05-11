<template>
	<div class="row">
		<!-- 搜索栏 -->
		<div class="col-md-1">
			<a href="/">
			<!-- test -->
				<img id="logo_image" src="../assets/image/logo.png">
			</a>
		</div>
		<div class="input-group col-md-6 col-md-offset-2" id="search_nav">
  			<span class="input-group-addon" id="search_sort">{{name}}</span>
			<input type="text" class="form-control" id="search_book" v-model="searchName">
			<span class="input-group-btn">
       			 <button class="btn btn-default" type="button" id="search_button" @click="searchBooksByName()">
						<span class="glyphicon glyphicon-search" id="search_image"></span>
				</button>
      		</span>
		</div>
	</div>
</template>

<script>
var self;
export default {
	name:"AppHeader",
	data(){
		return{
			name:"图书",
			searchName:""
		};	
	},
	mounted(){
        self=this;
    },
	methods:{
		//跳转到bookInfo界面，再把内容显示出来
		searchBooksByName(){
			if(this.searchName==null){
				alert("请输入正确的搜索书名！");
			}else{
                self.$router.push({
					name:'booksInfo',
					params:{
						catId:0,
						searchName:self.searchName,
						searchStatus:1
					}
           		});
			}
		}
	}
}
</script>

<style>
#search_nav{
	margin-top: 8px;	
	margin-bottom: 8px;
}
#search_sort{
	font-size: 10px;
}
#search_button{
	background-color: #71777e;
}
#search_image{
	color: azure;
}
#logo_image{
	width: 190px;
	height: 54px;
	margin-left: 8px;
	margin-top: 3px;
}
</style>

