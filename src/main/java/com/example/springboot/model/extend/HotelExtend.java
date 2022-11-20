package com.example.springboot.model.extend;

import com.example.springboot.model.Hotel;

public class HotelExtend extends Hotel {
    private float area;
    private int standard_id;
    private int room_id;
    private int storey;
    private boolean weather_hotwater;
    private boolean  weather_wifi;
    private String roomphoto_url;
    private String bed;
    private int room_number;
    private boolean  weather_cancel;
    private double price;
    private  int breakfast;
    private String equipment;

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getStandard_id() {
        return standard_id;
    }

    public void setStandard_id(int standard_id) {
        this.standard_id = standard_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getStorey() {
        return storey;
    }

    public void setStorey(int storey) {
        this.storey = storey;
    }

    public boolean isWeather_hotwater() {
        return weather_hotwater;
    }

    public void setWeather_hotwater(boolean weather_hotwater) {
        this.weather_hotwater = weather_hotwater;
    }

    public boolean isWeather_wifi() {
        return weather_wifi;
    }

    public void setWeather_wifi(boolean weather_wifi) {
        this.weather_wifi = weather_wifi;
    }

    public String getRoomphoto_url() {
        return roomphoto_url;
    }

    public void setRoomphoto_url(String roomphoto_url) {
        this.roomphoto_url = roomphoto_url;
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed;
    }

    public int getRoom_number() {
        return room_number;
    }

    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    public boolean isWeather_cancel() {
        return weather_cancel;
    }

    public void setWeather_cancel(boolean weather_cancel) {
        this.weather_cancel = weather_cancel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(int breakfast) {
        this.breakfast = breakfast;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }
}
