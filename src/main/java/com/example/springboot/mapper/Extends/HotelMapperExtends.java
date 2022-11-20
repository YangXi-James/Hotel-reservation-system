package com.example.springboot.mapper.Extends;

import com.example.springboot.common.domain.Hotel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HotelMapperExtends {

    Hotel selectHotelDetialById(Integer id);

    int selectAll();
}
