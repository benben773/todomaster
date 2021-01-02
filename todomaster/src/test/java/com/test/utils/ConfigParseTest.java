package com.test.utils;

import com.test.bo.UserBo;
import com.test.service.UserInfoSerivce;
import com.test.service.impl.UserInfoXmlSerivceImpl;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author ：ls05
 * @date ：Created in 2021/1/2 15:39
 */
public class ConfigParseTest {
    @Test
    void name() throws ConfigurationException {
        UserInfoSerivce configs = new UserInfoXmlSerivceImpl();
        List<UserBo> userInfos = configs.getUserInfo();
        Assertions.assertEquals(2, userInfos.size());
        Assertions.assertEquals("ls1", userInfos.get(1).getName());
    }
}
