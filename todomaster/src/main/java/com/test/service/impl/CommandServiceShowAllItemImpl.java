package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.CommandService;
import com.test.service.PrintService;
import com.test.service.ProcessItemservice;

import java.io.IOException;
import java.util.List;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/31 8:07
 */
public class CommandServiceShowAllItemImpl implements CommandService {
    ProcessItemservice processItemservice;
    PrintService consoleService;

    public CommandServiceShowAllItemImpl(ProcessItemservice processItemservice, PrintService consoleService) {
        this.processItemservice = processItemservice;
        this.consoleService = consoleService;
    }

    @Override
    public void doCommand(String[] args) throws IOException {
        List<Item> allItems = processItemservice.getAllItems();
        consoleService.printAllItems(allItems);
    }
}
