package com.test.service.impl;

import com.test.bo.UserBo;
import com.test.service.CommandService;
import com.test.service.PrintService;
import com.test.service.ProcessItemservice;
import com.test.service.UserInfoSerivce;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author ：ls05
 * @date ：Created in 2021/1/2 17:48
 */
public class CommandLoginServiceImpl implements CommandService {
    ProcessItemservice processItemservice;
    PrintService consoleService;
    UserInfoSerivce userInfoSerivce;

    public CommandLoginServiceImpl(ProcessItemservice processItemservice, PrintService consoleService) {
        this.processItemservice = processItemservice;
        this.consoleService = consoleService;
        userInfoSerivce = new UserInfoXmlSerivceImpl();
    }

    @Override
    public void doCommand(String[] args) throws IOException {
        System.out.println("Password:");
        String userName = args[3];
        boolean contains = userInfoSerivce.getUserInfo().stream().map(UserBo::getName).collect(Collectors.toList())
                .contains(userName);
        if (!contains) {
            System.out.println("Login error!");
            return;
        }
        Scanner reader = new Scanner(System.in);
        String password = reader.nextLine();
        Optional<UserBo> any = userInfoSerivce.getUserInfo().stream().filter(userBo -> userBo.getName().equals(userName) && userBo.getPassword().equals(password)).findAny();
        if (any.isPresent()) {
            userInfoSerivce.writeCurrentUserInof(any.get().getIndex());
            System.out.println("Login success!");
        } else {
            System.out.println("password error!");
        }
    }
}
