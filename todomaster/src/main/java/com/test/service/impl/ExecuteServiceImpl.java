package com.test.service.impl;

import com.test.bo.Command;
import com.test.service.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/29 7:06
 */
public class ExecuteServiceImpl implements ExecuService {
    ProcessItemservice addService;
    PreparePrintService preparePrintService;
    PrintService consoleService;
    Map<Command.CommandEnum, CommandService> CommandServiceMap = new HashMap<>();

    public ExecuteServiceImpl(ProcessItemservice addService, PreparePrintService preparePrintService, PrintService consoleService) {
        this.addService = addService;
        this.preparePrintService = preparePrintService;
        this.consoleService = consoleService;
        CommandServiceMap.put(Command.CommandEnum.add, new CommandServiceAddImpl(addService, preparePrintService, consoleService));
        CommandServiceMap.put(Command.CommandEnum.done, new CommandServiceDoneImpl(addService, preparePrintService, consoleService));
        CommandServiceMap.put(Command.CommandEnum.list, new CommandServiceShowTodoImpl(addService,preparePrintService, consoleService));
        CommandServiceMap.put(Command.CommandEnum.listall, new CommandServiceShowAllItemImpl(addService, consoleService));
        CommandServiceMap.put(Command.CommandEnum.loginu, new CommandLoginServiceImpl(addService, consoleService));
        CommandServiceMap.put(Command.CommandEnum.logout, new CommandLogoutServiceImpl(addService, consoleService));
    }

    @Override
    public void execute(String[] args) {
        Parse parse = new Parse();
        final Command command = parse.parseArray(args);
        if (!CommandServiceMap.keySet().contains(command.getCommandType())) {
            throw new IllegalArgumentException("error input command!");
        }
        try {
            CommandServiceMap.get(command.getCommandType()).doCommand(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
