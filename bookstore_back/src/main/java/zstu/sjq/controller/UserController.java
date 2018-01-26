package zstu.sjq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zstu.sjq.bean.*;
import zstu.sjq.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
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

}
