package com.example.springboot.service;

import com.example.springboot.common.domain.Order;
import com.example.springboot.common.domain.OrderExample;
import com.example.springboot.mapper.OrderMapperLiu;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceLiu {
    @Autowired(required = false)
    private OrderMapperLiu orderMapperLiu;

    public PageInfo<Order> findPartOrder(int pageNo, int pageSize)
    {
        PageHelper.startPage(pageNo,pageSize);
        OrderExample orderExample =new OrderExample();
        List<Order> orders = orderMapperLiu.selectByExample(orderExample);
        PageInfo<Order> pageInfo =new PageInfo<>(orders);
        System.out.println(orders);
        return pageInfo;
    }

    public Order findOrderById(Integer id) {
        return orderMapperLiu.selectDetialById(id);
    }


    public int getOrderCount() {
        return orderMapperLiu.selectAll();
    }

    public List<Order> getLatestOrder() {
        return orderMapperLiu.selectLatestOrder();
    }
}
