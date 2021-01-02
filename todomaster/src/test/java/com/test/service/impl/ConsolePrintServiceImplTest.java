package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.ProcessItemservice;
import com.test.service.PrintService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsolePrintServiceImplTest {
    PrintService consolePrintService = new ConsolePrintServiceImpl();
    ProcessItemservice processItemservice = new ProcessServiceImpl();

    @BeforeEach
    void setUp() {
        ProcessServiceImpl.todos = new HashMap<>();
    }

    @Test
    void printAllItem() throws IOException {
        processItemservice.add(new Item("apple"));
        processItemservice.add(new Item("apple1"));
        processItemservice.add(new Item("appledone"));
        processItemservice.done(3L);
        List<Item> allItems = processItemservice.getAllItems();
        assertEquals(3, allItems.size());
        assertEquals(true, allItems.get(2).getDone());
        assertEquals(false, allItems.get(1).getDone());
        assertEquals(false, allItems.get(0).getDone());
        consolePrintService.printAllItems(allItems);
    }
}