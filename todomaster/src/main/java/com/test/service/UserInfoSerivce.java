package com.test.service;

import com.test.bo.CurrentUserBo;
import com.test.bo.UserBo;

import java.util.List;

public interface UserInfoSerivce {
    List<UserBo> getUserInfos();

    CurrentUserBo writeCurrentUserInfo(String userId);
    CurrentUserBo getCurrentUserInfo();

    void login(String userName,String password);
}
