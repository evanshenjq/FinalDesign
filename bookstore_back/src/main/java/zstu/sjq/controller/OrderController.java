package zstu.sjq.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import zstu.sjq.bean.*;
import zstu.sjq.service.*;
import zstu.sjq.utils.IDUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    OrderItemService orderItemService;

    @Autowired
    OrderService orderService;

    @Autowired
    CartItemService cartItemService;

    @Autowired
    CartService cartService;

    @Autowired
    BookService bookService;

    @RequestMapping("/addOrder")
    @ResponseBody
    public Msg addOrder(HttpServletRequest request){
        //table order function
        Long userId=Long.valueOf(request.getParameter("userId"));
        String orderName=request.getParameter("orderName");
        String orderPhone=request.getParameter("orderPhone");
        String orderAddress=request.getParameter("orderAddress");
        Double total=Double.valueOf(request.getParameter("total"));
        Long orderId=IDUtils.genRandomId();
        BsOrder order=new BsOrder();
        order.setId(orderId);
        order.setUserId(userId);
        order.setUserName(orderName);
        order.setUserPhone(orderPhone);
        order.setUserAddress(orderAddress);
        order.setStatus(3);
        order.setTotal(total);
        order.setCreated(new Date());
        orderService.addOrder(order);

        //table order item function
        BsUserCart cart=cartService.getCartByUserId(userId);
        List<BsUserCartItem> list=cartItemService.getCartItemByCartId(cart.getId());
        for(BsUserCartItem cartItem : list){
            BsOrderItem orderItem=new BsOrderItem();
            orderItem.setId(IDUtils.genRandomId());
            orderItem.setOrderId(orderId);
            Long bookId=cartItem.getBookId();
            orderItem.setBookId(bookId);
            orderItem.setNum(Integer.parseInt(String.valueOf(cartItem.getNum())));
            orderItemService.addOrderItem(orderItem);
            BsBook book=bookService.getBook(bookId);
            book.setNum(book.getNum()-cartItem.getNum());
            bookService.updateBook(book);
            //clean cart
            cartItemService.deleteCartItem(cartItem.getId());
        }

        return Msg.success();

    }

    @RequestMapping("/updateOrder")
    @ResponseBody
    public Msg updateOrder(HttpServletRequest request){
        return Msg.success();
    }

    @RequestMapping("/getOrder/{id}")
    @ResponseBody
    public Msg getOrderByUserId(@PathVariable Long id,@RequestParam(value="pn",defaultValue="1")Integer pn){

        PageHelper.startPage(pn,10);
        List<BsOrder> list=orderService.getOrderByUserId(id);
        PageInfo<BsOrder> page = new PageInfo<BsOrder>(list,5);

        return Msg.success().add("orders",page);
    }

    @RequestMapping("/getAllOrder")
    @ResponseBody
    public Msg getAllOrder(@RequestParam(value="pn",defaultValue="1")Integer pn){
        PageHelper.startPage(pn,10);
        List<BsOrder> list=orderService.getAllOrder();
        PageInfo<BsOrder> page = new PageInfo<BsOrder>(list,5);

        return Msg.success().add("orders",page);
    }
}
