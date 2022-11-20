package com.example.springboot.mapper;

import com.example.springboot.common.domain.Standard;
import com.example.springboot.common.domain.StandardExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StandardMapper {
    long countByExample(StandardExample example);

    int deleteByExample(StandardExample example);

    int deleteByPrimaryKey(Integer standardId) throws Exception;

    int insert(Standard record);

    int insertSelective(Standard record);

    List<Standard> selectByExample(StandardExample example);

    Standard selectByPrimaryKey(Integer standardId);

    int updateByExampleSelective(@Param("record") Standard record, @Param("example") StandardExample example);

    int updateByExample(@Param("record") Standard record, @Param("example") StandardExample example);

    int updateByPrimaryKeySelective(Standard record);

    int updateByPrimaryKey(Standard record);
}