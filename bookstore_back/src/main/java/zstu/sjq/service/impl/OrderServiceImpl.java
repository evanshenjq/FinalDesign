package zstu.sjq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsOrder;
import zstu.sjq.bean.BsOrderExample;
import zstu.sjq.bean.BsOrderExample.Criteria;
import zstu.sjq.dao.BsOrderMapper;
import zstu.sjq.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	BsOrderMapper orderMapper;

	@Override
	public void addOrder(BsOrder order) {
		orderMapper.insert(order);
	}

	@Override
	public void updateOrder(BsOrder order) {
		orderMapper.updateByPrimaryKeySelective(order);
	}

	@Override
	public List<BsOrder> getOrderByUserId(long userId) {
		
		BsOrderExample example=new BsOrderExample();
		Criteria c=example.createCriteria();
		c.andUserIdEqualTo(userId);
		return orderMapper.selectByExample(example);
	}

	@Override
	public List<BsOrder> getAllOrder() {
		return orderMapper.selectByExample(null);
	}

	@Override
	public BsOrder getOrderById(long orderId) {
		return orderMapper.selectByPrimaryKey(orderId);
	}

}
