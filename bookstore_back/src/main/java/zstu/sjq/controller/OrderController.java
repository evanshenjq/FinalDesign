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
import java.util.ArrayList;
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
            book.setSell(Integer.parseInt(String.valueOf(book.getSell()+cartItem.getNum())));
            bookService.updateBook(book);
            //clean cart
            cartItemService.deleteCartItem(cartItem.getId());
        }

        return Msg.success();

    }

    @RequestMapping("/updateOrder")
    @ResponseBody
    public Msg updateOrder(HttpServletRequest request){
        long orderId=Long.valueOf(request.getParameter("orderId"));
        int orderStatus=Integer.valueOf(request.getParameter("orderStatus"));
        BsOrder order=new BsOrder();
        order.setId(orderId);
        order.setStatus(orderStatus);
        orderService.updateOrder(order);
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

    @RequestMapping("/getUserOrderItem/{orderId}")
    @ResponseBody
    public Msg getUserCartItemByCartId(@PathVariable long orderId) {

        List<BsOrderItem> items=orderItemService.getOrderItemByOrderId(orderId);

        List<BsOrderDetailItem> list=new ArrayList<>();

        for(BsOrderItem i : items) {
            BsOrderDetailItem item=new BsOrderDetailItem();
            item.setId(i.getId());
            item.setOrderId(i.getOrderId());
            item.setNum(i.getNum());
            BsBook book=bookService.getBook(i.getBookId());
            item.setBookId(book.getId());
            item.setName(book.getName());
            item.setPublish(book.getPublish());
            item.setPrice(book.getPrice());
            item.setImage(book.getImage());

            list.add(item);
        }

        BsOrder order=orderService.getOrderById(orderId);

        return Msg.success().add("orderItems", list).add("order",order);
    }

    @RequestMapping("/getOrderById/{id}")
    @ResponseBody
    public Msg getOrderById(@PathVariable long id){

        BsOrder order=orderService.getOrderById(id);

        return Msg.success().add("order",order);
    }
}
