package com.example.springboot.common.domain;

import com.example.springboot.common.domain.Extends.OrderExtends;

import java.util.Date;

public class Order  extends OrderExtends {
    private Integer orderId;

    private Integer id;

    private Integer standardId;

    private Date time;

    private Long totalPrice;

    private Integer datingTime;

    private Boolean wheatherPay;

    private Date orderTime;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStandardId() {
        return standardId;
    }

    public void setStandardId(Integer standardId) {
        this.standardId = standardId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getDatingTime() {
        return datingTime;
    }

    public void setDatingTime(Integer datingTime) {
        this.datingTime = datingTime;
    }

    public Boolean getWheatherPay() {
        return wheatherPay;
    }

    public void setWheatherPay(Boolean wheatherPay) {
        this.wheatherPay = wheatherPay;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}