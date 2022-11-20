package com.example.springboot.mapper.Extends;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapperExtends {
    int selectAll();
}
