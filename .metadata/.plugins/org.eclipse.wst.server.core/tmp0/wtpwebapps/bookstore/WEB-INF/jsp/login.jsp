<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆页面</title>
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
   <link href="${APP_PATH }/static/css/login.css" rel="stylesheet">
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
			<!-- 注册登陆栏 -->
			<div class="col-md-2 col-md-offset-10">
			 <button class="btn btn-link" id="register" style="color:#FFF">注册</button>
			 <button class="btn btn-link" id="login" style="color:#FFF">登录</button>
			</div>	
		</div>
		<div class="row" id="head-mid">
			<!-- 导航栏 -->
			<div class="col-md-2 col-md-offset-1">
				<img src="${APP_PATH }/static/images/logo.png" width="165px" height="50px">
			</div>
			<div class="col-md-4 col-md-offset-3">
				<ul class="nav nav-tabs nav-justified">
  					<li role="presentation" id="home"><a href="#">首页HOME</a></li>
 				    <li role="presentation"><a href="#">开始选购！</a></li>
  					<li role="presentation"><a href="#">联系我们</a></li>
				</ul>
			</div>
		</div>
		
		<div class="row" id="login">
			<h1 class="col-md-offset-2 login-big">登陆 <small>记得常来</small></h1>	
			<div class="col-md-5 col-md-offset-2">
			<form id="login_form">	
				 <div class="form-group" id="userDiv">
   						 <label for="exampleInputEmail1">账号</label>
    					<input type="text" class="form-control input-lg" id="nameInput" name="username" placeholder="Username">
  					</div>
  					<div class="form-group">
   						 <label for="exampleInputEmail1">密码</label>
    					<input type="password" class="form-control input-lg" id="passwordInput" name="password" placeholder="Password">
    					<span class="help-block"></span>
  					</div>
  					<div id="radio">
  						<input type="radio" name="radio" id="user_radio" checked="checked">购物用户
  						<input type="radio" name="radio" id="root_radio">root
  					</div>
  					<input class="btn-lg text-warning" id="login-submit" type="button" value="提交">
			</form>	
			</div>
			
			<!-- 右边图片区 -->
			<div class="col-md-3 col-md-offset-1" id="left-account">
				<div class="five">
					<h5>comming</h5>
					<span>soon</span>
				</div>
				<a class="create">Create an account</a>
			</div>
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
		
		<script type="text/javascript">
		//跳转到首页
		$('#home').click(
			function(){
				window.location.href="/bookstore";
			}		
		);
		
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
		
		//图片跳转注册逻辑
		$('.create').click(
			function(){
				window.location.href="register";
			}		
		);
		
		function show_validate_Msg(ele,status,msg){
			$(ele).parent().removeClass("has-success has-error");
			$(ele).next("span").text("");
			if("success"==status){
				$(ele).parent().addClass("has-success");
				$(ele).next("span").text(msg);
				
			}else if("error"==status){
				$(ele).parent().addClass("has-error");
				$(ele).next("span").text(msg);
			}
		}
		
		//登陆逻辑
		$('#login-submit').click(function(){
			if($('#user_radio').is(":checked")){
				$('#nameInput').attr('name','username');
				$('#passwordInput').attr('name','password');
				//用户登录逻辑
			$.ajax({
				url:"${APP_PATH}/loginUser",
				type:"POST",
				data:$('#login_form').serialize(),
				success:function(result){
					if(result.code==100){
						//添加用户session
						var userString=JSON.stringify(result.extend.user);
						
						$.session.set('user',userString);
						
						alert("登陆成功！跳转至首页");
						window.location.href="/bookstore";
						
					}else{
						show_validate_Msg("#passwordInput","error",result.extend.va_msg);
						return false;
					}
				}
				
			});				
				
			}else{
				$('#nameInput').attr('name','r_username');
				$('#passwordInput').attr('name','r_password');
				//管理员登陆逻辑
				$.ajax({
					url:"${APP_PATH}/loginRoot",
					type:"POST",
					data:$('#login_form').serialize(),
					success:function(result){
						if(result.code==100){
							alert("跳转至管理后台");
						}else{
							show_validate_Msg("#passwordInput","error",result.extend.va_msg);
							return false;
						}
					}
					
				});				
			}
		});
		
		
		</script>
</body>
	