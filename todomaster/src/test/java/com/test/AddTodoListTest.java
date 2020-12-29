package com.test;

import com.sun.deploy.util.ArrayUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import static org.junit.jupiter.api.Assertions.assertAll;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:28
 */
public class AddTodoListTest {
    @Test
    public void should_add_one_item_to_empty_itemEntity() {
        TodoListService todoListService = new TodoListService();
        todoListService.add(new Item("name"));
        Map<Long,Item> todo = todoListService.getAllTodo();
        assertThat(todo.get(1L)).isNotNull();
    }

    @Test
    public void should_parse_intput_array() {
        String[] args = {"todo", "add", "<item>"};
        Parse parse = new Parse();
        final Command command = parse.parseArray(args);
        Assertions.assertEquals(Command.CommandEnum.ADD, command.getCommandType());
        Assertions.assertEquals("item", command.getTodoItem());
    }
    @Test
    public void should_print_correct_info(){
        TodoListService todoListService = new TodoListService();
        String value = "name1";
        todoListService.add(new Item(value));
        List<String> strAllTodoItems = todoListService.getAllTodoItems();
        Long lastAddIndex = todoListService.getLastAddIndex();
        Assertions.assertEquals(1L, lastAddIndex);
        Assertions.assertEquals(value, strAllTodoItems.get(0));
    }

}
