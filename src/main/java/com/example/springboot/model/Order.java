package com.example.springboot.model;
import lombok.Data;
import java.sql.Time;
import java.util.Date;

@Data
public class Order {
    private Integer order_id;
    private Integer id;
    private String phone;
    private Integer standard_id;
    private Date time;
    private Double total_price;
    private Integer dating_time;
    private boolean wheather_pay;
    private boolean wheather_cancel;
    private boolean wheather_checkout;
    private Time order_time;
    private String remark;
    private String roomphoto_url;

    public String getRoomphoto_url() {
        return roomphoto_url;
    }

    public void setRoomphoto_url(String roomphoto_url) {
        this.roomphoto_url = roomphoto_url;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Integer order_id) {
        this.order_id = order_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStandard_id() {
        return standard_id;
    }

    public void setStandard_id(Integer standard_id) {
        this.standard_id = standard_id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public Integer getDating_time() {
        return dating_time;
    }

    public void setDating_time(Integer dating_time) {
        this.dating_time = dating_time;
    }

    public boolean isWheather_pay() {
        return wheather_pay;
    }

    public void setWheather_pay(boolean wheather_pay) {
        this.wheather_pay = wheather_pay;
    }

    public Time getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Time order_time) {
        this.order_time = order_time;
    }

    public boolean isWheather_cancel() {
        return wheather_cancel;
    }

    public void setWheather_cancel(boolean wheather_cancel) {
        this.wheather_cancel = wheather_cancel;
    }

    public boolean isWheather_checkout() {
        return wheather_checkout;
    }

    public void setWheather_checkout(boolean wheather_checkout) {
        this.wheather_checkout = wheather_checkout;
    }
}
