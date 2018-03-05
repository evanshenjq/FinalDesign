package zstu.sjq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsOrderItem;

@Service
public interface OrderItemService {
	
	public void addOrderItem(BsOrderItem orderItem);
	
	public List<BsOrderItem> getOrderItemByOrderId(long orderId);
	

}
