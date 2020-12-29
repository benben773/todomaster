package com.test.service.impl;

import com.test.service.ICommandLineInputSerivce;
import com.test.service.TodoListService;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/29 7:06
 */
public class CommandLineInputProx implements ICommandLineInputSerivce {

    private final ICommandLineInputSerivce serivce = new CommandLineInput(new TodoListService(),new ConsolePrintServiceImpl());

    @Override
    public void parseTodoCommandAndprint(String[] args) {
        serivce.parseTodoCommandAndprint(args);
    }
}
