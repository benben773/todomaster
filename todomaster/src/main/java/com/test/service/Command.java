package com.test.service;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/29 7:32
 */
public class Command {
    private String todoItem;

    public String getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(String todoItem) {
        this.todoItem = todoItem;
    }

    public void setCommandEnumType(CommandEnum commandEnumType) {
        this.commandEnumType = commandEnumType;
    }

    private CommandEnum commandEnumType;
    public enum CommandEnum {
        ADD(1,"add"),DONE(2,"done");

        private final int value;
        private final String desc;
        CommandEnum(int value, String desc) {
            this.value = value;
            this.desc = desc;
        }
    }
    public CommandEnum getCommandType() {
        return commandEnumType;
    }
}
