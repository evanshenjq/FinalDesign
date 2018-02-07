<template>
	<div class="row">
		<!-- 搜索栏 -->
		<div class="input-group col-md-6 col-md-offset-3" id="search_nav">
  			<span class="input-group-addon" id="search_sort">图书{{name}}</span>
			<input type="text" class="form-control" id="search_book">
			<span class="input-group-btn">
       			 <button class="btn btn-default" type="button" id="search_button">
						<span class="glyphicon glyphicon-search" id="search_image"></span>
				</button>
      		</span>
		</div>
	</div>
</template>

<script>
export default {
	name:"AppHeader",
	data(){
		return{
			
		};
	},
	methods:{

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
</style>

