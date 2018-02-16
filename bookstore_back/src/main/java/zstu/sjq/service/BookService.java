package zstu.sjq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsBook;

@Service
public interface BookService {

	public List<BsBook> selectAll();
	
	public void addBook(BsBook book);
	
	public void deleteBook(long bookId);
	
	public void updateBook(BsBook book);

}
