package com.test.service;

import com.test.bo.Command;

import java.util.Arrays;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/29 7:31
 */
public class Parse {

    public static final String TODO_ADD = "add";
    public static final String TODO_DONE = "done";
    public static final String TODO_LIST = "list";

    public Command parseArray(String[] args) {
        if (args == null) {
            return null;
        }
        String strInput = args[1];
        String param = args.length > 2 ? args[2] : "";
        Command command = new Command();
        if (strInput.startsWith(TODO_ADD)) {
            command.setCommandEnumType(Command.CommandEnum.ADD);
            command.setTodoItem(param);
            return command;
        }else if (strInput.startsWith(TODO_DONE)) {
            command.setCommandEnumType(Command.CommandEnum.DONE);
            command.setTodoItem(param);
            return command;
        }else if (strInput.startsWith(TODO_LIST) && param.equals("--all")) {
            command.setCommandEnumType(Command.CommandEnum.SHOW_ALL_ITEM);
            return command;
        }else if (strInput.startsWith(TODO_LIST)) {
            command.setCommandEnumType(Command.CommandEnum.SHOW_TODOS);
            return command;
        } else {
            return command;
        }
    }

}
