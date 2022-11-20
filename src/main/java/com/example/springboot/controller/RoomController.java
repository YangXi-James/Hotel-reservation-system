package com.example.springboot.controller;

import com.example.springboot.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RoomController {
    @Autowired
    RoomService roomService;

    @GetMapping("/getRoomCount")
    @ResponseBody
    public Integer getUserCount()
    {
        int count=roomService.getRoomCount();
        /*   return Result.success(count,"操作成功",200);*/
        return count;
    }


}
