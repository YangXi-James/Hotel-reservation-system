package com.example.springboot;

import com.example.springboot.mapper.UserMapper;
import com.example.springboot.model.Province;
import com.example.springboot.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

// @SpringBootTest
class SpringBootEmailApplicationTests {

    @Autowired
    JavaMailSender javaMailSender;
    @Autowired
    UserMapper userMapper;
    @Autowired
    RegionService regionService;



    // @Test
    void testit(){
//       List<Country> region= regionService.findCountry();
//       for(int i=0;i<region.size();i++)
//          System.out.println(region.get(i).getName());
        List<Province> province=regionService.findProvince(1);
        for(int i=0;i<province.size();i++)
            System.out.println(province.get(i).getProvince_name());
    }



}
