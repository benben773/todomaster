package com.test.service;

import java.io.IOException;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/30 7:40
 */
public interface CommandService {
    void doCommand(String name) throws IOException;
}
