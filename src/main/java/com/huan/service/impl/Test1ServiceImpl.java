package com.huan.service.impl;

import com.huan.mapper.UserInfoMapper;
import com.huan.model.UserInfo;
import com.huan.service.Test1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Test1ServiceImpl implements Test1Service {

    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> selectUserInfo() {
        return userInfoMapper.selectAll();
    }
}