package zstu.sjq.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	public Msg loginUser(String username,String password) {
		
		BsUser user=userService.loginUser(username, password);
		if(user!=null) {
			return Msg.success().add("user", user);
		}else {
			return Msg.failed().add("va_msg","请输入正确的用户名或密码");
		}
	}
	
	//注册
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	@ResponseBody
	public Msg registerUser(@Valid BsUser user,BindingResult result) {
		//BindingResult
		if(result.hasErrors()) {
			Map<String,Object> map=new HashMap();
			List<FieldError> errors = result.getFieldErrors();
			for(FieldError fieldError:errors) {
				map.put(fieldError.getField(),fieldError.getDefaultMessage());
			}
			return Msg.failed().add("errorFiledMap", map);
		}else {
			
			user.setId(IDUtils.genRandomId());
			user.setCreated(new Date());
			user.setUpdated(new Date());
			userService.addUser(user);
			
			return Msg.success();
		}
	}
	
	//后端检验用户名
	@RequestMapping("/checkName")
	@ResponseBody
	public Msg checkUsername(String username) {
		String regx="[a-zA-Z][a-zA-Z0-9]{3,11}";
		if(!username.matches(regx)) {
			return Msg.failed().add("va_msg", "用户名必须是4-12位英文和数字组合，且首字母为英文");
		}
		boolean b=userService.hasUser(username);
		if(b) {
			return Msg.success();
		}else {
			return Msg.failed().add("va_msg", "该用户已经存在");
		}
	}
	
	
	//用户更新信息
		@RequestMapping("/updateUser")
		@ResponseBody
		public Msg update(@Valid BsUser user,BindingResult result) {
			if(result.hasErrors()) {
				Map<String,Object> map=new HashMap();
				List<FieldError> errors = result.getFieldErrors();
				for(FieldError fieldError:errors) {
					map.put(fieldError.getField(),fieldError.getDefaultMessage());
				}
				return Msg.failed().add("errorFiledMap", map);
			}else {
				user.setUpdated(new Date());
				userService.updateUser(user);
				return Msg.success();
			}
		}

}
