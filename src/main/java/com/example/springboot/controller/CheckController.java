package com.example.springboot.controller;

import com.example.springboot.dto.ResultDTO;
import com.example.springboot.dto.UserDTO;
import com.example.springboot.exception.CustomizeErrorCode;
import com.example.springboot.service.CheckService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class CheckController {


    @Autowired
    CheckService checkService;
    @Autowired
    JavaMailSender mailSender;

    /**
     * 发送验证码
     * @param email 邮箱号
     * @return ResultDTO 返回json格式，带有code和message
     */
    @ResponseBody
    @PostMapping("/sendcheckCode")
    public ResultDTO sendcheckCode(@RequestParam("email") String email){
        System.out.println(email);
        if (StringUtils.isBlank(email)){
            return ResultDTO.info(210,"邮箱不能为空");
        }
        ResultDTO resultDTO = checkService.sendcheckCode(email);
        if (resultDTO.getCode()==200) {
            //多线程五分钟后删除
            checkService.removeCode(email);
        }
        return resultDTO;
    }

    /**
     * 注册
     * 将注册参数code、email、pwd封装带UserDTO中
     * @param userDTO
     * @return ResultDTO 返回json格式，带有code和message
     */
    @ResponseBody
    @PostMapping("/check")
    public ResultDTO next( UserDTO userDTO,HttpServletRequest request){

        System.out.println(userDTO);

        if (StringUtils.isBlank(userDTO.getEmail())&&StringUtils.isBlank(userDTO.getPassword())){
            return ResultDTO.errorInfo(CustomizeErrorCode.EMAIL_OR_PWD_BLANK);
        }
        return checkService.next(request,userDTO);
    }

    @ResponseBody
    @PostMapping("/setpassword")
    public ResultDTO setpassword(@RequestParam("password")String password,HttpServletRequest request){
        System.out.println(password);
        return checkService.set_password(password,request);
    }
}

