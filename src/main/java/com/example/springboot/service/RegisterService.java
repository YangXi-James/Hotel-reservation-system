package com.example.springboot.service;

import com.example.springboot.dto.ResultDTO;
import com.example.springboot.dto.UserDTO;
import com.example.springboot.exception.CustomizeErrorCode;

import com.example.springboot.mapper.VerifyMapper;
import com.example.springboot.mapper.UserMapperLiu;
import com.example.springboot.common.domain.User;


import com.example.springboot.model.Verify;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RegisterService {


    @Autowired(required = false)
    UserMapperLiu userMapperLiu;
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    VerifyMapper verifyMapper;

    /**
     * 检查邮箱号是否注册
<<<<<<< HEAD
     * @param email 邮箱号
     * @return
     */
    public boolean checkRegister(String email){
        User user1 = userMapperLiu.selectByEmail(email);
        if (user1==null){
            return true;
        }
        return false;
    }

    /**
     * 注册
     *
     *
     */
    public ResultDTO register(UserDTO userDTO) {
        //checkRegister()返回结果为true表示可以注册
        if (!checkRegister(userDTO.getEmail())){
            return ResultDTO.errorInfo(CustomizeErrorCode.EMAIL_IS_EXIST);
        }
        userDTO.getCode();
        Verify verify = verifyMapper.selectVerify(userDTO.getCode(),userDTO.getEmail());
        if (verify==null){
            //验证码错误
            return ResultDTO.errorInfo(CustomizeErrorCode.VERIFY_IS_ERROR);
        }
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setNickname(userDTO.getNickname());
        user.setPassword(userDTO.getPassword());
        user.setStatus("用户");
        int flag = userMapperLiu.insert(user);

        //注册成功
        if (flag==1){
            //登录成功将验证码删除
            verifyMapper.deleteByEmail(userDTO.getEmail());
            return ResultDTO.info(200,"注册成功");
        }
        //注册失败
        return ResultDTO.errorInfo(CustomizeErrorCode.REGISTER_FAIL);
    }

    /**
     * 发送邮件
     *
     *
     */
    public ResultDTO sendCode(String email){
        //随机六位数验证码
        if (!checkRegister(email)){
            return ResultDTO.errorInfo(CustomizeErrorCode.EMAIL_IS_EXIST);
        }
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            int code = (int)((Math.random() * 9 + 1) * 100000);
            message.setSubject("酒店预订系统注册验证码");
            message.setText("欢迎注册酒店预订系统！ 您的验证码是："+ code + "，请在5分钟内完成注册。");
            message.setTo(email);
            message.setFrom("yang1053902196@163.com");
            mailSender.send(message);
            Verify verify = new Verify();
            //
            verify.setCode(code);
            verify.setEmail(email);
            verifyMapper.insert(verify);
            return ResultDTO.info(200,"邮件发送成功");
        }catch (MailException e){
            log.error("邮件发送出错" + e);
            return ResultDTO.errorInfo(CustomizeErrorCode.INVALID_ADDRESSES);
        }

    }

    /**
     * 使用多线程五分钟后清除验证码数据
     *
     */
    @Async
    public void removeCode(String email){
        try {
            System.out.println("线程开始"+System.currentTimeMillis());
            long a=300000;
            Thread.sleep(a);
            verifyMapper.deleteByEmail(email);
            System.out.println("线程结束"+System.currentTimeMillis());
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}
