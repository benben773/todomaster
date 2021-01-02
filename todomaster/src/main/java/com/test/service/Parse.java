package com.test.service;

import com.test.bo.Command;
import org.apache.commons.lang3.EnumUtils;

import java.util.Arrays;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/29 7:31
 */
public class Parse {

    public static final String paramSubTag = "-";

    public Command parseArray(String[] args) {
        if (args == null) {
            return null;
        }
        String commandName = args[1];
        String param = args.length > 2 ? args[2] : "";
        if (param.startsWith(paramSubTag)) {
            commandName = commandName + param.replaceAll(paramSubTag,"");
        }
        return defineCommand(param, Enum.valueOf(Command.CommandEnum.class,commandName));
    }

    private Command defineCommand(String param, Command.CommandEnum add) {
        Command command = new Command();
        command.setCommandEnumType(add);
        command.setTodoItem(param);
        return command;
    }

}
