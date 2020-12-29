package com.test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:34
 */
public class TodoListService {
    Map todos = new HashMap<Long,Item>();
    public static Long index = 0L;
    public void add(Item item) {
        todos.put(++index, item);
    }

    public Map<Long,Item> getAllTodo() {
        return todos;
    }
}
