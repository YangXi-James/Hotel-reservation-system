package com.example.springboot.controller;

import com.example.springboot.model.User;
import com.example.springboot.service.UserinformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserInformationConroller {
    @Autowired
    UserinformationService updatauserinformationService;

    @ResponseBody
    @PostMapping("/updateinformation")
    public void Updatauserinformation(User user, HttpServletRequest request){
        updatauserinformationService.updateinformation(user,request);
    }

    @ResponseBody
    @PostMapping("/getallinformation")
    public User getuserinformation(HttpServletRequest request){
        return   updatauserinformationService.getuserinformation(request);
    }
}



