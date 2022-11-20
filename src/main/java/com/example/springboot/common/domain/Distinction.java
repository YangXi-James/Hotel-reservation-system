package com.example.springboot.common.domain;

public class Distinction {
    private Integer distinctId;

    private Integer cityId;

    private String distinctName;
    public Distinction(String distinctName)
    {
        this.distinctName=distinctName;
    }

    public Integer getDistinctId() {
        return distinctId;
    }

    public void setDistinctId(Integer distinctId) {
        this.distinctId = distinctId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getDistinctName() {
        return distinctName;
    }

    public void setDistinctName(String distinctName) {
        this.distinctName = distinctName == null ? null : distinctName.trim();
    }
}