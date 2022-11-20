package com.example.springboot.controller;
import com.example.springboot.model.*;
import com.example.springboot.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;




@Controller
public class RegionController {

    @Autowired
    RegionService regionService;


    @ResponseBody
    @RequestMapping("/findCountry")
    public List findCountry(){
        return regionService.findCountry();
    }

    //二级联动地区
    @ResponseBody
    @RequestMapping("/findProvince")
    public List<Province> findProvince(Integer country_id) {
        return regionService.findProvince(country_id);
    }

    //三级联动
    @ResponseBody
    @RequestMapping("/findCity")
    public List<City> findCity(Integer province_id){
        return regionService.findCity(province_id);
    }

    //四级联动
    @ResponseBody
    @RequestMapping("/findDistinction")
    public List<Distinction> findDistinction(Integer city_id){
        return regionService.findDistinction(city_id);
    }

    //五级联动
    @ResponseBody
    @RequestMapping("/findHotel")
    public List<Hotel> findHotel(Integer distinct_id){
        return regionService.findHotel(distinct_id);
    }

    @ResponseBody
    @RequestMapping("/findHotelname")
    public List<Hotel> findHotelname(String hotelname){ return regionService.findHotelname(hotelname); }

    @ResponseBody
    @RequestMapping("/findStandard")
    public List<Standard> findStandard(HttpServletRequest request) throws InterruptedException {
        return regionService.findStandard(request);
    }

    @ResponseBody
    @RequestMapping("/sendHotel")
    public void sendhotel(int hotel_id,HttpServletRequest request){
         regionService.sendhotel_id(hotel_id,request);
    }

    @ResponseBody
    @RequestMapping("/findallhotel")
    public List<Hotel> findallhotel(){
        return regionService.findallhotel();
    }

    @ResponseBody
    @RequestMapping("/getweatherlogin")
    public int findweatherlogin(HttpServletRequest request){
        return regionService.weatherlogin(request);
    }

    @ResponseBody
    @RequestMapping("/cancellogin")
    public void cancellogin(HttpServletRequest request){
         regionService.cancellogin(request);
    }
}
