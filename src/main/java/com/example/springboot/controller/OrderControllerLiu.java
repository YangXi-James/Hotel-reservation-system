package com.example.springboot.controller;

import com.example.springboot.common.domain.Order;
import com.example.springboot.common.utils.Result;
import com.example.springboot.service.OrderServiceLiu;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderControllerLiu {

    @Autowired
    OrderServiceLiu orderServiceLiu;

    @RequestMapping("/orderListLiu")
    @ResponseBody //加上这个才是会默认返回数据
    public Object getUserListLiu(@RequestParam(defaultValue="1") int pageNo, @RequestParam(defaultValue="10")  int pageSize)
    {
        PageInfo<Order> orderPageInfo= orderServiceLiu.findPartOrder(pageNo,pageSize);

        return Result.success(orderPageInfo);
    }

    @RequestMapping("/orderDetial")
    public String showOrderDetial(ModelMap modelMap, Integer id){
        Order order = orderServiceLiu.findOrderById(id);
        System.out.println(order);
        modelMap.put("order",order);
        return "/views/showOrderDetial";
    }

    @GetMapping("/getOrderCount")
    @ResponseBody
    public Integer getUserCount()
    {
        int count= orderServiceLiu.getOrderCount();
        /*   return Result.success(count,"操作成功",200);*/
        return count;
    }

    @GetMapping("/getLatestOrder")
    @ResponseBody
    public List<Order> getLatestOrder()
    {
        List<Order> latestOrder= orderServiceLiu.getLatestOrder();
        /*   return Result.success(count,"操作成功",200);*/
        return latestOrder;
    }

}
