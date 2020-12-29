package com.test.api;

import com.test.service.impl.CommandLineInputProx;
import com.test.service.ICommandLineInputSerivce;

import java.util.Arrays;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/30 3:03
 */
public class TodoApi {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        ICommandLineInputSerivce commandService = new CommandLineInputProx();
        commandService.parseTodoCommandAndprint(args);
    }
}
