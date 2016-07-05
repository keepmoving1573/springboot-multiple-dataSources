package com.ptmind.ptengine.controller;

import com.ptmind.ptengine.model.UserDetail;
import com.ptmind.ptengine.model.UserInfo;
import com.ptmind.ptengine.service.DataTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "dataTransferController")
@RequestMapping("/test")
public class DataTransferController {

    @Autowired
    private DataTransferService dataTransferService;

    @RequestMapping(value = "/ptengine", method = RequestMethod.GET)
    public UserInfo selectUser() {
        System.out.println("--------------");
        return dataTransferService.selectUser(1);
    }

    @RequestMapping(value = "/ptmindCommon", method = RequestMethod.GET)
    public UserDetail userDetail() {
        System.out.println("--------------");
        return dataTransferService.selectUserDetail(1);
    }

}