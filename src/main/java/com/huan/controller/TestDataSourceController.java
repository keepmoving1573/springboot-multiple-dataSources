package com.huan.controller;

import com.huan.model.UserDetail;
import com.huan.model.UserInfo;
import com.huan.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestDataSourceController {

    @Autowired
    private CommonService commonService;

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    public List<UserInfo> selectUser() {
        System.out.println("查询第一个数据源");
        return commonService.selectUserInfo();
    }

    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public List<UserDetail> userDetail() {
        System.out.println("查询第二个数据源");
        return commonService.selectUserDetail();
    }

}