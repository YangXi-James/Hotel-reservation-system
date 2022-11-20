package com.example.springboot.service;

import com.example.springboot.mapper.RegionMapper;
import com.example.springboot.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Slf4j
@Service
public class RegionService {
    public static final String HOTELKEY= "HOTELKEYIDIT";//放到session中的key
    @Autowired
    RegionMapper regionMapper;

    public List<Country> findCountry(){
        List<Country> country=regionMapper.findCountry();
        return country;
    }

    public List findProvince(int country_id){
        List<Province> province=regionMapper.findProvince(country_id);
        return province;
    }

    public List findCity(int Province_id){
        List<City> city=regionMapper.findCity(Province_id);
        return city;
    }

    public List findDistinction(int City_id){
        List<Distinction> distinction=regionMapper.findDistinction(City_id);
        return distinction;
    }

    public List<Hotel> findHotel(Integer Distinction_id) {
        List<Hotel> hotel=regionMapper.findHotel(Distinction_id);
        return hotel;
    }

    public List<Hotel> findHotelname(String hotelname) {
        List<Hotel> hotel=regionMapper.findHotelname(hotelname);
        return hotel;
    }

    public void sendhotel_id(int hotel_id,HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute(HOTELKEY, hotel_id);
    }
    public List<Standard> findStandard(HttpServletRequest request) throws InterruptedException {
        HttpSession session = request.getSession();
        Thread.sleep(100);
       int hotel_id=(int)session.getAttribute("HOTELKEYIDIT");
        List<Standard> standard=regionMapper.findStandard(hotel_id);
        return standard;
    }

    public List<Hotel> findallhotel() {
        List<Hotel> hotel=regionMapper.findallhotel();
        return hotel;
    }

    public int weatherlogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute("LOGINPASSWORD")!=null) {
           return 1;
        }
        else {
           return 0;
        }
    }

    public void cancellogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("LOGINPASSWORD");
    }
}
