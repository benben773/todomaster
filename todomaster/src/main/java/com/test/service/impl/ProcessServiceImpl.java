package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.ProcessItemservice;
import com.test.service.PreparePrintService;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:34
 */
public class ProcessServiceImpl implements ProcessItemservice {

    static Map<Long, Item> todos = new HashMap<Long,Item>();
    static long index = 1L;

    public ProcessServiceImpl() {
        todos = new HashMap<>();
        index = 1L;
    }
    @Override
    public Item add(Item item) {
        todos.put(index, item);
        item.setIndex(index);
        index++;
        return item;
    }

    @Override
    public void done(long doneIndex) {
        todos.get(doneIndex).setDone();
    }

    public Map<Long,Item> getAllTodosByKey() {
        return todos;
    }

    @Override
    public List<Item> getAllItems() {
        final List<Item> strAllTodoItems = new ArrayList<Item>();
        todos.forEach((k,v)->{
            strAllTodoItems.add(v);});
        return strAllTodoItems;
    }
}
