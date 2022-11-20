package com.example.springboot.mapper;
import com.example.springboot.model.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface RegionMapper {

    /**
     * 找出国家
     *
     *
     *
     */
    @Select("select * from Country")
    List<Country> findCountry() ;

    /**
     * 找出省份
     *
     *
     *
     */
    @Select("SELECT * FROM Province WHERE country_id =(#{country_id})")
    List<Province> findProvince(int country_id);

    /**
     * 找出城市
     *
     *
     *
     */
    @Select("SELECT * FROM City WHERE province_id =(#{province_id})")
    List<City> findCity(int province_id);

    /**
     * 找出区
     *
     *
     *
     */
    @Select("SELECT * FROM Distinction WHERE city_id =(#{city_id})")
    List<Distinction> findDistinction(int city_id);

    /**
     * 找出酒店
     *
     *
     *
     */
    @Select("SELECT * FROM Hotel WHERE distinct_id =(#{distinct_id})")
    List<Hotel> findHotel(int distinct_id);

    /**
     * 找出酒店
     *
     *
     *
     */
    @Select("SELECT * FROM Hotel WHERE hotel_name like '%${hotelname}%' ")
    List<Hotel> findHotelname(String hotelname);

    /**
     * 找出套房
     *
     *
     *
     */
    @Select("SELECT * FROM Standard WHERE hotel_id=(#{hotel_id}) ")
    List<Standard> findStandard(int hotel_id);

    /**
     * 找出所有酒店
     *
     *
     *
     */
    @Select("SELECT * FROM Hotel ")
    List<Hotel> findallhotel();
}
