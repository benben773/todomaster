package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.PrintService;

import java.util.List;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/30 2:08
 */
public class ConsolePrintServiceImpl implements PrintService {
    @Override
    public void prinAdd(List<Item> todoItems, Long lastAddIndex) {
        todoItems.stream().forEach(s -> {
            System.out.println(s.getIndex() +"."+s.getName()+"");
        });
        System.out.println("Item "+lastAddIndex+" added");
    }

    @Override
    public void prinDone(long doneIndex) {
        System.out.println("Item "+doneIndex+" done");

    }

    @Override
    public void prinItems(List<Item> todoItems) {
        todoItems.stream().forEach(s -> {
            System.out.println(s.getIndex() +"."+s.getName()+"");
        });
        System.out.println("Total: "+todoItems.size()+"  items");
    }
}
