package com.ptmind.ptengine.service.impl;

import com.ptmind.ptengine.mapper.UserInfoMapper;
import com.ptmind.ptengine.model.UserInfo;
import com.ptmind.ptengine.service.PtengineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PtengineServiceImpl implements PtengineService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    /**
     * 获取shop
     */
    public UserInfo getShop(int id) {
        return userInfoMapper.selectByPrimaryKey("1");
    }
}