package com.huan.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huan on 2016/5/21.
 */
@RestController
public class WelcomeController {

    @RequestMapping("/")
    public Map welcome() {
        Map model = new HashMap();
        model.put("time", new Date());
        model.put("message", "Hello World");
        return model;
    }

}