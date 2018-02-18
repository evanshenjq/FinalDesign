package zstu.sjq.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import zstu.sjq.bean.BsBook;
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
	
	@RequestMapping("/getBookCats")
	@ResponseBody
	public Msg getBookCats(@RequestParam(value="pn",defaultValue="1")Integer pn) {
		//每页大小
		PageHelper.startPage(pn,10);
		List<BsBookCat> list=bookCatService.selectAll();
		//连续显示页码
		PageInfo<BsBookCat> page = new PageInfo<BsBookCat>(list,5);
				
		return Msg.success().add("cats", page);
	}
	
	@RequestMapping("/getBookCat/{id}")
	@ResponseBody
	public Msg getBookCat(@PathVariable Long id) {
		
		BsBookCat cat=bookCatService.getBookCat(id);
		return Msg.success().add("cat", cat);
	}
	
	@RequestMapping("/addBookCat")
	@ResponseBody
	public Msg addBookCat(HttpServletRequest request) {
		
		BsBookCat cat=new BsBookCat();
		cat.setName(request.getParameter("name"));
		
		bookCatService.addBookCat(cat);
		
		return Msg.success();
	
	}
	
	@RequestMapping("/updateBookCat")
	@ResponseBody
	public Msg updateBookCat(HttpServletRequest request) {
		
		BsBookCat cat=new BsBookCat();
		cat.setId(Long.valueOf(request.getParameter("id")));
		cat.setName(request.getParameter("name"));
		
		bookCatService.updateBookCat(cat);
		
		return Msg.success();
	}
	
	@RequestMapping("/deleteBookCat/{id}")
	@ResponseBody
	public Msg deleteBookCat(@PathVariable Long id) {
		try {
			bookCatService.deleteBookCat(id);
			return Msg.success().add("mes", "删除成功！");
		} catch (Exception e) {
			return Msg.success().add("mes", "存在有关类目的书籍！删除失败");
		}
	}
	

}
