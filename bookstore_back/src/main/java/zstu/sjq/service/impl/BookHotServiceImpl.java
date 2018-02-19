package zstu.sjq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zstu.sjq.bean.BsBookHot;
import zstu.sjq.dao.BsBookHotMapper;
import zstu.sjq.service.BookHotService;

@Service
public class BookHotServiceImpl implements BookHotService {
	
	@Autowired
	BsBookHotMapper bsBookHotMapper;

	@Override
	public List<BsBookHot> getHotBooksId() {
		return bsBookHotMapper.selectByExample(null);
	}

	@Override
	public void updateHotBookId(BsBookHot bsBookHot) {
		
		bsBookHotMapper.updateByPrimaryKey(bsBookHot);

	}

}
