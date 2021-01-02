package com.test.service.impl;

import com.test.service.ExecuService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedList;

class ExecuteServiceImplTest {

    @ParameterizedTest
    @CsvSource({
            "todo add apple,todo add banana,todo done 1",
            "todo add apple,todo add banana,todo done 2",
            "todo add apple,todo add banana,todo list --all",
            "todo add apple,todo add banana,todo login -u user",
            "todo add apple,todo done 1,todo list --all"
    })
    public void should_get_item_done(String arg1,String arg2,String arg3) {
        LinkedList<String[] > inputs = new LinkedList<>();
        inputs.add(arg1.split(" "));
        inputs.add(arg2.split(" "));
        inputs.add(arg3.split(" "));
        this.processCommand(inputs);
    }
    @Test
    public void should_show_todo_item() {
        LinkedList<String[] > inputs = new LinkedList<>();
        inputs.add("todo add apple".split(" "));
        inputs.add("todo add banana".split(" "));
        inputs.add("todo done 1".split(" "));
        inputs.add("todo list".split(" "));
        this.processCommand(inputs);
    }

    private void processCommand(LinkedList<String[]> inputs) {
        ExecuService commandService = new ExecuServiceProxy();
        inputs.forEach(commandService::execute);
    }
}