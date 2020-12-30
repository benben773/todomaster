package com.test.service.impl;

import com.test.service.CommandLineInputSerivce;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/29 7:06
 */
public class CommandLineInputProxy implements CommandLineInputSerivce {

    private final CommandLineInputSerivce serivce = new CommandLineInput(new TodoListServiceImpl(),new TodoListServiceImpl(),new ConsolePrintServiceImpl());

    @Override
    public void parseTodoCommandAndprint(String[] args) {
        serivce.parseTodoCommandAndprint(args);
    }
}
