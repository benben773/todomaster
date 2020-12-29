package com.test.service;

import com.sun.deploy.util.ArrayUtil;
import com.test.service.Command;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/29 7:31
 */
public class Parse {

    public static final String TODO_ADD = "todo add ";

    public Command parseArray(String[] args) {
        if (args == null) {
            return null;
        }
        String strInput = ArrayUtil.arrayToString(args).trim();
        Command command = new Command();
        if (!strInput.startsWith(TODO_ADD) ) {
            return command;
        }
        command.setCommandEnumType(Command.CommandEnum.ADD);
        command.setTodoItem(strInput.replaceAll(TODO_ADD, ""));
        return command;
    }

}
