package zstu.sjq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import zstu.sjq.bean.BsBookCat;
import zstu.sjq.bean.Msg;
import zstu.sjq.service.BookCatService;

@Controller
public class BookCatController {
	
	@Autowired
	BookCatService bookCatService;
	
	@RequestMapping("/getBookCatsNoPage")
	@ResponseBody
	public Msg getBookCatsNoPage() {
		
		List<BsBookCat> list=bookCatService.selectAll();
		
		return Msg.success().add("cats", list);
		
	}
	
	

}
