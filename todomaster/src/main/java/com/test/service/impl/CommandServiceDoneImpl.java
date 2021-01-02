package com.test.service.impl;

import com.test.service.CommandService;
import com.test.service.ProcessItemservice;
import com.test.service.PreparePrintService;
import com.test.service.PrintService;

import java.io.IOException;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/30 7:55
 */
public class CommandServiceDoneImpl implements CommandService {
    ProcessItemservice addService;
    PrintService consoleService;

    public CommandServiceDoneImpl(ProcessItemservice addService, PreparePrintService preparePrintService, PrintService consoleService) {
        this.addService = addService;
        this.consoleService = consoleService;
    }

    @Override
    public void doCommand(String name) throws IOException {
        int doneIndex = Integer.parseInt(name);
        addService.done(doneIndex);
        consoleService.printOneItemDone(doneIndex);
    }
}
