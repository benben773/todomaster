package com.test.service;

import com.test.bo.CurrentUserBo;
import com.test.bo.UserBo;

import java.util.List;

public interface UserInfoSerivce {
    List<UserBo> getUserInfo();

    CurrentUserBo writeCurrentUserInof(String userId);
}
