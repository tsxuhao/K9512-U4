package com.team.house.housebackapi.controller;

import com.team.house.housebackapi.entity.Street;
import com.team.house.housebackapi.service.StreetService;
import com.team.house.housebackapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/street/")
//@CrossOrigin(origins = "*",allowCredentials ="true")
public class StreetController {
    @Autowired
    private StreetService streetService;
    @RequestMapping("getStreetData")
    public BaseResult getStreetData(Integer did){
        List<Street> list = streetService.getStreetByDid(did);
        return new BaseResult(200,list);
    }
}
