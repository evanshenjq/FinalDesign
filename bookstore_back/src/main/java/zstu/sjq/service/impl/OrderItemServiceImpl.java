package zstu.sjq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsOrderItem;
import zstu.sjq.bean.BsOrderItemExample;
import zstu.sjq.bean.BsOrderItemExample.Criteria;
import zstu.sjq.dao.BsOrderItemMapper;
import zstu.sjq.service.OrderItemService;
@Service
public class OrderItemServiceImpl implements OrderItemService {
	
	@Autowired
	BsOrderItemMapper orderItemMapper;

	@Override
	public void addOrderItem(BsOrderItem orderItem) {
		orderItemMapper.insert(orderItem);
	}

	@Override
	public List<BsOrderItem> getOrderItemByOrderId(long orderId) {
		
		BsOrderItemExample example=new BsOrderItemExample();
		Criteria c=example.createCriteria();
		c.andOrderIdEqualTo(orderId);
		return orderItemMapper.selectByExample(example);
	}

}
