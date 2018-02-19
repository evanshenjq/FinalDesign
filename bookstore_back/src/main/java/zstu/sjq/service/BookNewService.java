package zstu.sjq.service;

import java.util.List;

import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsBookNew;

@Service
public interface BookNewService {
	
	public List<BsBookNew> getNewBooksId();
	
	public void updateNewBookId(BsBookNew bsBookNew);
	
}
