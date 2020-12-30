package com.test.service;

import com.sun.deploy.util.ArrayUtil;
import com.test.bo.Command;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/29 7:31
 */
public class Parse {

    public static final String TODO_ADD = "todo add ";
    public static final String TODO_DONE = "todo done ";
    public static final String TODO_LIST = "todo list";

    public Command parseArray(String[] args) {
        if (args == null) {
            return null;
        }
        String strInput = ArrayUtil.arrayToString(args).trim();
        Command command = new Command();
        if (strInput.startsWith(TODO_ADD)) {
            command.setCommandEnumType(Command.CommandEnum.ADD);
            command.setTodoItem(strInput.replaceAll(TODO_ADD, ""));
            return command;
        }else if (strInput.startsWith(TODO_DONE)) {
            command.setCommandEnumType(Command.CommandEnum.DONE);
            command.setTodoItem(strInput.replaceAll(TODO_DONE, ""));
            return command;
        }else if (strInput.startsWith(TODO_LIST)) {
            command.setCommandEnumType(Command.CommandEnum.SHOW_TODOS);
            return command;
        } else {
            return command;
        }
    }

}
