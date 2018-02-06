package zstu.sjq.service;

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
}
