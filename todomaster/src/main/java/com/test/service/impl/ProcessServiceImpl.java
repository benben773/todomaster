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

    public static Map<Long, Item> todos = new HashMap<Long, Item>();

    public ProcessServiceImpl() {
    }

    @Override
    public Item add(Item item) {
        long index = todos.keySet().stream().mapToLong(value -> {
            return value.longValue();
        }).max().orElse(0L);
        index++;
        todos.put(index, item);
        item.setIndex(index);
        return item;
    }

    @Override
    public void done(long doneIndex) {
        todos.get(doneIndex).setDone();
    }

    public Map<Long, Item> getAllTodosByKey() {
        return todos;
    }

    @Override
    public List<Item> getAllItems() {
        final List<Item> strAllTodoItems = new ArrayList<Item>();
        todos.forEach((k, v) -> {
            strAllTodoItems.add(v);
        });
        return strAllTodoItems;
    }
}
