package com.test;

import com.test.bo.Item;
import com.test.bo.Command;
import com.test.service.Parse;
import com.test.service.impl.ProcessServiceImpl;
import com.test.service.impl.ConsolePrintServiceImpl;
import com.test.service.PrintService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:28
 */
public class AddTodoListTest {
    @Test
    public void should_add_one_item_to_empty_itemEntity() {
        ProcessServiceImpl processServiceImpl = new ProcessServiceImpl();
        processServiceImpl.add(new Item("name"));
        Map<Long,Item> todo = processServiceImpl.getAllTodosByKey();
        assertThat(todo.get(1L)).isNotNull();
    }

    @Test
    public void should_parse_todo_intput_array() {
        String[] args = {"todo", "add", "<item>"};
        Parse parse = new Parse();
        final Command command = parse.parseArray(args);
        Assertions.assertEquals(Command.CommandEnum.ADD, command.getCommandType());
        Assertions.assertEquals("<item>", command.getTodoItem());
    }
    @Test
    public void should_parse_show_list_array() {
        String[] args = {"todo", "list"};
        Parse parse = new Parse();
        final Command command = parse.parseArray(args);
        Assertions.assertEquals(Command.CommandEnum.SHOW_TODOS, command.getCommandType());
    }
    @Test
    public void should_parse_done_intput_array() {
        String[] args = {"todo", "done", "1"};
        Parse parse = new Parse();
        final Command command = parse.parseArray(args);
        Assertions.assertEquals(Command.CommandEnum.DONE, command.getCommandType());
        Assertions.assertEquals("1", command.getTodoItem());
    }
    @Test
    public void should_print_correct_todo_info(){
        ProcessServiceImpl processServiceImpl = new ProcessServiceImpl();
        String value = "name1";
        Item added = processServiceImpl.add(new Item(value));
        List<Item> todoItems = processServiceImpl.getAllItems();
        Assertions.assertEquals(1L, added.getIndex());
        Assertions.assertEquals(value, todoItems.get(0).getName());

        PrintService consoleService = new ConsolePrintServiceImpl();
        consoleService.printTodoItems(todoItems);

    }
    @Test
    public void should_print_correct_done_info(){
        ProcessServiceImpl processServiceImpl = new ProcessServiceImpl();
        String value = "name1";
        processServiceImpl.add(new Item(value));
        long doneIndex = 1L;
        processServiceImpl.done(doneIndex);
        Map<Long, Item> todoItems = processServiceImpl.getAllTodosByKey();
        Assertions.assertEquals(true, todoItems.get(doneIndex).getDoneStatus());
    }

}
