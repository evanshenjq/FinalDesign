package zstu.sjq.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import zstu.sjq.bean.BsBook;
import zstu.sjq.bean.Msg;
import zstu.sjq.service.BookService;
import zstu.sjq.service.ImageService;
import zstu.sjq.utils.IDUtils;

@Controller
@PropertySource({"classpath:resource.properties"})
public class BookController {
	
	@Autowired
	BookService bookService;
	@Autowired
	ImageService imageService;
	
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
	
	//添加书籍
	@RequestMapping(value ="/addBook",method = { RequestMethod.POST})
	@ResponseBody
	public Msg addBook(@RequestParam("image") MultipartFile image,HttpServletRequest request) {
		String imageUrl=imageService.uploadFile(image);
		BsBook bsBook=new BsBook();
		bsBook.setId(IDUtils.genRandomId());
		bsBook.setName(request.getParameter("name"));
		bsBook.setPublish(request.getParameter("publish"));
		bsBook.setPrice(Double.valueOf(request.getParameter("price")));
		bsBook.setImage(imageUrl);
		bsBook.setDescr(request.getParameter("descr"));
		bsBook.setStatus(2);
		bsBook.setNum(Long.valueOf(request.getParameter("num")));
		bsBook.setCatId(Long.valueOf(request.getParameter("catId")));
		bsBook.setCreated(new Date());
		bsBook.setUpdated(new Date());
		bookService.addBook(bsBook);
		return Msg.success();
	}
	
	@RequestMapping(value="/updateBook",method = { RequestMethod.POST})
	@ResponseBody
	public Msg updateBook(@RequestParam("image") MultipartFile image,HttpServletRequest request) {
		BsBook bsBook=new BsBook();
		if(image.getSize()!=0) {
			String imageUrl=imageService.uploadFile(image);
			bsBook.setImage(imageUrl);
		}
		bsBook.setId(Long.valueOf(request.getParameter("id")));
		bsBook.setName(request.getParameter("name"));
		bsBook.setPublish(request.getParameter("publish"));
		bsBook.setPrice(Double.valueOf(request.getParameter("price")));
		bsBook.setDescr(request.getParameter("descr"));
		bsBook.setStatus(Integer.valueOf(request.getParameter("status")));
		bsBook.setNum(Long.valueOf(request.getParameter("num")));
		bsBook.setCatId(Long.valueOf(request.getParameter("catId")));
		bsBook.setCreated(new Date(Long.valueOf(request.getParameter("created"))));
		bsBook.setUpdated(new Date());
		
		bookService.updateBook(bsBook);
		return Msg.success();
	}
	
	//下架书籍
	@RequestMapping("/deleteBook/{id}")
	@ResponseBody
	public Msg deleteBook(@PathVariable Long id) {
		try {
			bookService.deleteBook(id);
			return Msg.success().add("mes","删除成功！");
		} catch (Exception e) {
			return Msg.success().add("mes","书籍有订单关联，删除失败！");
		}
		
	}
	
	//找到单本书籍信息
	@RequestMapping("/getBookPage/{id}")
	@ResponseBody
	public Msg getBookByPage(@PathVariable Long id,@RequestParam(value="pn",defaultValue="1")Integer pn) {

		PageHelper.startPage(pn,5);
		List<BsBook> list =new ArrayList<BsBook>();
		list.add(bookService.getBook(id));
		PageInfo<BsBook> page = new PageInfo<BsBook>(list,5);
		return Msg.success().add("books", page);
	}

	//找到单本书籍信息
	@RequestMapping("/getBook/{id}")
	@ResponseBody
	public Msg getBook(@PathVariable Long id) {

		BsBook book=bookService.getBook(id);

		return Msg.success().add("book", book);
	}
	
	
	//检测是否有此Id
	@RequestMapping("/hasBookId/{id}")
	@ResponseBody
	public Msg hasBookId(@PathVariable Long id) {
		
		if(bookService.hasBookId(id)) {
			return Msg.success().add("hasId", true);
		}else {
			return Msg.success().add("hasId", false);
		}
		
	}

	
	//根据分类查找
	@RequestMapping("/getOnBooksByCat/{catId}")
	@ResponseBody
	public Msg getOnBooksByCat(@PathVariable Long catId,@RequestParam(value="pn",defaultValue="1")Integer pn) {
		
		
		PageHelper.startPage(pn,5);
		List<BsBook> list=bookService.getOnBooksByCatId(catId);
		//连续显示页码
		PageInfo<BsBook> page = new PageInfo<BsBook>(list,5);
		
		return Msg.success().add("books", page);
	}


	@RequestMapping("/getBooksByName/{name}")
	@ResponseBody
	public Msg getBooksByName(@PathVariable String name,@RequestParam(value="pn",defaultValue="1")Integer pn){
		PageHelper.startPage(pn,5);
		List<BsBook> list=bookService.getBookByName(name);
		PageInfo<BsBook> page = new PageInfo<BsBook>(list,5);
		return Msg.success().add("books",page);
	}

}
