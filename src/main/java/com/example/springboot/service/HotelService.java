package com.example.springboot.service;

import com.example.springboot.common.domain.*;
import com.example.springboot.mapper.DistinctionMapper;
import com.example.springboot.mapper.HotelMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {
    @Autowired(required = false)
    HotelMapper hotelMapper;
    @Autowired(required = false)
    DistinctionMapper distinctionMapper;

    public PageInfo<Hotel> findPartUserHotel(int pageNo, int pageSize, Hotel hotel)
    {
        PageHelper.startPage(pageNo,pageSize);
        HotelExample hotelExample =new HotelExample();
        HotelExample.Criteria criteria = hotelExample.createCriteria();
        if(hotel!=null)
        {
            if(hotel.getHotelId()!=null)
            {
                criteria.andHotelIdEqualTo(hotel.getHotelId());
            }
            if(hotel.getHotelName()!=null)
            {
                criteria.andHotelNameLike("%"+hotel.getHotelName()+"%");
            }
        }

        List<Hotel> hotels =hotelMapper.selectByExample(hotelExample);
        PageInfo<Hotel> pageInfo =new PageInfo<>(hotels);
        System.out.println(hotels);
        return pageInfo;
    }


    public Hotel findHotelById(Integer id) {
        return hotelMapper.selectHotelDetialById(id);
    }

    public Hotel findUserById(Integer id) {
        return  hotelMapper.selectByPrimaryKey(id);
    }

    public int getHotelCount() {
        return hotelMapper.selectAll();
    }

    public int updateHotel(Hotel hotel) {
        DistinctionExample example=new DistinctionExample();
        DistinctionExample.Criteria criteria = example.createCriteria();
        criteria.andDistinctNameEqualTo(hotel.getDistinction().getDistinctName());
        List<Distinction> distinctionList = distinctionMapper.selectByExample(example);
        int distinction_id=1;
        if(distinctionList.size()!=0)
        {
            distinction_id=distinctionList.get(0).getDistinctId();
        }
        hotel.setDistinctId(distinction_id);
        return hotelMapper.updateByPrimaryKey(hotel);
    }

    public int addHotel(Hotel hotel) {
        DistinctionExample example=new DistinctionExample();
        DistinctionExample.Criteria criteria = example.createCriteria();
        criteria.andDistinctNameEqualTo(hotel.getDistinction().getDistinctName());
        List<Distinction> distinctionList = distinctionMapper.selectByExample(example);
        int distinction_id=1;
        if(distinctionList.size()!=0)
        {
            distinction_id=distinctionList.get(0).getDistinctId();
        }
        hotel.setDistinctId(distinction_id);
        return hotelMapper.insert(hotel);
    }

    public int deleteHotelById(Integer[] ids) throws Exception {
        int count = 0;
        if (ids != null && ids.length > 0) {
            for (Integer id : ids) {
                int i = hotelMapper.deleteByPrimaryKey(id);
                count = count + i;
            }
        }
        return count;
    }

    public List<Hotel> getAllHotelList() {
        HotelExample hotelExample=new HotelExample();

        return hotelMapper.selectByExample(hotelExample);
    }
}
