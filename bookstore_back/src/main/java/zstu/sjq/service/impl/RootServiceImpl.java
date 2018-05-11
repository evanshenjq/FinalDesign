package zstu.sjq.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zstu.sjq.bean.BsRoot;

import zstu.sjq.bean.BsRootExample;
import zstu.sjq.dao.BsRootMapper;
import zstu.sjq.service.RootService;

import java.util.List;

@Service
public class RootServiceImpl implements RootService {

    @Autowired
    BsRootMapper rootMapper;

    @Override
    public BsRoot loginUser(String username, String password) {
        BsRootExample example=new BsRootExample();
        BsRootExample.Criteria criteria=example.createCriteria();
        criteria.andRUsernameEqualTo(username);
        criteria.andRPasswordEqualTo(password);
        List<BsRoot> list=rootMapper.selectByExample(example);
        if(list.size()!=0) {
            BsRoot user=list.get(0);
            return user;
        }else {
            return null;
        }
    }
}
