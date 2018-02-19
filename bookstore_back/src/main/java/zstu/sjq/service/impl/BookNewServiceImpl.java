package zstu.sjq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.sjq.bean.BsBookNew;
import zstu.sjq.dao.BsBookNewMapper;
import zstu.sjq.service.BookNewService;

@Service
public class BookNewServiceImpl implements BookNewService {
	
	@Autowired
	BsBookNewMapper bsBookNewMapper;

	@Override
	public List<BsBookNew> getNewBooksId() {
		
		return bsBookNewMapper.selectByExample(null);
	}

	@Override
	public void updateNewBookId(BsBookNew bsBookNew) {
		
		bsBookNewMapper.updateByPrimaryKey(bsBookNew);

	}

}
