package zstu.sjq.controller;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

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
	public Msg updateUser(BsUser user) {
		
		user.setUpdated(new Date());
		
		userService.updateUser(user);
			
		return Msg.success();
	}
		
	//根据ID得到用户信息
	@RequestMapping("/getUserById/{id}")
	@ResponseBody
	public Msg getUserById(@PathVariable long id) {
		
		BsUser user=userService.getUserById(id);
		
		return Msg.success().add("user", user);
		
	}
	
	//得到所有用户信息
	@RequestMapping("/getAllUsers")
	@ResponseBody
	public Msg getAllUsers(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		
		//每页大小
		PageHelper.startPage(pn,10);
		List<BsUser> list=userService.getAllUsers();
		//连续显示页码
		PageInfo<BsUser> page = new PageInfo<BsUser>(list,5);
				
		return Msg.success().add("users",page);
	}

	@RequestMapping("/getUserByIdPage/{id}")
	@ResponseBody
	public Msg getUserByIdPage(@PathVariable long id,@RequestParam(value="pn",defaultValue="1")Integer pn) {

		PageHelper.startPage(pn,10);
		List<BsUser> list=new ArrayList<>();
		list.add(userService.getUserById(id));
		PageInfo<BsUser> page = new PageInfo<BsUser>(list,5);
		return Msg.success().add("users", page);

	}

	//得到所有用户信息
	@RequestMapping("/getUsersByNamePage/{name}")
	@ResponseBody
	public Msg getUsersByNamePage(@PathVariable String name,@RequestParam(value="pn",defaultValue="1")Integer pn) {

		//每页大小
		PageHelper.startPage(pn,10);
		List<BsUser> list=userService.getUsersByName(name);
		//连续显示页码
		PageInfo<BsUser> page = new PageInfo<BsUser>(list,5);

		return Msg.success().add("users",page);
	}


}
