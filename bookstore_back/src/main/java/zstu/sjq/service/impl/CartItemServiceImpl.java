package zstu.sjq.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsUserCartItem;
import zstu.sjq.bean.BsUserCartItemExample;
import zstu.sjq.bean.BsUserCartItemExample.Criteria;
import zstu.sjq.bean.Msg;
import zstu.sjq.dao.BsUserCartItemMapper;
import zstu.sjq.service.CartItemService;
@Service
public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	BsUserCartItemMapper bsUserCartItemMapper;

	@Override
	public List<BsUserCartItem> getCartItemByCartId(long id) {
		
		BsUserCartItemExample example=new BsUserCartItemExample();
		Criteria criteria=example.createCriteria();
		criteria.andCartIdEqualTo(id);
		
		List<BsUserCartItem> list=bsUserCartItemMapper.selectByExample(example);
		
		return list;
	}

	@Override
	public void updateCartItem(BsUserCartItem cartItem) {

		bsUserCartItemMapper.updateByPrimaryKey(cartItem);

	}

	@Override
	public void addCartItem(BsUserCartItem cartItem) {

		bsUserCartItemMapper.insertSelective(cartItem);
	}

	@Override
	public void deleteCartItem(long id) {
		
		bsUserCartItemMapper.deleteByPrimaryKey(id);

	}

}
