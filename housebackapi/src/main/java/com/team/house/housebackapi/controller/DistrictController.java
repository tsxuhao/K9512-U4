package com.team.house.housebackapi.controller;

import com.team.house.housebackapi.entity.District;
import com.team.house.housebackapi.service.DistrictService;
import com.team.house.housebackapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/district/")
//@CrossOrigin(origins = "*",allowCredentials ="true")
public class DistrictController {
    @Autowired
    private DistrictService districtService;
    @RequestMapping("getDistrictData")
    public BaseResult getDistrictData(){
        List<District> list = districtService.getAllDistrict();
        return new BaseResult(200,list);
    }
}
