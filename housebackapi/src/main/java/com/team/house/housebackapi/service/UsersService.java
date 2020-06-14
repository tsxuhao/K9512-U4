package com.team.house.housebackapi.service;

import com.team.house.housebackapi.entity.Users;

public interface UsersService {
    //注册
    public int regUser(Users users);
    //登录
    public Users Login(String username,String password);
}
