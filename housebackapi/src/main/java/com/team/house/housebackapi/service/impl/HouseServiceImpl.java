package com.team.house.housebackapi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.team.house.housebackapi.entity.House;
import com.team.house.housebackapi.mapper.HouseMapper;
import com.team.house.housebackapi.service.HouseService;
import com.team.house.housebackapi.util.HouseCondition;
import com.team.house.housebackapi.util.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired(required = false)
    private HouseMapper houseMapper;
    @Override
    public int addHouse(House house) {
        return houseMapper.insertSelective(house);
    }

    @Override
    public PageInfo<House> getHouseByUser(Integer userid, PageParmeter pageParmeter) {
        PageHelper.startPage(pageParmeter.getPage(),pageParmeter.getPageSize());
        List<House> list = this.houseMapper.getHouseByUser(userid);
        return new PageInfo<House>(list);
    }

    @Override
    public int deleteHouse(String id, Integer delState) {
        House house=new House();
        house.setId(id);  //设置编号
        house.setIsdel(delState);   //设置删除状态
        return this.houseMapper.updateByPrimaryKeySelective(house);
    }

    @Override
    public PageInfo<House> getBroswerHouse(HouseCondition houseCondition) {
        PageHelper.startPage(houseCondition.getPage(),houseCondition.getPageSize());
        List<House> list=this.houseMapper.browserHouse(houseCondition);
        return new PageInfo<House>(list);
    }
}
