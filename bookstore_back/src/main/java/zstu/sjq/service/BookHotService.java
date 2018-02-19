package zstu.sjq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsBookHot;

@Service
public interface BookHotService {
	
	public List<BsBookHot> getHotBooksId();
	
	public void updateHotBookId(BsBookHot bsBookHot);

}
