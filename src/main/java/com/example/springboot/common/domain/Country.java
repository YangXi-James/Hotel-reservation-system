package com.example.springboot.common.domain;

public class Country {

    private Integer countryId;

    private String countryName;
    public Country(String countryName)
    {
        this.countryName=countryName;
    }
    public Integer getCountryId() {
        return countryId;
    }

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName == null ? null : countryName.trim();
    }
}