package com.example.springboot.common.domain;

public class Standard {
    private Integer standardId;

    private Float area;

    private Integer roomId;

    private Integer storey;

    private Boolean weaherHotwater;

    private Boolean weatherWifi;

    private String roomphotoUrl;

    private String bed;

    private Integer roomNumber;

    private Boolean weaherCancel;

    private Long price;

    private Integer breakfast;

    private String equipment;

    private Integer hotelId;

    public Integer getStandardId() {
        return standardId;
    }

    public void setStandardId(Integer standardId) {
        this.standardId = standardId;
    }

    public Float getArea() {
        return area;
    }

    public void setArea(Float area) {
        this.area = area;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getStorey() {
        return storey;
    }

    public void setStorey(Integer storey) {
        this.storey = storey;
    }

    public Boolean getWeaherHotwater() {
        return weaherHotwater;
    }

    public void setWeaherHotwater(Boolean weaherHotwater) {
        this.weaherHotwater = weaherHotwater;
    }

    public Boolean getWeatherWifi() {
        return weatherWifi;
    }

    public void setWeatherWifi(Boolean weatherWifi) {
        this.weatherWifi = weatherWifi;
    }

    public String getRoomphotoUrl() {
        return roomphotoUrl;
    }

    public void setRoomphotoUrl(String roomphotoUrl) {
        this.roomphotoUrl = roomphotoUrl == null ? null : roomphotoUrl.trim();
    }

    public String getBed() {
        return bed;
    }

    public void setBed(String bed) {
        this.bed = bed == null ? null : bed.trim();
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Boolean getWeaherCancel() {
        return weaherCancel;
    }

    public void setWeaherCancel(Boolean weaherCancel) {
        this.weaherCancel = weaherCancel;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Integer breakfast) {
        this.breakfast = breakfast;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment == null ? null : equipment.trim();
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }
}