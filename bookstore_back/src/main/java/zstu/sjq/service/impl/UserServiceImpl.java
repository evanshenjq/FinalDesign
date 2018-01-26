package zstu.sjq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsUser;
import zstu.sjq.bean.BsUserExample;
import zstu.sjq.bean.BsUserExample.Criteria;
import zstu.sjq.dao.BsUserMapper;
import zstu.sjq.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	BsUserMapper bsUserMapper;

	@Override
	public BsUser loginUser(String username, String password) {
		BsUserExample example=new BsUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(username);
		criteria.andPasswordEqualTo(password);
		List<BsUser> list=bsUserMapper.selectByExample(example);
		if(list.size()!=0) {
			BsUser user=list.get(0);
			return user;
		}else {
			return null;
		}
	}

}
