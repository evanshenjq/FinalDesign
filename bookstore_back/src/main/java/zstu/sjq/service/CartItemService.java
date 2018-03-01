package zstu.sjq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsUserCartItem;

@Service
public interface CartItemService {
	
	public List<BsUserCartItem> getCartItemByCartId(long id);
	
	public void updateCartItem(BsUserCartItem cartItem);
	
	public void addCartItem(BsUserCartItem cartItem);
	
	public void deleteCartItem(long id);

}
