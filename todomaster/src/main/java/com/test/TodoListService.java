package com.test;

import java.util.*;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:34
 */
public class TodoListService {
    Map<Long,Item> todos = new HashMap<Long,Item>();
    public static Long index = 0L;
    public static Long lastAddIntex = 0L;
    public void add(Item item) {
        todos.put(++index, item);
        lastAddIntex = index;
    }

    public Map<Long,Item> getAllTodo() {
        return todos;
    }

    public List<String> getAllTodoItems() {
        final List<String> strAllTodoItems = new ArrayList<String>();
        todos.forEach((k,v)->{
            strAllTodoItems.add(v.getName());});
        return strAllTodoItems;
    }

    public Long getLastAddIndex() {
        return lastAddIntex;
    }
}
