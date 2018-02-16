package zstu.sjq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import zstu.sjq.bean.BsBook;
import zstu.sjq.bean.Msg;
import zstu.sjq.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	//得到所有书
	@RequestMapping("/getAllBooks")
	@ResponseBody
	public Msg getAllBooks(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		
		//每页大小
		PageHelper.startPage(pn,10);
		List<BsBook> list=bookService.selectAll();
		//连续显示页码
		PageInfo<BsBook> page = new PageInfo<BsBook>(list,5);
		
		return Msg.success().add("books",page);
	}

}
