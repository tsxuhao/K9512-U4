package com.team.house.housebackapi.controller;

import com.github.pagehelper.PageInfo;
import com.team.house.housebackapi.entity.House;
import com.team.house.housebackapi.entity.Users;
import com.team.house.housebackapi.service.HouseService;
import com.team.house.housebackapi.util.BaseResult;
import com.team.house.housebackapi.util.FileUploadUtil;
import com.team.house.housebackapi.util.HouseCondition;
import com.team.house.housebackapi.util.PageParmeter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/house/")
//@CrossOrigin(origins = "*",allowCredentials ="true")
public class HouseController {
    @Autowired
    private HouseService houseService;
    @RequestMapping("fabuHouse")
    public BaseResult fabuHouse(
            House house,
            @RequestParam(value = "pfile",required = false)
            MultipartFile pfile,
            HttpSession session){
        try {
            String path = "F:\\images";
            String fileName = FileUploadUtil.upload(pfile,path);
            house.setId(System.currentTimeMillis()+"");
            house.setPath(fileName);
            Users users = (Users) session.getAttribute("logininfo");
            house.setUserId(users.getId());
            houseService.addHouse(house);
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        } catch (Exception e) {
            e.printStackTrace();
            return new BaseResult(BaseResult.RESULT_FAIL,"发布失败"+e.getMessage());
        }
    }
    @RequestMapping("getHouseByPage")
    public BaseResult getHouseByPage(PageParmeter pageParmeter, HttpSession session){
        Users users = (Users) session.getAttribute("logininfo");
        Integer userid = users.getId();
        PageInfo<House> pageInfo = this.houseService.getHouseByUser(userid, pageParmeter);
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("totalPage",pageInfo.getPages());
        map.put("row",pageInfo.getList());
        return new BaseResult(200,map);
    }
    @RequestMapping("delHouse")
    public BaseResult delHouse(String id){
        int i = this.houseService.deleteHouse(id, 1);
        if(i>0)
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        else{
            return new BaseResult(BaseResult.RESULT_FAIL,"删除失败");
        }

    }
    //浏览出租房  houseCondition接收前端所有的数据
    @RequestMapping("searchHouse")
    public BaseResult searchHouse(HouseCondition houseCondition){
        //调用业务获取分页信息  1表示删除
        PageInfo<House> pageInfo=this.houseService.getBroswerHouse(houseCondition);
        //封装返回数据
        Map<String,Object> map=new HashMap<>();
        map.put("curPage",pageInfo.getPageNum());
        map.put("totalPage",pageInfo.getPages());
        map.put("list",pageInfo.getList());
        return new BaseResult(200,map);
    }
}
