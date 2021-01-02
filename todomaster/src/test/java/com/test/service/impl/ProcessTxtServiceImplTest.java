package com.test.service.impl;

import com.test.bo.Item;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessTxtServiceImplTest {
    ProcessTxtServiceImpl processTxtService;

    @DisplayName("give a new todos file")
    @Nested
    public class CleanFile {
        @BeforeEach
        void setUp() {
            processTxtService = new ProcessTxtServiceImpl();
            TodoJsonFileUtils todoFieUtils = new TodoJsonFileUtils();
            try {
                todoFieUtils.cleanFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Test
        void should_get_three_dotos_and_fist_done() throws IOException {
            processTxtService.add(new Item("apple"));
            processTxtService.add(new Item("banana"));
            processTxtService.add(new Item("cat"));
            File todoFile = new File("C:/data/todoList.json");
            assertEquals(true, todoFile.exists());
            processTxtService.done(1L);
            List<Item> allItems = processTxtService.getAllItems();
            assertEquals(3, allItems.size());
            assertTrue(allItems.get(0).getDone());
            assertTrue(!allItems.get(1).getDone());
        }
    }

}