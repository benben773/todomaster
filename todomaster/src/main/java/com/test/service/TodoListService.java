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
        item.setIndex(index);
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
    public List<Item> getAllTodoItems() {
        final List<Item> strAllTodoItems = new ArrayList<Item>();
        todos.forEach((k,v)->{
            strAllTodoItems.add(v);});
        return strAllTodoItems;
    }
    @Override
    public Long getLastAddIndex() {
        return lastAddIntex;
    }
}
