package com.example.springboot.mapper;

import com.example.springboot.common.domain.Distinction;
import com.example.springboot.common.domain.DistinctionExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface DistinctionMapper  {
    long countByExample(DistinctionExample example);

    int deleteByExample(DistinctionExample example);

    int deleteByPrimaryKey(Integer distinctId);

    int insert(Distinction record);

    int insertSelective(Distinction record);

    List<Distinction> selectByExample(DistinctionExample example);

    Distinction selectByPrimaryKey(Integer distinctId);

    int updateByExampleSelective(@Param("record") Distinction record, @Param("example") DistinctionExample example);

    int updateByExample(@Param("record") Distinction record, @Param("example") DistinctionExample example);

    int updateByPrimaryKeySelective(Distinction record);

    int updateByPrimaryKey(Distinction record);


}