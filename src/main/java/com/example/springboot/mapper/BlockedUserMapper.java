package com.example.springboot.mapper;

import com.example.springboot.common.domain.BlockedUser;
import com.example.springboot.common.domain.BlockedUserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface BlockedUserMapper {
    long countByExample(BlockedUserExample example);

    int deleteByExample(BlockedUserExample example);

    int insert(BlockedUser record);

    int insertSelective(BlockedUser record);

    List<BlockedUser> selectByExample(BlockedUserExample example);

    int updateByExampleSelective(@Param("record") BlockedUser record, @Param("example") BlockedUserExample example);

    int updateByExample(@Param("record") BlockedUser record, @Param("example") BlockedUserExample example);
}