package com.example.springboot.controller;



import com.example.springboot.model.User;

import com.example.springboot.common.*;
import com.example.springboot.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {

    @RequestMapping(value = "/toPage",method = RequestMethod.GET)
    public String toPage(HttpServletRequest request){
        String url = request.getParameter("url");
        return url;
    }

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String goLogin(){
        return "loginForm";
    }


    @RequestMapping(value = "/getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            Validcode randomValidateCode = new Validcode();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            System.out.println("失败");
        }
    }

    /**
     * 登录
     * @param user 将登录的参数-email、pwd、indentity 封装到User
     * @return
     */
    @ResponseBody
    @PostMapping("/login")
    public Object login(User user,HttpServletRequest request){
        return loginService.login(user,request);
    }
}


