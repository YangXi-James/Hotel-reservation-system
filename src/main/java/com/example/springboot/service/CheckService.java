package com.example.springboot.service;

import com.example.springboot.dto.ResultDTO;
import com.example.springboot.dto.UserDTO;
import com.example.springboot.exception.CustomizeErrorCode;
import com.example.springboot.mapper.VerifyMapper;
import com.example.springboot.mapper.UserMapper;
import com.example.springboot.model.User;
import com.example.springboot.model.Verify;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
@Service
public class CheckService {
    public static final String LOGINEKEY= "LOGINCODEKEY";//放到session中的key


    @Autowired
    JavaMailSender mailSender;
    @Autowired
    VerifyMapper verifyMapper;
    @Autowired
    UserMapper userMapper;
    /**
     * 检查邮箱号是否注册
     * @param email 邮箱号
     * @return
     */
    public boolean checkRegister(String email){
        User user1 = userMapper.selectByEmail(email);
        if (user1==null){
            return false;
        }
        return true;
    }

    /**
     * 检查
     * @param userDTO 该对象参数含有email、code
     * @return ResultDTO
     */
    public ResultDTO next(HttpServletRequest request, UserDTO userDTO) {
        if (!checkRegister(userDTO.getEmail())){
            return ResultDTO.errorInfo(CustomizeErrorCode.EMAIL_IS_EXIST);
        }
        HttpSession session = request.getSession();

        session.setAttribute(LOGINEKEY, userDTO.getEmail());
        userDTO.getCode();
        Verify verify = verifyMapper.selectVerify(userDTO.getCode(),userDTO.getEmail());
        if (verify==null){
            //验证码错误
            return ResultDTO.errorInfo(CustomizeErrorCode.VERIFY_IS_ERROR);
        }
        verifyMapper.deleteByEmail(userDTO.getEmail());
        return ResultDTO.info(200,"成功");
    }

    public ResultDTO sendcheckCode(String email){
        //随机六位数验证码
        if (!checkRegister(email)){
            return ResultDTO.errorInfo(CustomizeErrorCode.EMAIL_IS_NOT_EXIST);
        }
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            int code = (int)((Math.random() * 9 + 1) * 100000);
            message.setSubject("酒店预订系统找回密码");
            message.setText(" 您的验证码是："+ code + "，请在5分钟内完成验证码填写。");
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
     * @param email email
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



    public ResultDTO set_password(String password,HttpServletRequest request) {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("LOGINCODEKEY");
        System.out.println(email);
        session.removeAttribute("LOGINCODEKEY");
        User user=new User();
        user.setEmail(email);
        user.setPassword(password);
        int flag= userMapper.update(user);
        if (flag==1){
            //修改成功
            return ResultDTO.info(200,"修改成功");
        }
        //修改失败
        return ResultDTO.errorInfo(CustomizeErrorCode.PASSWORD_SAME);
    }

}
