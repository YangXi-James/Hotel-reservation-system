package com.example.springboot.mapper.Extends;

import com.example.springboot.common.domain.Order;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderMapperExtends {

    Order selectDetialById(Integer orderId);

    int selectAll();

    List<Order> selectLatestOrder();
}
