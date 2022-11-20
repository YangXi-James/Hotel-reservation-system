package com.example.springboot.controller;

import com.example.springboot.common.domain.Hotel;
import com.example.springboot.common.domain.Standard;
import com.example.springboot.common.domain.User;
import com.example.springboot.common.utils.Result;
import com.example.springboot.dto.ResultDTO;
import com.example.springboot.exception.CustomizeErrorCode;
import com.example.springboot.service.HotelService;
import com.example.springboot.service.StandardService;
import com.github.pagehelper.PageInfo;
import org.apache.catalina.core.StandardServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.locks.StampedLock;

@Controller
public class StrandradController {
    @Autowired(required = false)
    StandardService standardService;

    //数据接口，返回数据
    @RequestMapping("/standardList")
    @ResponseBody //加上这个才是会默认返回数据
    public Object getStandardList(Standard standard, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        PageInfo<Standard> hotelPageInfo = standardService.findPartStandrad(standard, pageNo, pageSize);
        return Result.success(hotelPageInfo);
    }

    //数据接口，返回数据
    @RequestMapping("/hotelStandardList")
    @ResponseBody //加上这个才是会默认返回数据
    public Object getHotelStandardList(Integer hotelId, @RequestParam(defaultValue = "1") int pageNo, @RequestParam(defaultValue = "10") int pageSize) {
        PageInfo<Standard> hotelPageInfo = standardService.findHotelPartStandrad(hotelId, pageNo, pageSize);
        return Result.success(hotelPageInfo);
    }



    @RequestMapping("/updateStandradQuest")
    public String updateStandrad(ModelMap modelMap, Integer id) {
        Standard standard = standardService.findStandradByID(id);
        modelMap.put("standrad", standard);
        return "views/updateStandrad";
    }

    @RequestMapping("/submintUpdatedStandrad")
    @ResponseBody
    public Object showUpdateStandrad(@RequestBody Standard standard) {
        int count = standardService.updateStandrad(standard);
        return Result.success(count, "操作成功", 200);
    }

    @RequestMapping("/deleteStandrad")
    @ResponseBody
    public Object deleteUsers(@RequestBody Integer[] ids) {
        try {
            int count = standardService.deleteStandradsById(ids);
            return Result.success(count, "操作成功", 200);
        } catch (Exception e) {
            return ResultDTO.errorInfo(CustomizeErrorCode.DELETE_Standrad_ERROR);
        }


    }

    @RequestMapping("/addStandrad")
    @ResponseBody
    public Object addStandrad(@RequestBody Standard standard){
        int count = standardService.addStandrad(standard);
        return Result.success(count,"操作成功",200);
    }


    @GetMapping("/getStandradCount")
    @ResponseBody
    public Integer getStandradCount()
    {
        int count=standardService.getStandradCount();
        /*   return Result.success(count,"操作成功",200);*/
        return count;
    }

}
