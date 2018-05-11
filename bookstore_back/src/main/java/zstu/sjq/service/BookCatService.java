package zstu.sjq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsBookCat;

@Service
public interface BookCatService {

	public List<BsBookCat> selectAll();
	
	public void addBookCat(BsBookCat bookCat);
	
	public void deleteBookCat(long bookCatId);
	
	public void updateBookCat(BsBookCat bookCat);
	
	public BsBookCat getBookCat(long bookCatId);

	public List<BsBookCat> getCatsByName(String name);

}
