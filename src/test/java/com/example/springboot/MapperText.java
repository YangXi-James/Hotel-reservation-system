package com.example.springboot;

import com.example.springboot.common.domain.User;
import com.example.springboot.common.domain.UserExample;
import com.example.springboot.mapper.UserMapperLiu;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MapperText {

    @Autowired(required = false)
    UserMapperLiu userMapperLiu;
/*
* 插入用户数据
* */
    @Test
    void test1() {
        for(int i =300;i<400;i++)
        {
            User user = new User();
            user.setId(i+150);
            user.setNickname(""+i+150);
            user.setEmail("123");
            user.setPassword("123");
            userMapperLiu.insert(user);
        }
    }

    @Test
    void test2() {
        PageHelper.startPage(2,10);
        UserExample userExample =new UserExample();
       List<User> userList = userMapperLiu.selectByExample(userExample);
        PageInfo<User> pageInfo =new PageInfo<>(userList);
       System.out.println(userList);
    }
}
