package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.CommandService;
import com.test.service.PorcessItemservice;
import com.test.service.PreparePrintService;
import com.test.service.PrintService;

import java.util.List;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/30 7:39
 */
public class CommandServiceAddImpl implements CommandService {
    PorcessItemservice addService;
    PreparePrintService preparePrintService;
    PrintService consoleService;
    public CommandServiceAddImpl(PorcessItemservice addService, PreparePrintService preparePrintService, PrintService consoleService) {
        this.addService = addService;
        this.preparePrintService = preparePrintService;
        this.consoleService = consoleService;
    }

    @Override
    public void doCommand(String name) {
        addService.add(new Item(name));
        List<Item> todoItems = preparePrintService.getAllItems();
        Long lastAddIndex = preparePrintService.getLastAddIndex();
        consoleService.prinAdd(todoItems, lastAddIndex);
    }
}
