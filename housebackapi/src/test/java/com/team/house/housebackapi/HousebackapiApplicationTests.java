package com.team.house.housebackapi;

import com.team.house.housebackapi.entity.District;
import com.team.house.housebackapi.entity.DistrictExample;
import com.team.house.housebackapi.mapper.DistrictMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class HousebackapiApplicationTests {
    @Autowired(required = false)
    private DistrictMapper districtMapper;
    @Test
    void contextLoads() {
        List<District> list = districtMapper.selectByExample(new DistrictExample());
        System.out.println("总数是："+list.size());
    }

}
