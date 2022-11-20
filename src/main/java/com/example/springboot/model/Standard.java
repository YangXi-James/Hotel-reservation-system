package com.example.springboot.model;

import lombok.Data;

@Data
public class Standard {
private float area;
private int standard_id;
private int room_id;
private  int hotel_id;
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
}
