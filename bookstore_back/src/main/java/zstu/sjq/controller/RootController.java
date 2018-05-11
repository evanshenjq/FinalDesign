package zstu.sjq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import zstu.sjq.bean.BsRoot;
import zstu.sjq.bean.Msg;
import zstu.sjq.service.RootService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class RootController {

    @Autowired
    RootService rootService;

    //登陆
    @RequestMapping("/loginRoot")
    @ResponseBody
    public Msg loginRoot(HttpServletRequest request) {

        BsRoot root=rootService.loginUser(request.getParameter("username"), request.getParameter("password"));
        if(root!=null) {
            return Msg.success().add("user", root);
        }else {
            return Msg.failed().add("va_msg","请输入正确的用户名或密码");
        }
    }

}
