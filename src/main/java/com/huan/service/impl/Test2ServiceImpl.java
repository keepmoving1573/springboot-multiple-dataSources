package com.huan.service.impl;

import com.huan.mapper.UserDetailMapper;
import com.huan.model.UserDetail;
import com.huan.service.Test2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/7/5 - 22:21
 */
@Service
public class Test2ServiceImpl implements Test2Service {

    @Autowired
    private UserDetailMapper userDetailMapper;

    public List<UserDetail> selectUserDetail() {
        return userDetailMapper.selectAll();
    }
}
