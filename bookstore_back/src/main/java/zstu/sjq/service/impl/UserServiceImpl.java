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

	
	//登陆
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


	@Override
	public void addUser(BsUser user) {
		bsUserMapper.insert(user);
	}

	@Override
	public boolean hasUser(String username) {
		BsUserExample example=new BsUserExample();
		Criteria criteria=example.createCriteria();
		criteria.andUsernameEqualTo(username);
		long count=bsUserMapper.countByExample(example);
		//count==0时，证明此用户可用
		return count==0;
		
	}

	@Override
	public void updateUser(BsUser user) {
		bsUserMapper.updateByPrimaryKeySelective(user);
	}

	@Override
	public BsUser getUserById(long id) {
		return bsUserMapper.selectByPrimaryKey(id);
	}


	@Override
	public List<BsUser> getAllUsers() {
		return bsUserMapper.selectByExample(null);
	}

}
