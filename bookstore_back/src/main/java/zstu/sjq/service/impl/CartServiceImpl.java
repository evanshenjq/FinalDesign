package zstu.sjq.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsUserCart;
import zstu.sjq.bean.BsUserCartExample;
import zstu.sjq.bean.BsUserCartExample.Criteria;
import zstu.sjq.dao.BsUserCartMapper;
import zstu.sjq.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	BsUserCartMapper bsUserCartMapper;

	@Override
	public BsUserCart getCartByUserId(long id) {
		
		BsUserCartExample example=new BsUserCartExample();
		Criteria criteria=example.createCriteria();
		criteria.andUserIdEqualTo(id);
		return bsUserCartMapper.selectByExample(example).get(0);
	}

	@Override
	public void addCartByUserId(BsUserCart userCart) {
		bsUserCartMapper.insert(userCart);
		
	}

}
