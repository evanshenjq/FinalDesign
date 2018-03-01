package zstu.sjq.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zstu.sjq.bean.BsUserCart;
import zstu.sjq.bean.Msg;
import zstu.sjq.service.CartService;
import zstu.sjq.utils.IDUtils;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	
	@RequestMapping("/addUserCart")
	@ResponseBody
	public Msg addUserCart(HttpServletRequest request) {
		
		BsUserCart userCart=new BsUserCart();
		userCart.setId(IDUtils.genRandomId());
		userCart.setUserId(Long.valueOf(request.getParameter("userId")));
		cartService.addCartByUserId(userCart);
		return Msg.success();
		
	}
	
	@RequestMapping("/getCart/{userId}")
	@ResponseBody
	public Msg getCartByUserId(@PathVariable long userId) {
		
		BsUserCart cart=cartService.getCartByUserId(userId);
		
		return Msg.success().add("cart", cart);
	}

}
