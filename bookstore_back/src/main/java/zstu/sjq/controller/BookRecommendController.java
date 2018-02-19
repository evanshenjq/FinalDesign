package zstu.sjq.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zstu.sjq.bean.BsBook;
import zstu.sjq.bean.BsBookHot;
import zstu.sjq.bean.BsBookNew;
import zstu.sjq.bean.Msg;
import zstu.sjq.service.BookHotService;
import zstu.sjq.service.BookNewService;
import zstu.sjq.service.BookService;

@Controller
public class BookRecommendController {
	
	@Autowired
	BookHotService bookHotService;
	@Autowired
	BookNewService bookNewService;
	@Autowired
	BookService bookService;
	
	@RequestMapping("/getNewBooksId")
	@ResponseBody
	public Msg getNewBooksId() {
		
		List<BsBookNew> list=bookNewService.getNewBooksId();
		
		return Msg.success().add("newBookId", list);
		
	}
	
	@RequestMapping("/getHotBooksId")
	@ResponseBody
	public Msg getHotBooksId() {
		
		List<BsBookHot> list=bookHotService.getHotBooksId();
		
		return Msg.success().add("hotBookId", list);
		
	}
	
	
	@RequestMapping("/getNewBooks")
	@ResponseBody
	public Msg getNewBooks() {
		
		List<BsBookNew> list=bookNewService.getNewBooksId();
		
		List<BsBook> books=new ArrayList<BsBook>();
		
		for(BsBookNew bookNew:list) {
			
			books.add(bookService.getBook(bookNew.getBookId()));
			
		}
		
		return Msg.success().add("newBooks", books);
		
	}
	
	@RequestMapping("/getHotBooks")
	@ResponseBody
	public Msg getHotBooks() {
		
		List<BsBookHot> list=bookHotService.getHotBooksId();
		
		List<BsBook> books=new ArrayList<BsBook>();
		
		for(BsBookHot bookHot:list) {
			
			books.add(bookService.getBook(bookHot.getBookId()));
			
		}
		
		return Msg.success().add("hotBooks", books);
	}
	
	@RequestMapping("/updateNewBookId")
	@ResponseBody
	public Msg updateNewBookId(HttpServletRequest request) {
		BsBookNew bsBookNew=new BsBookNew();
		bsBookNew.setId(Long.valueOf(request.getParameter("id")));
		bsBookNew.setBookId(Long.valueOf(request.getParameter("newBook")));
		
		bookNewService.updateNewBookId(bsBookNew);
		
		return Msg.success();
		
	}
	
	@RequestMapping("/updateHotBookId")
	@ResponseBody
	public Msg updateHotBookId(HttpServletRequest request) {
		BsBookHot bsBookHot=new BsBookHot();
		bsBookHot.setId(Long.valueOf(request.getParameter("id")));
		bsBookHot.setBookId(Long.valueOf(request.getParameter("hotBook")));
		
		bookHotService.updateHotBookId(bsBookHot);
		
		return Msg.success();
	}


}
