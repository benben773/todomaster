package com.test.service.impl;

import com.test.bo.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TodoListServiceImplTest {
    TodoListServiceImpl todoListService;

    @BeforeEach
    void setUp() {
        todoListService  = new TodoListServiceImpl();
    }

    @Test
    void getTodoItems() {
        todoListService.add(new Item("apple"));
        todoListService.add(new Item("banana"));
        todoListService.add(new Item("cat"));
        todoListService.done(1);
        List<Item> todoItems = todoListService.getTodoItems();
        assertEquals(2,todoItems.size());
        assertEquals("banana",todoItems.get(0).getName());
        assertEquals("cat",todoItems.get(1).getName());
    }
}