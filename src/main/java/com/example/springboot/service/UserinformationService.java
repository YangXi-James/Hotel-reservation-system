package com.example.springboot.service;


import com.example.springboot.mapper.UserMapper;
import com.example.springboot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Service
public class UserinformationService {

    @Autowired
    UserMapper userMapper;

    public void updateinformation(User user,HttpServletRequest request){
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("LOGINPASSWORD");
        user.setId(id);
        userMapper.updateall(user);
    }


    public User getuserinformation(HttpServletRequest request) {
        int id;
        HttpSession session = request.getSession();
        if(session.getAttribute("LOGINPASSWORD")!=null) {
             id = (int) session.getAttribute("LOGINPASSWORD");
        }
       else {
            id=-1;
            User error=new User();
            error.setId(id);
            return error;
        }
        User user_information= userMapper.getdataall(id);
        return user_information;
    }
}
