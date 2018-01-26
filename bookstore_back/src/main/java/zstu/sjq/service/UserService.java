package zstu.sjq.service;

import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsUser;

@Service
public interface UserService {

	public BsUser loginUser(String username,String password);
}
