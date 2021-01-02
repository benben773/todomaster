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
public class CommandLineInput implements CommandLineInputSerivce {
    ProcessItemservice addService;
    PreparePrintService preparePrintService;
    PrintService consoleService;
    CommandService CommandService ;
    Map<Command.CommandEnum, CommandService> CommandServiceMap = new HashMap<>();

    public CommandLineInput(ProcessItemservice addService, PreparePrintService preparePrintService, PrintService consoleService) {
        this.addService = addService;
        this.preparePrintService = preparePrintService;
        this.consoleService = consoleService;
        CommandServiceMap.put(Command.CommandEnum.ADD, new CommandServiceAddImpl(addService, preparePrintService, consoleService));
        CommandServiceMap.put(Command.CommandEnum.DONE, new CommandServiceDoneImpl(addService, preparePrintService, consoleService));
        CommandServiceMap.put(Command.CommandEnum.SHOW_TODOS, new CommandServiceShowTodoImpl(addService,preparePrintService, consoleService));
        CommandServiceMap.put(Command.CommandEnum.SHOW_ALL_ITEM, new CommandServiceShowAllItemImpl(addService, consoleService));
    }

    @Override
    public void parseTodoCommandAndprint(String[] args) {
        Parse parse = new Parse();
        final Command command = parse.parseArray(args);
        if (!CommandServiceMap.keySet().contains(command.getCommandType())) {
            throw new IllegalArgumentException("error input command!");
        }
        String name = args.length > 2 ? args[2] : "";
        try {
            CommandServiceMap.get(command.getCommandType()).doCommand(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
