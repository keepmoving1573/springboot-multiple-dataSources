package com.ptmind.ptengine.controller;

import com.ptmind.ptengine.model.UserInfo;
import com.ptmind.ptengine.service.DataTransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shop")
public class DataTransferController {

    @Autowired
    private DataTransferService dataTransferService;

    @RequestMapping(value = "/getShop", method = RequestMethod.GET)
    public UserInfo selectUser(@RequestParam("id") int id) {
        System.out.println("--------------");
        return dataTransferService.selectUser(id);
    }

}