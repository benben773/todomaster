package com.test;

import java.util.LinkedList;
import java.util.List;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:34
 */
public class TodoListService {
    LinkedList<Item> list = new LinkedList<Item>();
    public void add(Item item) {
        list.add(item);
    }

    public List<Item> getAllTodo() {
        return list;
    }
}
