package com.example.springboot.mapper;

import com.example.springboot.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface OrderMapper {

    /**
     *
     */
    @Insert("insert into theOrder(order_id,id,phone,standard_id,time,total_price,dating_time,wheather_pay,wheather_cancel,wheather_checkout,order_time,remark) values(#{order_id},#{id},#{phone},#{standard_id},#{time},#{total_price},#{dating_time},#{wheather_pay},#{wheather_cancel},#{wheather_checkout},#{order_time},#{remark})")
    @SelectKey(statement = "select last_insert_id()", keyProperty = "order_id", before = false, resultType = int.class)
    int insert(Order order);

    @Select("select nickname from user where id = #{id}")
    String SelectNameByID(int id);

    @Update("update theOrder set wheather_pay = 1 where order_id = #{order_id}")
    int updatePay(int order_id);

    @Update("update theOrder set wheather_cancel = 1 where order_id = #{order_id}")
    int updateCancel(int order_id);

    @Update("update theOrder set wheather_checkout = 1 where order_id = #{order_id}")
    int updateCheckout(int order_id);

    @Select("select * from theOrder where order_id = #{order_id}")
    List<Order> selectByID(int order_id);

    @Select("select * from theOrder where id=#{id} ORDER BY order_id DESC")
    List<Order> selectByUerID(int id);

    @Select("select * from theOrder,standard where theOrder.standard_id= standard.standard_id and id=#{id} ORDER BY order_id DESC")
    List<Order> selectSpicByUerID(int id);

    @Insert("insert into review(review_id,order_id,content) values (null,#{order_id},#{review})")
    int insertReview(int order_id, String review);

    @Select("select * from hotel,standard where hotel.hotel_id = standard.hotel_id AND standard_id=#{standard_id}")
    List<Hotel> selectByStandID(int standard_id);
}
