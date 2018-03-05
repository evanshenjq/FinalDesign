package zstu.sjq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zstu.sjq.bean.BsUserCart;
import zstu.sjq.bean.BsUserCartItem;
import zstu.sjq.bean.Msg;
import zstu.sjq.service.CartItemService;
import zstu.sjq.service.CartService;
import zstu.sjq.utils.IDUtils;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	@Autowired
	CartItemService cartItemService;
	
	@RequestMapping("/addUserCart")
	@ResponseBody
	public Msg addUserCart(HttpServletRequest request) {
		
		BsUserCart userCart=new BsUserCart();
		long id=IDUtils.genRandomId();
		userCart.setId(id);
		userCart.setUserId(Long.valueOf(request.getParameter("userId")));
		cartService.addCartByUserId(userCart);
		return Msg.success().add("cartId", id);
		
	}
	
	@RequestMapping("/getCart/{userId}")
	@ResponseBody
	public Msg getCartByUserId(@PathVariable long userId) {
		try{
			
			BsUserCart cart=cartService.getCartByUserId(userId);
			return Msg.success().add("cart", cart);
			
		}catch(IndexOutOfBoundsException e) {
			return Msg.success().add("cart", null);
		}
		
	}
	
	@RequestMapping("/addUserCartItem")
	@ResponseBody
	public Msg addUserCartItrm(HttpServletRequest request) {
		
		BsUserCartItem cartItem=new BsUserCartItem();
		cartItem.setId(IDUtils.genRandomId());
		cartItem.setCartId(Long.valueOf(request.getParameter("cartId")));
		cartItem.setBookId(Long.valueOf(request.getParameter("bookId")));
		cartItem.setNum(Long.valueOf(request.getParameter("num")));
		
		cartItemService.addCartItem(cartItem);
		
		return Msg.success();
	}
	
	@RequestMapping("/getUserCartItem/{cartId}")
	@ResponseBody
	public Msg getUserCartItemByCartId(@PathVariable long cartId) {
		
		List<BsUserCartItem> list=cartItemService.getCartItemByCartId(cartId);
		
		return Msg.success().add("cartItems", list);
	}
	
	@RequestMapping("/deleteUserCartItem/{cartItemId}")
	@ResponseBody
	public Msg deleteUserCartItem(@PathVariable long cartItemId) {
		
		cartItemService.deleteCartItem(cartItemId);
		
		return Msg.success();
	}
	
	@RequestMapping("/updateUserCartItem")
	@ResponseBody
	public Msg updateUserCartItem(HttpServletRequest request) {
		
		BsUserCartItem cartItem=new BsUserCartItem();
		cartItem.setId(Long.valueOf(request.getParameter("cartItemId")));
		cartItem.setNum(Long.valueOf(request.getParameter("num")));
		
		cartItemService.updateCartItem(cartItem);
		
		return Msg.success();
	}

}
