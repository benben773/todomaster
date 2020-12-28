package com.test;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:28
 */
public class AddTodoListTest {
    @Test
    public void should_add_one_item_to_empty_itemEntity(){

        TodoListService todoListService = new TodoListService();
        todoListService.add(new Item("name"));
        List<Item> todo =  todoListService.getAllTodo();
        assertThat(todo).isNotNull();
    }

}
