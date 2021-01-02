package com.test.bo;

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
        add("add"), done("done"), list("list")
        , listall("list--all"), loginu("loginu"),logout("logout");

        private final String value;
        CommandEnum(String value) {
            this.value = value;
        }
    }
    public CommandEnum getCommandType() {
        return commandEnumType;
    }
}
