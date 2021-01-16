package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.CommandService;
import com.test.service.ProcessItemservice;
import com.test.service.PrintService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/30 7:55
 */
public class CommandServiceShowTodoImpl implements CommandService {
    ProcessItemservice processItemservice;
    PrintService consoleService;

    public CommandServiceShowTodoImpl(ProcessItemservice addService, PrintService consoleService) {
        this.processItemservice = addService;
        this.consoleService = consoleService;
    }

    @Override
    public void doCommand(String[] args) throws IOException {
        List<Item> todoItems = this.getTodoItems(processItemservice.getUserItems());
        consoleService.printTodoItems(todoItems);
    }
    private List<Item> getTodoItems(List<Item> items) {
        List<Item> collect = items.stream().filter(o -> {
            return !o.getDone();
        }).collect(Collectors.toList());
        return collect;
    }
}
