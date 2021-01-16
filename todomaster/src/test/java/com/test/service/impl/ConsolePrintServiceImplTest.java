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
    ProcessItemservice processItemservice = new ProcessTxtServiceImpl();

    @BeforeEach
    void setUp() throws IOException {
        TodoJsonFileUtils todoFieUtils = new TodoJsonFileUtils();
        todoFieUtils.cleanFile();
    }

    @Test
    void printAllItem() throws IOException {
        processItemservice.addUserItem(new Item("apple"));
        processItemservice.addUserItem(new Item("apple1"));
        processItemservice.addUserItem(new Item("appledone"));
        processItemservice.done(3L);
        List<Item> allItems = processItemservice.getAllItems();
        assertEquals(3, allItems.size());
        assertEquals(true, allItems.get(2).getDone());
        assertEquals(false, allItems.get(1).getDone());
        assertEquals(false, allItems.get(0).getDone());
        consolePrintService.printAllItems(allItems);
    }
}