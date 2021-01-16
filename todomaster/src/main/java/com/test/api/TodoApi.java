package com.test.api;

import com.test.service.impl.ExecuServiceProxy;
import com.test.service.ExecuService;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/30 3:03
 */
public class TodoApi {

    public static void main(String[] args) throws IOException {
        System.out.println(Arrays.toString(args));
        ExecuService commandService = new ExecuServiceProxy();
        commandService.execute(args);
    }
}
