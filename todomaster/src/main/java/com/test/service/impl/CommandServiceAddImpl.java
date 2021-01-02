package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.CommandService;
import com.test.service.PreparePrintService;
import com.test.service.PrintService;
import com.test.service.ProcessItemservice;

import java.io.IOException;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/30 7:39
 */
public class CommandServiceAddImpl implements CommandService {
    ProcessItemservice processItemservice;
    PreparePrintService preparePrintService;
    PrintService consoleService;
    public CommandServiceAddImpl(ProcessItemservice addService, PreparePrintService preparePrintService, PrintService consoleService) {
        this.processItemservice = addService;
        this.preparePrintService = preparePrintService;
        this.consoleService = consoleService;
    }

    @Override
    public void doCommand(String[] args) throws IOException {
        Item itemAdded = processItemservice.add(new Item(args[2]));
        consoleService.printAdd(itemAdded);
    }
}
