package com.test.service.impl;

import com.test.service.ICommandLineInputSerivce;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandLineInputTest {

    @Test
    public void should_get_item_done() {
        ICommandLineInputSerivce commandService = new CommandLineInputProx();
        String[] args = {"todo","add","apple"};
        commandService.parseTodoCommandAndprint(args);
        String[] args1 = {"todo","done","1"};
        commandService.parseTodoCommandAndprint(args1);

    }
}