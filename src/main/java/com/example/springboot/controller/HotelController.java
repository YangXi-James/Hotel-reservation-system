package com.example.springboot.controller;

import com.example.springboot.common.domain.Hotel;
import com.example.springboot.common.domain.User;
import com.example.springboot.common.utils.PageUtil;
import com.example.springboot.common.utils.Result;
import com.example.springboot.dto.ResultDTO;
import com.example.springboot.exception.CustomizeErrorCode;
import com.example.springboot.service.HotelService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
public class HotelController {
    @Autowired
    HotelService hotelSrvice;

    @RequestMapping("/hotelList")
    @ResponseBody //加上这个才是会默认返回数据
    public Object getHotleList(Hotel hotel, @RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="10")  int pageSize)
    {
        PageInfo<Hotel> hotelPageInfo=hotelSrvice.findPartUserHotel(pageNo,pageSize,hotel);
        return Result.success(hotelPageInfo);
    }
    @RequestMapping("/exportHotelList")
    @ResponseBody //加上这个才是会默认返回数据
    public PageUtil<Hotel> getAllHotleList()
    {
        PageUtil<Hotel> hotelPageUtil =new PageUtil<>();
        hotelPageUtil.setData(hotelSrvice.getAllHotelList());

        return hotelPageUtil ;
    }



    @RequestMapping("/showHotelStandradDetial")
        public String showHotelStandrad(ModelMap modelMap, Integer hotelId){
        Hotel hotel = hotelSrvice.findHotelById(hotelId);
        modelMap.put("hotel",hotel);
        return "/views/showHotelStandradDetial";
    }
    @RequestMapping("/showHotelDetial")
    public String showHotelDetial(ModelMap modelMap, Integer id){
        Hotel hotel = hotelSrvice.findHotelById(id);
        modelMap.put("hotel",hotel);
        return "/views/showHotelDetial";
    }
@GetMapping("/getHotelCount")
@ResponseBody
public Integer getHotelCount()
{
    int count=hotelSrvice.getHotelCount();
    /*   return Result.success(count,"操作成功",200);*/
    return count;
}

    @RequestMapping("/submintUpdatedHotel")
    @ResponseBody
    public Object showUpdateHotel(@RequestBody Hotel hotel){
        int count = hotelSrvice.updateHotel(hotel);
        return Result.success(count,"操作成功",200);
    }
    @RequestMapping("/addHotelAction")
    @ResponseBody
    public Object addHotel(@RequestBody Hotel hotel){
        int count = hotelSrvice.addHotel(hotel);
        return Result.success(count,"操作成功",200);
    }

    @RequestMapping("/deleteHotel")
    @ResponseBody
    public Object deleteHote(@RequestBody Integer[] ids)
    {

       try{
           int count=hotelSrvice.deleteHotelById(ids);
           return Result.success(count,"操作成功",200);
       }
       catch (Exception e)
       {
           return ResultDTO.errorInfo(CustomizeErrorCode.DELETE_HOTEL_ERROR);
       }

    }



}


