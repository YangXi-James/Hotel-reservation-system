package com.example.springboot.mapper;

import com.example.springboot.common.domain.Room;
import com.example.springboot.common.domain.RoomExample;
import java.util.List;

import com.example.springboot.mapper.Extends.RoomMapperExtends;
import org.apache.ibatis.annotations.Param;

public interface RoomMapper  extends RoomMapperExtends {
    long countByExample(RoomExample example);

    int deleteByExample(RoomExample example);

    int deleteByPrimaryKey(Integer roomId);

    int insert(Room record);

    int insertSelective(Room record);

    List<Room> selectByExample(RoomExample example);

    Room selectByPrimaryKey(Integer roomId);

    int updateByExampleSelective(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByExample(@Param("record") Room record, @Param("example") RoomExample example);

    int updateByPrimaryKeySelective(Room record);

    int updateByPrimaryKey(Room record);


}