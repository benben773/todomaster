package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.CommandService;
import com.test.service.ProcessItemservice;
import com.test.service.PreparePrintService;
import com.test.service.PrintService;

import java.util.List;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/30 7:55
 */
public class CommandServiceShowTodoImpl implements CommandService {
    ProcessItemservice processItemservice;
    PreparePrintService preparePrintService;
    PrintService consoleService;

    public CommandServiceShowTodoImpl(ProcessItemservice addService, PreparePrintService preparePrintService, PrintService consoleService) {
        this.processItemservice = addService;
        this.preparePrintService = preparePrintService;
        this.consoleService = consoleService;
    }

    @Override
    public void doCommand(String name) {
        List<Item> todoItems = preparePrintService.getTodoItems(processItemservice.getAllItems());
        consoleService.printTodoItems(todoItems);
    }
}
