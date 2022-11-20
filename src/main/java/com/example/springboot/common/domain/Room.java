package com.example.springboot.common.domain;

public class Room {
    private Integer roomId;

    private Integer hotelId;

    private Boolean wheatherAvalible;

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public Boolean getWheatherAvalible() {
        return wheatherAvalible;
    }

    public void setWheatherAvalible(Boolean wheatherAvalible) {
        this.wheatherAvalible = wheatherAvalible;
    }
}