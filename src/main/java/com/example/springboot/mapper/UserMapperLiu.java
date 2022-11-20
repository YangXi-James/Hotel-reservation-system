package com.example.springboot.mapper;

import com.example.springboot.common.domain.User;
import com.example.springboot.common.domain.UserExample;
import java.util.List;

import com.example.springboot.mapper.Extends.UserMapperExtends;
import org.apache.ibatis.annotations.Param;

public interface UserMapperLiu  extends UserMapperExtends {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}