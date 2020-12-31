package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.CommandService;
import com.test.service.ProcessItemservice;
import com.test.service.PreparePrintService;
import com.test.service.PrintService;

import java.util.List;

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
    public void doCommand(String name) {
        Item itemAdded = processItemservice.add(new Item(name));
        consoleService.printAdd(itemAdded);
    }
}
