package zstu.sjq.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import zstu.sjq.bean.*;
import zstu.sjq.service.UserService;
import zstu.sjq.utils.IDUtils;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	//登陆
	@RequestMapping("/loginUser")
	@ResponseBody
	public Msg loginUser(HttpServletRequest request) {
		
		BsUser user=userService.loginUser(request.getParameter("username"), request.getParameter("password"));
		if(user!=null) {
			return Msg.success().add("user", user);
		}else {
			return Msg.failed().add("va_msg","请输入正确的用户名或密码");
		}
	}
	
	//注册
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	@ResponseBody
	public Msg registerUser(HttpServletRequest request) {
		
		BsUser user=new BsUser();
		user.setId(IDUtils.genRandomId());
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
		user.setName(request.getParameter("name"));
		user.setPhone(request.getParameter("phone"));
		user.setCreated(new Date());
		user.setUpdated(new Date());
		
		userService.addUser(user);
		
		return Msg.success();
		
	}
	
	//后端检验用户名
	@RequestMapping("/checkName/{username}")
	@ResponseBody
	public Msg checkUsername(@PathVariable String username) {
		boolean b=userService.hasUser(username);
		if(b) {
			return Msg.success().add("va_msg", "该用户可以使用");
		}else {
			return Msg.failed().add("va_msg", "该用户已经存在");
		}
	}
	
	
	//用户更新信息
		@RequestMapping("/updateUser")
		@ResponseBody
		public Msg update(@Valid BsUser user) {
			
			return Msg.success();
		}

}
