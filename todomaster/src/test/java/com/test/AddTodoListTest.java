package com.test;

import com.test.service.impl.CommandLineInput;
import com.test.service.ICommandLineInputSerivce;
import com.test.bo.Item;
import com.test.service.Command;
import com.test.service.Parse;
import com.test.service.TodoListService;
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
        ICommandLineInputSerivce ICommandLineInputSerivce = new CommandLineInput(null,null);
        Assertions.assertEquals(Command.CommandEnum.ADD, command.getCommandType());
        Assertions.assertEquals("<item>", command.getTodoItem());
    }
    @Test
    public void should_print_correct_info(){
        TodoListService todoListService = new TodoListService();
        String value = "name1";
        todoListService.add(new Item(value));
        List<String> todoItems = todoListService.getAllTodoItems();
        Long lastAddIndex = todoListService.getLastAddIndex();
        Assertions.assertEquals(1L, lastAddIndex);
        Assertions.assertEquals(value, todoItems.get(0));

        PrintService consoleService = new ConsolePrintServiceImpl();
        consoleService.print(todoItems,lastAddIndex);

    }

}
