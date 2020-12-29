package com.test.service;

import com.test.bo.Item;

import java.util.*;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:34
 */
public class TodoListService implements IAddService, IpreparePrintService {
    Map<Long, Item> todos = new HashMap<Long,Item>();
    public Long index = 0L;
    public Long lastAddIntex = 0L;
    @Override
    public void add(Item item) {
        todos.put(++index, item);
        lastAddIntex = index;
    }

    @Override
    public void done(long doneIndex) {
        todos.get(doneIndex).setDone();
    }

    public Map<Long,Item> getAllTodos() {
        return todos;
    }

    @Override
    public List<String> getAllTodoItems() {
        final List<String> strAllTodoItems = new ArrayList<String>();
        todos.forEach((k,v)->{
            strAllTodoItems.add(v.getName());});
        return strAllTodoItems;
    }
    @Override
    public Long getLastAddIndex() {
        return lastAddIntex;
    }
}
