package zstu.sjq.service;

import java.util.List;

import org.springframework.stereotype.Service;


import zstu.sjq.bean.BsUser;

@Service
public interface UserService {

	public BsUser loginUser(String username,String password);
	
	public void addUser(BsUser user);
	
	//检测是否有账号
	public boolean hasUser(String username);
		
	//更改账户信息
	public void updateUser(BsUser user);
	
	//得到账户信息
	public BsUser getUserById(long id);
	
	//得到所有用户信息
	public List<BsUser> getAllUsers();

	//通过名字得到用户
	public List<BsUser> getUsersByName(String name);
	
}
