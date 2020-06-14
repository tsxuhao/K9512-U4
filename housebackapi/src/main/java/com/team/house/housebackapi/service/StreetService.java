package com.team.house.housebackapi.service;

import com.team.house.housebackapi.entity.Street;

import java.util.List;

public interface StreetService {
    //通过区域编号查询街道
    public List<Street> getStreetByDid(Integer did);
}
