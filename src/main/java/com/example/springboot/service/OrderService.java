package com.example.springboot.service;


import com.example.springboot.mapper.OrderMapper;
import com.example.springboot.model.Hotel;
import com.example.springboot.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;


    public void book(Order order){
        orderMapper.insert(order);
    }
    public void pay(int order_id){
        orderMapper.updatePay(order_id);
    }
    public void cancel(int order_id){
        orderMapper.updateCancel(order_id);
    }
    public void checkout(int order_id){
        orderMapper.updateCheckout(order_id);
    }
    public List<Order> selectID(int order_id){
        return orderMapper.selectByID(order_id);
    }
    public List<Order> findOrder(int id){
        return orderMapper.selectByUerID(id);
    }
    public List<Order> findOrderAndPic(int id){
        return orderMapper.selectSpicByUerID(id);
    }
    public String selectName(int id){
        return orderMapper.SelectNameByID(id);
    }
    public void setReview(int order_id, String review){
        orderMapper.insertReview(order_id,review);
    }
    public List<Hotel> selectHotelByStandardId(int standard_id){
        return orderMapper.selectByStandID(standard_id);
    }

}
