package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.ProcessItemservice;
import com.test.service.PrintService;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConsolePrintServiceImplTest {
    PrintService consolePrintService = new ConsolePrintServiceImpl();
    ProcessItemservice processItemservice = new ProcessServiceImpl();


    @Test
    void printAllItem() {
        processItemservice.add(new Item("apple"));
        processItemservice.add(new Item("apple1"));
        processItemservice.add(new Item("appledone"));
        processItemservice.done(3L);
        List<Item> allItems = processItemservice.getAllItems();
        assertEquals(3, allItems.size());
        assertEquals(true, allItems.get(2).getDoneStatus());
        assertEquals(false, allItems.get(1).getDoneStatus());
        assertEquals(false, allItems.get(0).getDoneStatus());
        consolePrintService.printAllItems(allItems);
    }
}