package com.example.springboot.mapper;

import com.example.springboot.common.domain.Order;
import com.example.springboot.common.domain.OrderExample;
import java.util.List;

import com.example.springboot.mapper.Extends.OrderMapperExtends;
import org.apache.ibatis.annotations.Param;

public interface OrderMapperLiu extends OrderMapperExtends {
    long countByExample(OrderExample example);

    int deleteByExample(OrderExample example);

    int deleteByPrimaryKey(Integer orderId);

    int insert(Order record);

    int insertSelective(Order record);

    List<Order> selectByExample(OrderExample example);

    Order selectByPrimaryKey(Integer orderId);

    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}