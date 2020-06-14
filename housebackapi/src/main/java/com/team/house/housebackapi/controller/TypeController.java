package com.team.house.housebackapi.controller;

import com.team.house.housebackapi.entity.Type;
import com.team.house.housebackapi.service.TypeService;
import com.team.house.housebackapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/type/")
//@CrossOrigin(origins = "*",allowCredentials ="true")
public class TypeController {
    @Autowired
    private TypeService typeService;
    @RequestMapping("getTypeData")
    public BaseResult getTypeData(){
        List<Type> list = typeService.getAllType();
        return new BaseResult(200,list);
    }
}