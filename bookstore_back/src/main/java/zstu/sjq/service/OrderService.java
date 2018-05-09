package zstu.sjq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsOrder;

@Service
public interface OrderService {
	
	public void addOrder(BsOrder order);
	
	public void updateOrder(BsOrder order);
	
	public List<BsOrder> getOrderByUserId(long userId);

	public List<BsOrder> getAllOrder();

}
