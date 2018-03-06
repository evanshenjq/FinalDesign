package zstu.sjq.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zstu.sjq.bean.BsBook;
import zstu.sjq.bean.BsUserCart;
import zstu.sjq.bean.BsUserCartDetailItem;
import zstu.sjq.bean.BsUserCartItem;
import zstu.sjq.bean.Msg;
import zstu.sjq.service.BookService;
import zstu.sjq.service.CartItemService;
import zstu.sjq.service.CartService;
import zstu.sjq.utils.IDUtils;

@Controller
public class CartController {
	
	@Autowired
	CartService cartService;
	@Autowired
	CartItemService cartItemService;
	@Autowired
	BookService bookService;
	
	
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
		
		List<BsUserCartItem> items=cartItemService.getCartItemByCartId(cartId);
		
		List<BsUserCartDetailItem> list=new ArrayList<BsUserCartDetailItem>();
		
		for(BsUserCartItem i : items) {
			BsUserCartDetailItem item=new BsUserCartDetailItem();
			item.setId(i.getId());
			item.setCartId(i.getCartId());
			item.setNum(i.getNum());
			BsBook book=bookService.getBook(i.getBookId());
			item.setBookId(book.getId());
			item.setName(book.getName());
			item.setPublish(book.getPublish());
			item.setPrice(book.getPrice());
			item.setBookNum(book.getNum());
			item.setImage(book.getImage());
			
			list.add(item);
		}
		
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
