package com.test.service.impl;

import com.test.service.ExecuService;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/29 7:06
 */
public class ExecuServiceProxy implements ExecuService {

    private final ExecuService serivce = new ExecuteServiceImpl(new ProcessTxtServiceImpl(),new PrepareServiceImpl(),new ConsolePrintServiceImpl());

    @Override
    public void execute(String[] args) {
        serivce.execute(args);
    }
}
