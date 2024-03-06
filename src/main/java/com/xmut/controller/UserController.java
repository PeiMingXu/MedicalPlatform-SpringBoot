package com.xmut.controller;

import com.xmut.pojo.User;
import com.xmut.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * @author
 * @date: 2024/1/7 16:38
 **/
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/login")
    public String login(User user,Model model, HttpSession session){
        //调用service
        User dbUser = userService.login(user);
        System.out.println("dbUser==" + dbUser);

        //登陆验证
        if (dbUser!=null){
            session.setAttribute("loginUser",dbUser);
            return "redirect:/index.html";
        }else {
            //登陆失败，告诉用户
            model.addAttribute("msg","用户或者密码错误");
            return "login";
        }
    }

}
