package com.test.service.impl;

import com.test.bo.CurrentUserBo;
import com.test.service.UserInfoSerivce;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserInfoXmlSerivceImplTest {
    UserInfoSerivce userInfoXmlSerivce = new UserInfoXmlSerivceImpl();

    @Test
    void should_set_currentUser_info() {
        CurrentUserBo bo = userInfoXmlSerivce.writeCurrentUserInof( "userId");
        assertNotNull(bo);
    }
}