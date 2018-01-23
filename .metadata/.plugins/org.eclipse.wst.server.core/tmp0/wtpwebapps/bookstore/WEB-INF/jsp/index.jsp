<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎来到电子书城</title>
<!-- 获取app_path地址下面用到 -->
<%
	pageContext.setAttribute("APP_PATH",request.getContextPath());
 %>
<!-- 引入JQuery -->
	<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/js/jquery.cookie.js"></script>
	<script type="text/javascript" src="${APP_PATH }/static/js/jquerySession.js"></script>
<!-- 引入Boostrap -->
  <link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
   <!--  -->
   <link href="${APP_PATH }/static/css/index.css" rel="stylesheet">
</head>
<body>
	<!-- 学校模态框 -->
		<div class="modal fade school-modal" tabindex="-1" role="dialog">
  			<div class="modal-dialog" role="document">
    			<div class="modal-content">
      				<div class="modal-header">
        				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title">我的学校</h4>
      				</div>
      				<div class="modal-body">
        			<h3>浙江理工大学，信息学院，14计算机科学与技术(1)，沈佳琦，2014329620023，毕业设计，</h3>
        			<h3>导师:周志宇老师，题目:基于JAVA技术的图书电子商务系统实现</h3>
      				</div>
    			</div><!-- /.modal-content -->
  			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
	<!-- 常见问题模态框 -->
		<div class="modal fade question-modal" tabindex="-1" role="dialog">
  			<div class="modal-dialog" role="document">
    			<div class="modal-content">
      				<div class="modal-header">
        				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        			<h4 class="modal-title">常见问题</h4>
      				</div>
      				<div class="modal-body">
        			<h3>常见问题就是没有问题</h3>
      				</div>
    			</div><!-- /.modal-content -->
  			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
	<!-- 搭建首页页面 -->
	<div class="container-fluid">
		<!-- 页面头:登陆,注册 -->
		<div class="row" id="head-top">
			<!-- 登陆前:注册登陆栏            登陆后:个人中心，购物车，注销 -->
			
		</div>
		<div class="row" id="head-mid">
			<!-- 导航栏 -->
			<div class="col-md-2 col-md-offset-1">
				<img src="${APP_PATH }/static/images/logo.png" width="165px" height="50px">
			</div>
			<div class="col-md-4 col-md-offset-3">
				<ul class="nav nav-tabs nav-justified">
  					<li role="presentation" class="active" id="home"><a href="#">首页HOME</a></li>
 				    <li role="presentation"><a href="#">开始选购！</a></li>
  					<li role="presentation"><a href="#">联系我们</a></li>
				</ul>
			</div>
		</div>
		
		<div class="row" >
			<!-- 横幅 -->
			<div class="jumbotron" id="banner">
  				<h1>Hello, world!</h1>
  			<p>欢迎来到电子图书商城，一个新世界！</p>
  			<p><a class="btn btn-primary btn-lg" href="#" role="button">了解更多</a></p>
			</div>
		</div>
		
		<div class="row">
			<div class="page-header col-md-offset-2">
  			<h1>热销书籍 <small>喜欢常来</small></h1>
			</div>
		</div>
		
		<div class="row" id="shop">
			<!-- 商品展示 -->
  				<div class="col-md-2 col-md-offset-2">
    				<div class="thumbnail">
     					 <img src="..." alt="...">
      			     <div class="caption">
        				<h3>Thumbnail label</h3>
        				<p>...</p>
        				<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
      				</div>
    				</div>
				</div>
			
			<!-- 商品展示 -->
  				<div class="col-md-2 col-md-offset-1">
    				<div class="thumbnail">
     					 <img src="..." alt="...">
      			     <div class="caption">
        				<h3>Thumbnail label</h3>
        				<p>...</p>
        				<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
      				</div>
    				</div>
				</div>
			
			<!-- 商品展示 -->
  				<div class="col-md-2 col-md-offset-1">
    				<div class="thumbnail">
     					 <img src="..." alt="...">
      			     <div class="caption">
        				<h3>Thumbnail label</h3>
        				<p>...</p>
        				<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
      				</div>
    				</div>
				</div>
			</div>
			
			<div class="row">
				<h1>待开发区域</h1>
			
			</div>
		
		<div class="row" id="footer">
			<!-- 底边 -->
			<div id="container">
				<div class="col-md-3 col-md-offset-1">
				<h1>MORE INFO</h1>
				<p>
				<button type="button" class="btn btn-link" 
				data-toggle="modal" data-target=".school-modal">学校</button>
				</p>
				<button type="button" class="btn btn-link" 
				data-toggle="modal" data-target=".question-modal">常见问题</button>
				</div>
				<!-- 联系方式 -->
				<div class="col-md-3 col-md-offset-1">
				<h1>CONTACT US</h1>
				<p>如果你有更好的想法</p>
				<p>更经典的创意</p>
				<p>phone: +159 5800 31xx</p>
				</div>
				
				<div class="col-md-3 col-md-offset-1" id="logo-big">
					<img src="${APP_PATH }/static/images/logo-big.png" width="198px" height="60px">
				</div>
				
				
			</div>
		</div>
			<div class="row" id="foot">
				<h3 class="text-center">版权所有©沈佳琦</h3>
			</div>
		</div>
	
		
	</div>
	
	<script type="text/javascript">
		//跳转到商品浏览
		
		
		
		
		//判断登陆状态
		$(function(){
			judge_user_status();
		})
		
		function judge_user_status(){
			if($.session.get('user')!=null){
				//出现 欢迎个人用户和个人中心，购物车，注销
				
				var userString=$.session.get('user');
				var user=JSON.parse(userString)
				var userInfoBtn=$("<button></button>").append(user.name).addClass('btn btn-link').attr("style","color:#FFF").attr('id','userInfo');
				var shopcatBtn=$("<button></button>").append("购物车").addClass('btn btn-link').attr("style","color:#FFF").attr('id','shopcat');
				var logoutBtn=$("<button></button>").append("注销").addClass('btn btn-link').attr("style","color:#FFF").attr('id','logout');
				var headLi=$("<div></div>").addClass("col-md-3 col-md-offset-9").
				attr("id","user_is_login").append("欢迎您,").append(userInfoBtn).append(shopcatBtn).append(logoutBtn);
				
				$('#head-top').append(headLi);
				
				$('#logout').click(function(){
					$.session.remove('user');
					
					window.location.href="/bookstore";
				});
				
				//之后userInfo跳转到个人中心
				$('#userInfo').click(function(){
					window.location.href="userInfo";
				});
				
				
			}else{
				//出现注册登录跳转页
				var registerBtn=$("<button></button>").append("注册").attr('id','register').addClass('btn btn-link').attr("style","color:#FFF");
				var loginBtn=$("<button></button>").append("登录").attr('id','login').addClass('btn btn-link').attr("style","color:#FFF");
				var headLi=$("<div></div>").addClass("col-md-2 col-md-offset-10").
				attr("id","user_not_login").append(registerBtn).append(loginBtn);
				$('#head-top').append(headLi);
				
				//跳转到注册界面
				$('#register').click(
					function(){
						window.location.href="register";
					}		
				);
				
				//跳转到注册界面
				$('#login').click(
					function(){
						window.location.href="login";
					}		
				);
				
				
			}
		}
		
		
	</script>
	
	
</body>
</html>