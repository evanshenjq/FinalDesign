package zstu.sjq.service;


import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsUserCart;

@Service
public interface CartService {
	
	public BsUserCart getCartByUserId(long id);
	
	public void addCartByUserId(BsUserCart userCart);

}
