package com.test.service.impl;

import com.test.bo.Item;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CommandLoginServiceImplTest {
    CommandLoginServiceImpl commandLoginService = new CommandLoginServiceImpl(new ProcessTxtServiceImpl(),new ConsolePrintServiceImpl());

    TodoJsonFileUtils todoFieUtils = new TodoJsonFileUtils();
    @Test
    @Disabled
    void name() throws IOException {
        String userIndex = todoFieUtils.getLoginUserIndex();
        assertEquals(2,userIndex);
    }
}