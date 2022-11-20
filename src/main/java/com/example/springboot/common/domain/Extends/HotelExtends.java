package com.example.springboot.common.domain.Extends;


import com.example.springboot.common.domain.*;


import java.util.List;

public class HotelExtends {
   private Distinction distinction;
   private City city;
   private Country country;
    private List<Standard> standards;
    private Province province;

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }



    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Standard> getStandards() {
        return standards;
    }

    public void setStandards(List<Standard> standards) {
        this.standards = standards;
    }

    public Distinction getDistinction() {
        return distinction;
    }

    public void setDistinction(Distinction distinction) {
        this.distinction = distinction;
    }
}
