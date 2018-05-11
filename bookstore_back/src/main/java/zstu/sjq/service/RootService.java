package zstu.sjq.service;

import org.springframework.stereotype.Service;
import zstu.sjq.bean.BsRoot;

@Service
public interface RootService {

    public BsRoot loginUser(String username, String password);

}
