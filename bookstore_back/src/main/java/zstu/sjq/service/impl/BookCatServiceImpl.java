package zstu.sjq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsBookCat;
import zstu.sjq.dao.BsBookCatMapper;
import zstu.sjq.service.BookCatService;
@Service
public class BookCatServiceImpl implements BookCatService {
	
	@Autowired
	BsBookCatMapper bsBookCatMapper;

	@Override
	public List<BsBookCat> selectAll() {
		
		List<BsBookCat> list=bsBookCatMapper.selectByExample(null);
		
		return list;
	}

	@Override
	public void addBookCat(BsBookCat bookCat) {

		bsBookCatMapper.insertSelective(bookCat);
	}

	@Override
	public void deleteBookCat(long bookCatId) {
		bsBookCatMapper.deleteByPrimaryKey(bookCatId);
	}

	@Override
	public void updateBookCat(BsBookCat bookCat) {
		bsBookCatMapper.updateByPrimaryKeySelective(bookCat);
	}

	@Override
	public BsBookCat getBookCat(long bookCatId) {
		return bsBookCatMapper.selectByPrimaryKey(bookCatId);
	}

}
