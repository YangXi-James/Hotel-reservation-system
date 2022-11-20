package com.example.springboot.service;

import com.example.springboot.dto.ResultDTO;
import com.example.springboot.exception.CustomizeErrorCode;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.model.*;



@Slf4j
@Service
public class LoginService {

    public static final String LoginID= "LOGINPASSWORD";//放到ses
    @Autowired(required = false)
    UserMapper userMapper;


    public Object login(User user,HttpServletRequest request){
        String nickname = user.getNickname();
        String password = user.getPassword();
        String identity =user.getIdentity();
        HttpSession session = request.getSession();
        String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");
        session.removeAttribute("RANDOMVALIDATECODEKEY");
        if (nickname==null||password==null||identity==null){
            return ResultDTO.errorInfo(CustomizeErrorCode.EMAIL_OR_PWD_BLANK);
        }
        User login = userMapper.selectByNicknamePwd(nickname, password);

        if (login==null || !(identity.equals(random)) ){
            return ResultDTO.errorInfo(CustomizeErrorCode.EMAIL_OR_PWD_ERROR);
        }
        String one=login.getStatus();
        if(one.equals("管理员"))
        {
            return ResultDTO.info(999,"欢迎您，管理员");
        }
        else {
            int id=login.getId();
            session.setAttribute(LoginID,id);
            return ResultDTO.info(200, "登录成功");
        }
    }





}
