package com.test.service.impl;

import com.test.bo.Item;
import com.test.util.TodoException;
import org.junit.jupiter.api.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
            processTxtService.addUserItem(new Item("apple"));
            processTxtService.addUserItem(new Item("banana"));
            processTxtService.addUserItem(new Item("cat"));
            File todoFile = new File("C:/data/todoList.json");
            assertEquals(true, todoFile.exists());
            processTxtService.done(1L);
            List<Item> allItems = processTxtService.getUserItems();
            assertEquals(3, allItems.size());
            assertTrue(allItems.get(0).getDone());
            assertTrue(!allItems.get(1).getDone());
        }
        @Test
        void should_get_error_when_error_done_index() throws IOException {
            processTxtService.addUserItem(new Item("apple"));
            processTxtService.addUserItem(new Item("banana"));
            processTxtService.addUserItem(new Item("cat"));
            File todoFile = new File("C:/data/todoList.json");
            assertEquals(true, todoFile.exists());
            TodoException todoException = assertThrows(TodoException.class, () -> processTxtService.done(4L));
            assertEquals("用户无此代办事项",todoException.getMessage().substring(0,8));
        }
    }

}