package com.ptmind.ptengine.service.impl;

import com.ptmind.ptengine.model.UserDetail;
import com.ptmind.ptengine.model.UserInfo;
import com.ptmind.ptengine.service.DataTransferService;
import com.ptmind.ptengine.service.PtengineService;
import com.ptmind.ptengine.service.PtmindCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/7/5 - 22:20
 */
@Service
public class DataTransferServiceImpl implements DataTransferService {

    @Autowired
    private PtengineService ptengineService;
    @Autowired
    private PtmindCommonService ptmindCommonService;

    public UserInfo selectUser(int id) {
        return ptengineService.getShop(1);
    }

    public UserDetail selectUserDetail(int id) {
        return ptmindCommonService.selectUserDetail(1);
    }
}
