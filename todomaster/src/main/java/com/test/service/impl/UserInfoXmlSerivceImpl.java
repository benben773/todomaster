package com.test.service.impl;

import com.test.bo.CurrentUserBo;
import com.test.bo.UserBo;
import com.test.service.UserInfoSerivce;
import org.apache.commons.configuration2.XMLConfiguration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：ls05
 * @date ：Created in 2021/1/2 16:22
 */
public class UserInfoXmlSerivceImpl implements UserInfoSerivce {

    public static final String USER_CONFIG_XML = "user-config.xml";
    public static final String todo_config_path = System.getProperty("user.home") +"/.todo-config";

    @Override
    public List<UserBo> getUserInfo() {
        Configurations configs = new Configurations();
        XMLConfiguration config = null;
        try {
            config = configs.xml(USER_CONFIG_XML);
            List<String> list = config.getList(String.class, "userInfos.user");
            return list.stream().map(s -> {
                String[] userInfos = s.split(",");
                return new UserBo(userInfos[0],userInfos[1],userInfos[2]);
            }).collect(Collectors.toList());

        } catch (ConfigurationException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public CurrentUserBo writeCurrentUserInof(String userId) {
        TodoJsonFileUtils<CurrentUserBo> todoFieUtils = new TodoJsonFileUtils();
        ArrayList<CurrentUserBo> currentUserBos = new ArrayList<>();
        CurrentUserBo bo = new CurrentUserBo(userId);
        currentUserBos.add(bo);
        try {
            todoFieUtils.writeCollectionToFile(currentUserBos,todo_config_path);
            return bo;
        } catch (IOException e) {
            e.printStackTrace();
            return new CurrentUserBo(null);
        }
    }
}
