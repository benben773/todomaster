package com.test.api;

import com.test.service.impl.CommandLineInputProxy;
import com.test.service.CommandLineInputSerivce;

import java.util.Arrays;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/30 3:03
 */
public class TodoApi {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        CommandLineInputSerivce commandService = new CommandLineInputProxy();
        commandService.parseTodoCommandAndprint(args);
    }
}
