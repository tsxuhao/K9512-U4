package com.team.house.housebackapi.controller;

import com.team.house.housebackapi.entity.Users;
import com.team.house.housebackapi.service.UsersService;
import com.team.house.housebackapi.util.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user/")
//@CrossOrigin(origins = "*",allowCredentials ="true")
public class UserController {
    @Autowired
    private UsersService usersService;
    @RequestMapping("regUser")
    public BaseResult regUser(Users users){
        int user = usersService.regUser(users);
        if (user>0){
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }else {
            return new BaseResult(BaseResult.RESULT_FAIL,"出错啦");
        }
    }
    @RequestMapping("userLogin")
    public BaseResult userLogin(String username, String password, HttpSession session){
        Users login = usersService.Login(username, password);
        if (login==null){
            return new BaseResult(BaseResult.RESULT_FAIL,"用户密码不正确");
        }else {
            session.setAttribute("logininfo",login);
            session.setMaxInactiveInterval(6000);
            return new BaseResult(BaseResult.RESULT_SUCCESS,"");
        }
    }
}
