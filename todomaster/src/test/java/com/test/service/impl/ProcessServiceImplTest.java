package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.PreparePrintService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProcessServiceImplTest {
    ProcessServiceImpl processService;
    PreparePrintService prepareService = new PrepareServiceImpl();

    @BeforeEach
    void setUp() {
        processService = new ProcessServiceImpl();
        ProcessServiceImpl.todos = new HashMap<>();
    }

    @Test
    void getTodoItems() {
        processService.add(new Item("apple"));
        processService.add(new Item("banana"));
        processService.add(new Item("cat"));
        processService.done(1);
        List<Item> todoItems = prepareService.getTodoItems(processService.getAllItems());

        assertEquals(2,todoItems.size());
        assertEquals("banana",todoItems.get(0).getName());
        assertEquals("cat",todoItems.get(1).getName());
    }
}