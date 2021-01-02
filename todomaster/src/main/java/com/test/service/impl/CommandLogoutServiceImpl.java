package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.*;

import java.io.IOException;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/30 7:39
 */
public class CommandLogoutServiceImpl implements CommandService {
    ProcessItemservice processItemservice;
    PrintService consoleService;
    UserInfoSerivce userInfoSerivce;
    public CommandLogoutServiceImpl(ProcessItemservice addService, PrintService consoleService) {
        this.processItemservice = addService;
        this.consoleService = consoleService;
        userInfoSerivce = new UserInfoXmlSerivceImpl();
    }

    @Override
    public void doCommand(String[] args) throws IOException {
        userInfoSerivce.writeCurrentUserInof("-1");
    }
}
