package com.test.service.impl;

import com.test.bo.CurrentUserBo;
import com.test.service.UserInfoSerivce;
import com.test.util.TodoException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserInfoXmlSerivceImplTest {
    UserInfoSerivce userInfoXmlSerivce = new UserInfoXmlSerivceImpl();

    @Test
    void should_set_currentUser_info() {
        CurrentUserBo bo = userInfoXmlSerivce.writeCurrentUserInfo( "userId");
        assertNotNull(bo);
    }

    @Test
    void should_get_login_error_with_erro_password() {
        TodoException throwsError = assertThrows(TodoException.class, () -> userInfoXmlSerivce.login("ls1", "123"));
        assertEquals(TodoException.LOGIN_PASSWORD_ERROR,throwsError.getMessage());
    }
    @Test
    void should_get_login() {
        userInfoXmlSerivce.login("1", "1234");
        CurrentUserBo userInfo = userInfoXmlSerivce.getCurrentUserInfo();
        assertEquals("test11",userInfo.getIndex());
    }
}