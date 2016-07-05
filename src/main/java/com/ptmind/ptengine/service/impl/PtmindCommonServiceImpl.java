package com.ptmind.ptengine.service.impl;

import com.ptmind.ptengine.mapper.UserDetailMapper;
import com.ptmind.ptengine.model.UserDetail;
import com.ptmind.ptengine.service.PtmindCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/7/5 - 22:21
 */
@Service
public class PtmindCommonServiceImpl implements PtmindCommonService {

    @Autowired
    private UserDetailMapper userDetailMapper;

    public UserDetail selectUserDetail(int i) {
        UserDetail userDetail = new UserDetail();
        userDetail.setId(1L);
        return userDetailMapper.selectByPrimaryKey(userDetail);
    }
}
