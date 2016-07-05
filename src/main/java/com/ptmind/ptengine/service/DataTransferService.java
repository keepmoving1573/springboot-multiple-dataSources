package com.ptmind.ptengine.service;

import com.ptmind.ptengine.model.UserInfo;

/**
 * @author <a href="mailto:huanhuan.zhan@ptthink.com">詹欢欢</a>
 * @since 2016/7/5 - 22:20
 */
public interface DataTransferService {
    UserInfo selectUser(int id);
}
