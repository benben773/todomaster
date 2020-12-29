package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.*;

import java.util.List;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/29 7:06
 */
public class CommandLineInput implements ICommandLineInputSerivce {
    IAddService addService;
    IpreparePrintService preparePrintService;
    PrintService consoleService;

    public CommandLineInput(TodoListService todoListService, PrintService consoleService) {
        this.addService = todoListService;
        this.preparePrintService = todoListService;
        this.consoleService = consoleService;
    }


    @Override
    public void parseTodoCommandAndprint(String[] args) {
        Parse parse = new Parse();
        final Command command = parse.parseArray(args);
        if (Command.CommandEnum.ADD.equals(command.getCommandType())) {
            addService.add(new Item(args[2]));
            List<String> todoItems = preparePrintService.getAllTodoItems();
            Long lastAddIndex = preparePrintService.getLastAddIndex();
            consoleService.prinAdd(todoItems, lastAddIndex);
        } else if (Command.CommandEnum.DONE.equals(command.getCommandType())) {
            int doneIndex = Integer.parseInt(args[2]);
            addService.done(doneIndex);
            consoleService.prinDone(doneIndex);
        } else {
            throw new IllegalArgumentException("error input command!");
        }

    }
}
