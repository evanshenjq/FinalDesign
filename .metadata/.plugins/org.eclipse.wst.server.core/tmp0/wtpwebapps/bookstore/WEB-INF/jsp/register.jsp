<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<!-- 获取app_path地址下面用到 -->
<%
	pageContext.setAttribute("APP_PATH",request.getContextPath());
 %>
<!-- 引入JQuery -->
	<script type="text/javascript" src="${APP_PATH }/static/js/jquery-1.12.4.min.js"></script>
<!-- 引入Boostrap -->
  <link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
   <!--  -->
   <link href="${APP_PATH }/static/css/register.css" rel="stylesheet">
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
			 <button class="btn btn-link" id="register_page" style="color:#FFF">注册</button>
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
		
		<!-- 注册页面 -->
		<div class="row">
			<!-- 注册标题  -->
			<h1 class="col-md-offset-2 register-big">注册 <small>感谢您的使用</small></h1>
			<form id="register_form">
				<div class="col-md-5 col-md-offset-2">
					<h2 class="a">Personal infomation</h2>
					 <div class="form-group">
   						 <label for="exampleInputEmail1">姓名</label>
    					<input type="text" class="form-control input-lg" id="nameInput" name="name" placeholder="Name">
    					<span class="help-block"></span>
  					</div>
  					<div class="form-group">
   						 <label for="exampleInputEmail1">电话号码</label>
    					<input type="text" class="form-control input-lg" id="phoneInput" name="phone" placeholder="Phone Number">
    					<span class="help-block"></span>
  					</div>
  					<div class="form-group">
   						 <label for="exampleInputEmail1">收货地址</label>
    					<input type="text" class="form-control input-lg" id="addressInput" name="address" placeholder="Address">
    					<span class="help-block"></span>
  					</div>
					<a class="news-letter" href="#">
						 <label class="checkbox"><input type="checkbox" id="cb"><i>Sign Up for Newsletter</i></label>
					   </a>
					  
  					
				
				</div>
				
				<div class="col-md-5">
				<h2 class="a">LOGIN INFORMATION</h2>
					<div class="form-group">
   						 <label for="exampleInputEmail1">账号</label>
    					<input type="text" class="form-control input-lg" id="usernameInput" name="username" placeholder="Account">
    					<span class="help-block"></span>
  					</div>
  					<div class="form-group">
   						 <label for="exampleInputEmail1">密码</label>
    					<input type="password" class="form-control input-lg" id="passwordInput" name="password" placeholder="Password">
    					<span class="help-block"></span>
  					</div>
					<input class="btn-lg text-warning" type="button" id="register_submit" value="提交">
					
				</div>
				
			</form>

		
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
		$('#register_page').click(
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
		
		//函数用于展示检验信息
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
		
		//对用户名进行校验
		$('#usernameInput').change(function(){
			var username=this.value;
			$.ajax({
				url:"${APP_PATH}/checkName",
				data:{'username':username},
				type:"POST",
				success:function(result){
					if(result.code==100){
						show_validate_Msg('#usernameInput',"success","用户名可用");
						$("#register_submit").attr("ajax_name","success");
					}else{
						show_validate_Msg('#usernameInput',"error",result.extend.va_msg);
						$("#register_submit").attr("ajax_name","error");
					}
				}
				
			});
		});
		
		//对表单所有信息进行校验
		$('#register_submit').click(function(){
			function validate_register_form(){
				var password=$('#passwordInput').val();
				//密码为6-18为中英文组合，小写字母
				var regPassword=/^[a-z0-9]{6,16}$/;
				var name=$('#nameInput').val();
				//名字为2-5位中文或者3-16位英文
				var regName=/(^[a-zA-Z_-]{3,16})|(^[\u2E80-\u9FFF]+){2,5}/;
				var phone=$('#phoneInput').val();
				//手机号
				var regPhone=/^1[3|4|5|8][0-9]\d{4,8}$/; 
				
				if(!regPassword.test(password)){
					show_validate_Msg("#passwordInput","error","密码为6-16位小写英文和数字组合");
					
					return false;
				}else{
					show_validate_Msg("#nameInput","success","");
					
				};
				if(!regName.test(name)){
					//alert("用户名可以为2-5位中文或六到2-16英文");
					show_validate_Msg("#nameInput","error","用户名可以为2到5位中文或3到16位英文组合");
					
					return false;
				}else{
					show_validate_Msg("#nameInput","success","");
					
				};
				
				if(!regPhone.test(phone)){
					//alert("请输出正确的邮箱");
					show_validate_Msg("#phoneInput","error","请输出正确的手机");
					return false;
				}else{
					show_validate_Msg("#phoneInput","success","");
				};
				return true;
			}
			
			if(!($('#cb').is(":checked"))){
				alert("请遵守我们的规定");
				return false;
			}
			
			if(!validate_register_form()){
				return false;
			}
			if($('#register_submit').attr('ajax_name')=="error"){
				return false;
			}
			
			$.ajax({
				url:"${APP_PATH}/registerUser",
				type:"POST",
				data:$("#register_form").serialize(),
				success:function(result){
					if(result.code==100){
						alert("恭喜你注册成功！");
						window.location.href="login";
						
					}else{
						//显示失败信息
						if(undefined != result.extend.errorFiledMap.username){
							show_validate_Msg("#usernameInput","error",result.extend.errorFiledMap.username);
						}
						if(undefined != result.extend.errorFiledMap.password){
							show_validate_Msg("#passwordInput","error",result.extend.errorFiledMap.password);
						}	
						if(undefined != result.extend.errorFiledMap.name){
							show_validate_Msg("#nameInput","error",result.extend.errorFiledMap.name);
						}
						if(undefined != result.extend.errorFiledMap.phone){
							show_validate_Msg("#phoneInput","error",result.extend.errorFiledMap.phone);
						}
					}
					
				}
			});
			
		});
		
		</script>
</body>
	
</html>