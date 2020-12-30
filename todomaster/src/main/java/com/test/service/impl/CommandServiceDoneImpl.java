package com.test.service.impl;

import com.test.service.CommandService;
import com.test.service.PorcessItemservice;
import com.test.service.PreparePrintService;
import com.test.service.PrintService;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/30 7:55
 */
public class CommandServiceDoneImpl implements CommandService {
    PorcessItemservice addService;
    PreparePrintService preparePrintService;
    PrintService consoleService;

    public CommandServiceDoneImpl(PorcessItemservice addService, PreparePrintService preparePrintService, PrintService consoleService) {
        this.addService = addService;
        this.preparePrintService = preparePrintService;
        this.consoleService = consoleService;
    }

    @Override
    public void doCommand(String name) {
        int doneIndex = Integer.parseInt(name);
        addService.done(doneIndex);
        consoleService.prinDone(doneIndex);
    }
}
