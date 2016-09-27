package com.tkeians.controller;

import com.tkeians.Model.User;
import com.tkeians.Service.IUserService;
import com.tkeians.Service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    private IUserService service = new UserServiceImpl();

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "index";  //这么写的话访问 / 时跳转到 index.jsp
//        return "nice";   这么写的话访问 / 时跳转到 nice.jsp
    }

    @RequestMapping(value = "/toJson")
    @ResponseBody  // 有这个注解才能在输入 /toJson 时在页面显示Json数据，否则页面出错
    public User toJson(User user) {
        System.out.println("----------------" + service.findUserById(2).getId());
        System.out.println("----------------" + service.findUserById(2).getUsername());
        System.out.println("----------------" + service.findUserById(2).getPassword());
        return service.findUserById(1);
    }

    @RequestMapping(value = "nice", method = RequestMethod.GET)
    public String nice(Model model) {
        model.addAttribute("result", "It's Spring MVC Test !");
        return "nice";  // 这么写的话访问 /nice 时跳转到 nice.jsp
    }
}
