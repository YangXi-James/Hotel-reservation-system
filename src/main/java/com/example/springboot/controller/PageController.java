package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
    @RequestMapping("/page/{path}")
    public String toPage1(@PathVariable("path") String p){
        return "/views/"+p;
    }


    @RequestMapping("/page/backStage")
    public String toPage2(){
        return "/backStage";
    }

    //todo：后台管理系统首页
    @RequestMapping("/backstage")
    public String toIndex(){
        return "/backStage";
    }
}
