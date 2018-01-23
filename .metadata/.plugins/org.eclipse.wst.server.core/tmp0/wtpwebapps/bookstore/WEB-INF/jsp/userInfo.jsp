<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<script type="text/javascript" src="${APP_PATH }/static/js/time.js"></script>
<!-- 引入Boostrap -->
  <link href="${APP_PATH }/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
   <script src="${APP_PATH}/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
   <!--  -->
   <link href="${APP_PATH }/static/css/index.css" rel="stylesheet">
   <link href="${APP_PATH }/static/css/userInfo.css" rel="stylesheet">
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
		
		<div class="row" id="info_container">
			<div class="col-md-2 col-md-offset-1">
				<div id="user_info">
					<h3 id="user_center">个人中心</h3>
				</div>
				<div id="user_function">
				<div id="firstdiv">
					<button type="button" class="btn btn-link" id="user_info_btn">个人信息</button>
					<span class="glyphicon glyphicon-ok"></span>
				</div>
				<div>
					<button type="button" class="btn btn-link" id="shop_cat_btn">购物车</button>
					<span></span>
				</div>
				<div>
					<button type="button" class="btn btn-link" id="order_info_btn">订单信息</button>
					<span></span>
				</div>	
				</div>
			</div>
			
			
			<!-- 个人中心三个功能的表单显示 -->
			<div class="col-md-6 col-md-offset-1" id="user_info_show">
				<form class="form-horizontal" id="update_form">
					<div class="form-group">
						<input type="hidden" id="username_update_id" name="id">
					</div>
  					<div class="form-group">
    					<label class="col-sm-2 control-label">用户名</label>
    					 <div class="col-sm-8">
     				 		<input type="text" class="form-control" id="username_update_input" name="username" placeholder="Username" disabled>
 							<span class="help-block"></span>
 						</div>
 					</div>
  					<div class="form-group">
    				<label class="col-sm-2 control-label">密码</label>
    					<div class="col-sm-8">
     				    	<input type="password" class="form-control" id="password_update_input" name="password" placeholder="Password">
  							<span class="help-block"></span>
  						</div>
  					</div>
  					<div class="form-group">
    				<label class="col-sm-2 control-label">姓名</label>
    					<div class="col-sm-8">
     				    	<input type="text" class="form-control"  id="name_update_input" name="name" placeholder="name">
  							<span class="help-block"></span>
  						</div>
  					</div>
  					<div class="form-group">
  					<label class="col-sm-2 control-label">手机</label>
  						<div class="col-sm-8">
     				    	<input type="text" class="form-control" id="phone_update_input" name="phone" placeholder="phone">
			 				<span class="help-block"></span>
			 			</div>
			 		</div>
  					<div class="form-group">
  					<label class="col-sm-2 control-label">地址</label>
  						<div class="col-sm-8">
     				    	<input type="text" class="form-control" id="address_update_input" name="address" placeholder="address">
			 				<span class="help-block"></span>
			 			</div>
			 		</div>
			 		<div>
			 			<h5 id="updated_time">上次更新于</h5>
			 		</div>
			 		<div>
			 			<div class="col-sm-offset-5 col-sm-2">
      		  				<button type="button" class="btn btn-default" id="user_update_btn">更改</button>
      		  			</div>
 			 		</div>
				</form>
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
				<p>phone: 159580031xx</p>
				</div>
				<div class="col-md-3 col-md-offset-1">
					<img src="${APP_PATH }/static/images/logo.png" width="165px" height="50px">
				</div>
			</div>
		</div>
		
			<div class="row" id="foot">
				<h3 class="text-center">版权所有©沈佳琦</h3>
			</div>
		</div>
	
		
	
	<script type="text/javascript">
	
		
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
				//注销按钮
				$('#logout').click(function(){
					$.session.remove('user');
					window.location.href="/bookstore";
				});
				//之后userInfo跳转到个人中心
				$('#userInfo').click(function(){
					window.location.href="userInfo";
				});
			}else{
				window.location.href="error";
			}
		}
		
		function add_choose(ele){
			$('#user_function div span').removeClass("glyphicon").removeClass("glyphicon-ok");
			$(ele).next("span").addClass("glyphicon").addClass("glyphicon-ok");
		}
		
		function get_user_info(){
			var userString=$.session.get('user');
			var user=JSON.parse(userString);
			var updated=date_show(user.updated);
			$('#username_update_id').attr('value',user.id);
			$('#username_update_input').attr('value',user.username);
			$('#password_update_input').attr('value',user.password);
			$('#name_update_input').attr('value',user.name);
			$('#phone_update_input').attr('value',user.phone);
			$('#address_update_input').attr('value',user.address);
			$('#updated_time').append(updated);
		}
		
		//跳转到首页
		$('#home').click(
			function(){
				window.location.href="/bookstore";
			}		
		);
		
		//判断登陆状态构建栏
		judge_user_status();
		get_user_info();
		
		//显示错误信息
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
		
		//左边3个功能点击切换
		$('#user_info_btn').click(function(){
			add_choose('#user_info_btn');
		});
		
		$('#shop_cat_btn').click(function(){
			add_choose('#shop_cat_btn');
		});
		
		$('#order_info_btn').click(function(){
			add_choose('#order_info_btn');
		});
		
		
		$('#user_update_btn').click(function(){
			function validate_update_form(){
				var password=$('#password_update_input').val();
				//密码为6-18为中英文组合，小写字母
				var regPassword=/^[a-z0-9]{6,16}$/;
				var name=$('#name_update_input').val();
				//名字为2-5位中文或者3-16位英文
				var regName=/(^[a-zA-Z_-]{3,16})|(^[\u2E80-\u9FFF]+){2,5}/;
				var phone=$('#phone_update_input').val();
				//手机号
				var regPhone=/^1[3|4|5|8][0-9]\d{4,8}$/; 
				
				if(!regPassword.test(password)){
					show_validate_Msg("#password_update_input","error","密码为6-16位小写英文和数字组合");
					
					return false;
				}else{
					show_validate_Msg("#password_update_input","success","");
					
				};
				if(!regName.test(name)){
					//alert("用户名可以为2-5位中文或六到2-16英文");
					show_validate_Msg("#name_update_input","error","用户名可以为2到5位中文或3到16位英文组合");
					
					return false;
				}else{
					show_validate_Msg("#name_update_input","success","");
					
				};
				if(!regPhone.test(phone)){
					//alert("请输出正确的邮箱");
					show_validate_Msg("#phone_update_input","error","请输出正确的手机");
					return false;
				}else{
					show_validate_Msg("#phone_update_input","success","");
				};
				return true;
			}
			
			if(!validate_update_form()){
				return false;
			};
			
			if(confirm("更新需要重新登陆")){
				$.ajax({
					url:"${APP_PATH}/updateUser",
					data:$('#update_form').serialize(),
					type:"POST",
					success:function(result){
						if(result.code==100){
							
							$.session.remove('user');
							alert("更新成功！返回登陆页");
							window.location.href="login";
							
						}else{
							if(undefined != result.extend.errorFiledMap.password){
								show_validate_Msg("#password_update_input","error",result.extend.errorFiledMap.password);
							}	
							if(undefined != result.extend.errorFiledMap.name){
								show_validate_Msg("#name_update_input","error",result.extend.errorFiledMap.name);
							}
							if(undefined != result.extend.errorFiledMap.phone){
								show_validate_Msg("#phone_update_input","error",result.extend.errorFiledMap.phone);
							}
						}
					}
					
				});
			}
				
		});
		
	</script>
	
	
</body>
</html>
		