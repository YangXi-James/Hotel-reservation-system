package com.example.springboot.service;

import com.example.springboot.common.domain.Hotel;
import com.example.springboot.common.domain.HotelExample;
import com.example.springboot.common.domain.Standard;
import com.example.springboot.common.domain.StandardExample;
import com.example.springboot.mapper.HotelMapper;
import com.example.springboot.mapper.StandardMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StandardService {
    @Autowired(required = false)
    StandardMapper standardMapper;

    public PageInfo<Standard> findPartStandrad(Standard standard,int pageNo, int pageSize)
    {
        PageHelper.startPage(pageNo,pageSize);
        StandardExample standardExample =new StandardExample();
        StandardExample.Criteria criteria = standardExample.createCriteria();
        if(standard.getHotelId()!=null)
        {
            criteria.andHotelIdEqualTo(standard.getHotelId());
        }
        List<Standard> standards =standardMapper.selectByExample(standardExample);
        PageInfo<Standard> pageInfo =new PageInfo<>(standards);
        System.out.println(standards);
        return pageInfo;
    }
    public PageInfo<Standard> findHotelPartStandrad(Integer hotelId,int pageNo, int pageSize)
    {
        PageHelper.startPage(pageNo,pageSize);
        StandardExample standardExample =new StandardExample();
        StandardExample.Criteria criteria = standardExample.createCriteria();
        criteria.andHotelIdEqualTo(hotelId);
        List<Standard> standards =standardMapper.selectByExample(standardExample);
        PageInfo<Standard> pageInfo =new PageInfo<>(standards);
        System.out.println(standards);
        return pageInfo;
    }


    public Standard findStandradByID(Integer id) {
        return standardMapper.selectByPrimaryKey(id);
    }

    public int updateStandrad(Standard standard) {
        return standardMapper.updateByPrimaryKeySelective(standard);
    }

    public int deleteStandradsById(Integer[] ids) throws Exception
    {
        int count = 0;
        if (ids != null && ids.length > 0) {
            for (Integer id : ids) {
                int i = standardMapper.deleteByPrimaryKey(id);
                count = count + i;
            }
        }
        return count;
    }

    public int addStandrad(Standard standard) {
        return  standardMapper.insert(standard);
    }

    public int getStandradCount() {
        StandardExample standardExample =new StandardExample();
        int count =standardMapper.selectByExample(standardExample).size();
        return count;
    }
}
