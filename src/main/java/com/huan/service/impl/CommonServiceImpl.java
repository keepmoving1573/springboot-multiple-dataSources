package com.huan.service.impl;

import com.huan.model.UserDetail;
import com.huan.model.UserInfo;
import com.huan.service.CommonService;
import com.huan.service.Test1Service;
import com.huan.service.Test2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/7/5 - 22:20
 */
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private Test1Service test1Service;
    @Autowired
    private Test2Service test2Service;

    public List<UserInfo> selectUserInfo() {
        return test1Service.selectUserInfo();
    }

    public List<UserDetail> selectUserDetail() {
        return test2Service.selectUserDetail();
    }
}
