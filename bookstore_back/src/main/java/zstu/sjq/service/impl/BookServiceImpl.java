package zstu.sjq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsBook;
import zstu.sjq.bean.BsBookExample;
import zstu.sjq.bean.BsBookExample.Criteria;
import zstu.sjq.dao.BsBookMapper;
import zstu.sjq.service.BookService;
@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BsBookMapper bsBookMapper;

	@Override
	public List<BsBook> selectAll() {
		List<BsBook> list=bsBookMapper.selectByExample(null);
		return list;
	}

	@Override
	public void addBook(BsBook book) {
		bsBookMapper.insertSelective(book);
	}

	@Override
	public void deleteBook(long bookId) {
		bsBookMapper.deleteByPrimaryKey(bookId);
	}

	@Override
	public void updateBook(BsBook book) {
		bsBookMapper.updateByPrimaryKeySelective(book);
	}

	
	@Override
	public BsBook getBook(long bookId) {
		return bsBookMapper.selectByPrimaryKey(bookId);
	}
	
	//获得所有上架的书籍
	@Override
	public List<BsBook> getAllOnBooks() {
		BsBookExample example=new BsBookExample();
		Criteria criteria=example.createCriteria();
		criteria.andStatusEqualTo(1);
		return bsBookMapper.selectByExample(example);
	}

}
