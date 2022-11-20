package com.example.springboot.common.domain;

import java.util.ArrayList;
import java.util.List;

public class StandardExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public StandardExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andStandardIdIsNull() {
            addCriterion("standard_id is null");
            return (Criteria) this;
        }

        public Criteria andStandardIdIsNotNull() {
            addCriterion("standard_id is not null");
            return (Criteria) this;
        }

        public Criteria andStandardIdEqualTo(Integer value) {
            addCriterion("standard_id =", value, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdNotEqualTo(Integer value) {
            addCriterion("standard_id <>", value, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdGreaterThan(Integer value) {
            addCriterion("standard_id >", value, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("standard_id >=", value, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdLessThan(Integer value) {
            addCriterion("standard_id <", value, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdLessThanOrEqualTo(Integer value) {
            addCriterion("standard_id <=", value, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdIn(List<Integer> values) {
            addCriterion("standard_id in", values, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdNotIn(List<Integer> values) {
            addCriterion("standard_id not in", values, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdBetween(Integer value1, Integer value2) {
            addCriterion("standard_id between", value1, value2, "standardId");
            return (Criteria) this;
        }

        public Criteria andStandardIdNotBetween(Integer value1, Integer value2) {
            addCriterion("standard_id not between", value1, value2, "standardId");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(Float value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(Float value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(Float value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(Float value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(Float value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(Float value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<Float> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<Float> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(Float value1, Float value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(Float value1, Float value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Integer value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Integer value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Integer value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Integer value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Integer> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Integer> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andStoreyIsNull() {
            addCriterion("storey is null");
            return (Criteria) this;
        }

        public Criteria andStoreyIsNotNull() {
            addCriterion("storey is not null");
            return (Criteria) this;
        }

        public Criteria andStoreyEqualTo(Integer value) {
            addCriterion("storey =", value, "storey");
            return (Criteria) this;
        }

        public Criteria andStoreyNotEqualTo(Integer value) {
            addCriterion("storey <>", value, "storey");
            return (Criteria) this;
        }

        public Criteria andStoreyGreaterThan(Integer value) {
            addCriterion("storey >", value, "storey");
            return (Criteria) this;
        }

        public Criteria andStoreyGreaterThanOrEqualTo(Integer value) {
            addCriterion("storey >=", value, "storey");
            return (Criteria) this;
        }

        public Criteria andStoreyLessThan(Integer value) {
            addCriterion("storey <", value, "storey");
            return (Criteria) this;
        }

        public Criteria andStoreyLessThanOrEqualTo(Integer value) {
            addCriterion("storey <=", value, "storey");
            return (Criteria) this;
        }

        public Criteria andStoreyIn(List<Integer> values) {
            addCriterion("storey in", values, "storey");
            return (Criteria) this;
        }

        public Criteria andStoreyNotIn(List<Integer> values) {
            addCriterion("storey not in", values, "storey");
            return (Criteria) this;
        }

        public Criteria andStoreyBetween(Integer value1, Integer value2) {
            addCriterion("storey between", value1, value2, "storey");
            return (Criteria) this;
        }

        public Criteria andStoreyNotBetween(Integer value1, Integer value2) {
            addCriterion("storey not between", value1, value2, "storey");
            return (Criteria) this;
        }

        public Criteria andWeaherHotwaterIsNull() {
            addCriterion("weaher_hotwater is null");
            return (Criteria) this;
        }

        public Criteria andWeaherHotwaterIsNotNull() {
            addCriterion("weaher_hotwater is not null");
            return (Criteria) this;
        }

        public Criteria andWeaherHotwaterEqualTo(Boolean value) {
            addCriterion("weaher_hotwater =", value, "weaherHotwater");
            return (Criteria) this;
        }

        public Criteria andWeaherHotwaterNotEqualTo(Boolean value) {
            addCriterion("weaher_hotwater <>", value, "weaherHotwater");
            return (Criteria) this;
        }

        public Criteria andWeaherHotwaterGreaterThan(Boolean value) {
            addCriterion("weaher_hotwater >", value, "weaherHotwater");
            return (Criteria) this;
        }

        public Criteria andWeaherHotwaterGreaterThanOrEqualTo(Boolean value) {
            addCriterion("weaher_hotwater >=", value, "weaherHotwater");
            return (Criteria) this;
        }

        public Criteria andWeaherHotwaterLessThan(Boolean value) {
            addCriterion("weaher_hotwater <", value, "weaherHotwater");
            return (Criteria) this;
        }

        public Criteria andWeaherHotwaterLessThanOrEqualTo(Boolean value) {
            addCriterion("weaher_hotwater <=", value, "weaherHotwater");
            return (Criteria) this;
        }

        public Criteria andWeaherHotwaterIn(List<Boolean> values) {
            addCriterion("weaher_hotwater in", values, "weaherHotwater");
            return (Criteria) this;
        }

        public Criteria andWeaherHotwaterNotIn(List<Boolean> values) {
            addCriterion("weaher_hotwater not in", values, "weaherHotwater");
            return (Criteria) this;
        }

        public Criteria andWeaherHotwaterBetween(Boolean value1, Boolean value2) {
            addCriterion("weaher_hotwater between", value1, value2, "weaherHotwater");
            return (Criteria) this;
        }

        public Criteria andWeaherHotwaterNotBetween(Boolean value1, Boolean value2) {
            addCriterion("weaher_hotwater not between", value1, value2, "weaherHotwater");
            return (Criteria) this;
        }

        public Criteria andWeatherWifiIsNull() {
            addCriterion("weather_wifi is null");
            return (Criteria) this;
        }

        public Criteria andWeatherWifiIsNotNull() {
            addCriterion("weather_wifi is not null");
            return (Criteria) this;
        }

        public Criteria andWeatherWifiEqualTo(Boolean value) {
            addCriterion("weather_wifi =", value, "weatherWifi");
            return (Criteria) this;
        }

        public Criteria andWeatherWifiNotEqualTo(Boolean value) {
            addCriterion("weather_wifi <>", value, "weatherWifi");
            return (Criteria) this;
        }

        public Criteria andWeatherWifiGreaterThan(Boolean value) {
            addCriterion("weather_wifi >", value, "weatherWifi");
            return (Criteria) this;
        }

        public Criteria andWeatherWifiGreaterThanOrEqualTo(Boolean value) {
            addCriterion("weather_wifi >=", value, "weatherWifi");
            return (Criteria) this;
        }

        public Criteria andWeatherWifiLessThan(Boolean value) {
            addCriterion("weather_wifi <", value, "weatherWifi");
            return (Criteria) this;
        }

        public Criteria andWeatherWifiLessThanOrEqualTo(Boolean value) {
            addCriterion("weather_wifi <=", value, "weatherWifi");
            return (Criteria) this;
        }

        public Criteria andWeatherWifiIn(List<Boolean> values) {
            addCriterion("weather_wifi in", values, "weatherWifi");
            return (Criteria) this;
        }

        public Criteria andWeatherWifiNotIn(List<Boolean> values) {
            addCriterion("weather_wifi not in", values, "weatherWifi");
            return (Criteria) this;
        }

        public Criteria andWeatherWifiBetween(Boolean value1, Boolean value2) {
            addCriterion("weather_wifi between", value1, value2, "weatherWifi");
            return (Criteria) this;
        }

        public Criteria andWeatherWifiNotBetween(Boolean value1, Boolean value2) {
            addCriterion("weather_wifi not between", value1, value2, "weatherWifi");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlIsNull() {
            addCriterion("roomphoto_url is null");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlIsNotNull() {
            addCriterion("roomphoto_url is not null");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlEqualTo(String value) {
            addCriterion("roomphoto_url =", value, "roomphotoUrl");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlNotEqualTo(String value) {
            addCriterion("roomphoto_url <>", value, "roomphotoUrl");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlGreaterThan(String value) {
            addCriterion("roomphoto_url >", value, "roomphotoUrl");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlGreaterThanOrEqualTo(String value) {
            addCriterion("roomphoto_url >=", value, "roomphotoUrl");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlLessThan(String value) {
            addCriterion("roomphoto_url <", value, "roomphotoUrl");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlLessThanOrEqualTo(String value) {
            addCriterion("roomphoto_url <=", value, "roomphotoUrl");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlLike(String value) {
            addCriterion("roomphoto_url like", value, "roomphotoUrl");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlNotLike(String value) {
            addCriterion("roomphoto_url not like", value, "roomphotoUrl");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlIn(List<String> values) {
            addCriterion("roomphoto_url in", values, "roomphotoUrl");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlNotIn(List<String> values) {
            addCriterion("roomphoto_url not in", values, "roomphotoUrl");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlBetween(String value1, String value2) {
            addCriterion("roomphoto_url between", value1, value2, "roomphotoUrl");
            return (Criteria) this;
        }

        public Criteria andRoomphotoUrlNotBetween(String value1, String value2) {
            addCriterion("roomphoto_url not between", value1, value2, "roomphotoUrl");
            return (Criteria) this;
        }

        public Criteria andBedIsNull() {
            addCriterion("bed is null");
            return (Criteria) this;
        }

        public Criteria andBedIsNotNull() {
            addCriterion("bed is not null");
            return (Criteria) this;
        }

        public Criteria andBedEqualTo(String value) {
            addCriterion("bed =", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotEqualTo(String value) {
            addCriterion("bed <>", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedGreaterThan(String value) {
            addCriterion("bed >", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedGreaterThanOrEqualTo(String value) {
            addCriterion("bed >=", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedLessThan(String value) {
            addCriterion("bed <", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedLessThanOrEqualTo(String value) {
            addCriterion("bed <=", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedLike(String value) {
            addCriterion("bed like", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotLike(String value) {
            addCriterion("bed not like", value, "bed");
            return (Criteria) this;
        }

        public Criteria andBedIn(List<String> values) {
            addCriterion("bed in", values, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotIn(List<String> values) {
            addCriterion("bed not in", values, "bed");
            return (Criteria) this;
        }

        public Criteria andBedBetween(String value1, String value2) {
            addCriterion("bed between", value1, value2, "bed");
            return (Criteria) this;
        }

        public Criteria andBedNotBetween(String value1, String value2) {
            addCriterion("bed not between", value1, value2, "bed");
            return (Criteria) this;
        }

        public Criteria andRoomNumberIsNull() {
            addCriterion("room_number is null");
            return (Criteria) this;
        }

        public Criteria andRoomNumberIsNotNull() {
            addCriterion("room_number is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNumberEqualTo(Integer value) {
            addCriterion("room_number =", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotEqualTo(Integer value) {
            addCriterion("room_number <>", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberGreaterThan(Integer value) {
            addCriterion("room_number >", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_number >=", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberLessThan(Integer value) {
            addCriterion("room_number <", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberLessThanOrEqualTo(Integer value) {
            addCriterion("room_number <=", value, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberIn(List<Integer> values) {
            addCriterion("room_number in", values, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotIn(List<Integer> values) {
            addCriterion("room_number not in", values, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberBetween(Integer value1, Integer value2) {
            addCriterion("room_number between", value1, value2, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andRoomNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("room_number not between", value1, value2, "roomNumber");
            return (Criteria) this;
        }

        public Criteria andWeaherCancelIsNull() {
            addCriterion("weaher_cancel is null");
            return (Criteria) this;
        }

        public Criteria andWeaherCancelIsNotNull() {
            addCriterion("weaher_cancel is not null");
            return (Criteria) this;
        }

        public Criteria andWeaherCancelEqualTo(Boolean value) {
            addCriterion("weaher_cancel =", value, "weaherCancel");
            return (Criteria) this;
        }

        public Criteria andWeaherCancelNotEqualTo(Boolean value) {
            addCriterion("weaher_cancel <>", value, "weaherCancel");
            return (Criteria) this;
        }

        public Criteria andWeaherCancelGreaterThan(Boolean value) {
            addCriterion("weaher_cancel >", value, "weaherCancel");
            return (Criteria) this;
        }

        public Criteria andWeaherCancelGreaterThanOrEqualTo(Boolean value) {
            addCriterion("weaher_cancel >=", value, "weaherCancel");
            return (Criteria) this;
        }

        public Criteria andWeaherCancelLessThan(Boolean value) {
            addCriterion("weaher_cancel <", value, "weaherCancel");
            return (Criteria) this;
        }

        public Criteria andWeaherCancelLessThanOrEqualTo(Boolean value) {
            addCriterion("weaher_cancel <=", value, "weaherCancel");
            return (Criteria) this;
        }

        public Criteria andWeaherCancelIn(List<Boolean> values) {
            addCriterion("weaher_cancel in", values, "weaherCancel");
            return (Criteria) this;
        }

        public Criteria andWeaherCancelNotIn(List<Boolean> values) {
            addCriterion("weaher_cancel not in", values, "weaherCancel");
            return (Criteria) this;
        }

        public Criteria andWeaherCancelBetween(Boolean value1, Boolean value2) {
            addCriterion("weaher_cancel between", value1, value2, "weaherCancel");
            return (Criteria) this;
        }

        public Criteria andWeaherCancelNotBetween(Boolean value1, Boolean value2) {
            addCriterion("weaher_cancel not between", value1, value2, "weaherCancel");
            return (Criteria) this;
        }

        public Criteria andPriceIsNull() {
            addCriterion("price is null");
            return (Criteria) this;
        }

        public Criteria andPriceIsNotNull() {
            addCriterion("price is not null");
            return (Criteria) this;
        }

        public Criteria andPriceEqualTo(Long value) {
            addCriterion("price =", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotEqualTo(Long value) {
            addCriterion("price <>", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThan(Long value) {
            addCriterion("price >", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceGreaterThanOrEqualTo(Long value) {
            addCriterion("price >=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThan(Long value) {
            addCriterion("price <", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceLessThanOrEqualTo(Long value) {
            addCriterion("price <=", value, "price");
            return (Criteria) this;
        }

        public Criteria andPriceIn(List<Long> values) {
            addCriterion("price in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotIn(List<Long> values) {
            addCriterion("price not in", values, "price");
            return (Criteria) this;
        }

        public Criteria andPriceBetween(Long value1, Long value2) {
            addCriterion("price between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andPriceNotBetween(Long value1, Long value2) {
            addCriterion("price not between", value1, value2, "price");
            return (Criteria) this;
        }

        public Criteria andBreakfastIsNull() {
            addCriterion("breakfast is null");
            return (Criteria) this;
        }

        public Criteria andBreakfastIsNotNull() {
            addCriterion("breakfast is not null");
            return (Criteria) this;
        }

        public Criteria andBreakfastEqualTo(Integer value) {
            addCriterion("breakfast =", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastNotEqualTo(Integer value) {
            addCriterion("breakfast <>", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastGreaterThan(Integer value) {
            addCriterion("breakfast >", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastGreaterThanOrEqualTo(Integer value) {
            addCriterion("breakfast >=", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastLessThan(Integer value) {
            addCriterion("breakfast <", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastLessThanOrEqualTo(Integer value) {
            addCriterion("breakfast <=", value, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastIn(List<Integer> values) {
            addCriterion("breakfast in", values, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastNotIn(List<Integer> values) {
            addCriterion("breakfast not in", values, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastBetween(Integer value1, Integer value2) {
            addCriterion("breakfast between", value1, value2, "breakfast");
            return (Criteria) this;
        }

        public Criteria andBreakfastNotBetween(Integer value1, Integer value2) {
            addCriterion("breakfast not between", value1, value2, "breakfast");
            return (Criteria) this;
        }

        public Criteria andEquipmentIsNull() {
            addCriterion("equipment is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentIsNotNull() {
            addCriterion("equipment is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentEqualTo(String value) {
            addCriterion("equipment =", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentNotEqualTo(String value) {
            addCriterion("equipment <>", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentGreaterThan(String value) {
            addCriterion("equipment >", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentGreaterThanOrEqualTo(String value) {
            addCriterion("equipment >=", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentLessThan(String value) {
            addCriterion("equipment <", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentLessThanOrEqualTo(String value) {
            addCriterion("equipment <=", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentLike(String value) {
            addCriterion("equipment like", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentNotLike(String value) {
            addCriterion("equipment not like", value, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentIn(List<String> values) {
            addCriterion("equipment in", values, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentNotIn(List<String> values) {
            addCriterion("equipment not in", values, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentBetween(String value1, String value2) {
            addCriterion("equipment between", value1, value2, "equipment");
            return (Criteria) this;
        }

        public Criteria andEquipmentNotBetween(String value1, String value2) {
            addCriterion("equipment not between", value1, value2, "equipment");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNull() {
            addCriterion("hotel_id is null");
            return (Criteria) this;
        }

        public Criteria andHotelIdIsNotNull() {
            addCriterion("hotel_id is not null");
            return (Criteria) this;
        }

        public Criteria andHotelIdEqualTo(Integer value) {
            addCriterion("hotel_id =", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotEqualTo(Integer value) {
            addCriterion("hotel_id <>", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThan(Integer value) {
            addCriterion("hotel_id >", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("hotel_id >=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThan(Integer value) {
            addCriterion("hotel_id <", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdLessThanOrEqualTo(Integer value) {
            addCriterion("hotel_id <=", value, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdIn(List<Integer> values) {
            addCriterion("hotel_id in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotIn(List<Integer> values) {
            addCriterion("hotel_id not in", values, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdBetween(Integer value1, Integer value2) {
            addCriterion("hotel_id between", value1, value2, "hotelId");
            return (Criteria) this;
        }

        public Criteria andHotelIdNotBetween(Integer value1, Integer value2) {
            addCriterion("hotel_id not between", value1, value2, "hotelId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}