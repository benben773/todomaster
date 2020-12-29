package com.test;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/29 7:31
 */
public class Parse {

    public static final String TODO_ADD = "todo add <";
    public static final String SUFFIX = ">";

    public Command parseArray(String[] args) {
        if (args == null) {
            return null;
        }
        String strInput = ArrayUtil.arrayToString(args).trim();
        if (!strInput.startsWith(TODO_ADD) || !strInput.endsWith(SUFFIX)) {
            return null;
        }
        Command command = new Command();
        command.setCommandEnumType(Command.CommandEnum.ADD);
        command.setTodoItem(strInput.replaceAll(TODO_ADD, "").replaceAll(SUFFIX, ""));
        return command;


    }

}
