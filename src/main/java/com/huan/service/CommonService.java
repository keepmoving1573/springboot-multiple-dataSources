package com.huan.service;

import com.huan.model.UserDetail;
import com.huan.model.UserInfo;

import java.util.List;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/7/5 - 22:20
 */
public interface CommonService {
    List<UserInfo> selectUserInfo();

    List<UserDetail> selectUserDetail();
}
