package com.xmut.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author
 * @date: 2024/1/4
 **/
@Controller
public class RouterController {


    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping({"/toLogin"})
    public String toLogin(){
        return "login.html";
    }

    @RequestMapping({"/emp"})
    public String toList(){
        return "emp/list.html";
    }
    @RequestMapping({"/level1/{id}"})
    public String level1(@PathVariable("id") int id){
        return "views/level1/"+id;
    }

    @RequestMapping({"/level2/{id}"})
    public String level2(@PathVariable("id") int id){
        return "views/level2/"+id;
    }

    @RequestMapping({"/level3/{id}"})
    public String level3(@PathVariable("id") int id){
        return "views/level3/"+id;
    }

}
