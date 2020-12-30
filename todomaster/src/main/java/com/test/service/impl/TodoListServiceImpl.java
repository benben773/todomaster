package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.PorcessItemservice;
import com.test.service.PreparePrintService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:34
 */
public class TodoListServiceImpl implements PorcessItemservice, PreparePrintService {
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
    public List<Item> getAllItems() {
        final List<Item> strAllTodoItems = new ArrayList<Item>();
        todos.forEach((k,v)->{
            strAllTodoItems.add(v);});
        return strAllTodoItems;
    }
    @Override
    public Long getLastAddIndex() {
        return lastAddIntex;
    }

    @Override
    public List<Item> getTodoItems() {
        List<Item> collect = todos.values().stream().filter(o -> {
            return !o.getDoneStatus();
        }).collect(Collectors.toList());
        return collect;
    }
}
