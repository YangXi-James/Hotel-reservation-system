package com.example.springboot.service;

import com.example.springboot.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired(required = false)
    RoomMapper roomMapper;

    public int getRoomCount() {
        return  roomMapper.selectAll();
    }
}
