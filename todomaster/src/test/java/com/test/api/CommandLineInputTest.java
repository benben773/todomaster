package com.test.api;

import com.test.service.impl.CommandLineInput;
import com.test.service.ICommandLineInputSerivce;
import com.test.service.impl.ConsolePrintServiceImpl;
import com.test.service.TodoListService;
import org.junit.jupiter.api.Test;

class CommandLineInputTest {
    @Test
    public void should_process_command(){

        String[] args = {"todo", "add", "<item>"};
        ICommandLineInputSerivce ICommandLineInputSerivce = new CommandLineInput(new TodoListService(),new ConsolePrintServiceImpl());
        ICommandLineInputSerivce.parseTodoCommandAndprint(args);

    }

}