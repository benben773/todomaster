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
    ProcessItemservice processItemservice;
    PrintService printService;
    Map<Command.CommandEnum, CommandService> CommandServiceMap = new HashMap<>();

    public ExecuteServiceImpl(ProcessItemservice processItemservice, PrintService printService) {
        this.processItemservice = processItemservice;
        this.printService = printService;
        CommandServiceMap.put(Command.CommandEnum.add, new CommandAddServiceAddImpl(processItemservice, printService));
        CommandServiceMap.put(Command.CommandEnum.done, new CommandServiceDoneImpl(processItemservice, printService));
        CommandServiceMap.put(Command.CommandEnum.list, new CommandServiceShowTodoImpl(processItemservice, printService));
        CommandServiceMap.put(Command.CommandEnum.listall, new CommandServiceShowAllItemImpl(processItemservice, printService));
        CommandServiceMap.put(Command.CommandEnum.loginu, new CommandLoginServiceImpl(processItemservice, printService));
        CommandServiceMap.put(Command.CommandEnum.logout, new CommandLogoutServiceImpl(processItemservice, printService));
    }

    @Override
    public void execute(String[] args) throws IOException {
        Parse parse = new Parse();
        final Command command = parse.parseArray(args);
        if (!CommandServiceMap.keySet().contains(command.getCommandType())) {
            throw new IllegalArgumentException("error input command!");
        }
        CommandServiceMap.get(command.getCommandType()).doCommand(args);
    }


}
