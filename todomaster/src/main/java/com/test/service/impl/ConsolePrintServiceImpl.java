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
    public void printAdd(Item item) {
        System.out.println("1."+item.getName());
        System.out.println("Item <"+item.getIndex()+"> added");
    }

    @Override
    public void printOneItemDone(long doneIndex) {
        System.out.println("Item "+doneIndex+" done");

    }

    @Override
    public void printTodoItems(List<Item> todoItems) {
        todoItems.stream().forEach(s -> {
            System.out.println(s.getIndex() +"."+s.getName()+"");
        });
        System.out.println("Total: "+todoItems.size()+" items");
    }

    @Override
    public void printAllItems(List<Item> allItems) {
        allItems.forEach(item -> {
            String doneStatus = item.getDone()?"[Done]":"";
            System.out.println(item.getIndex() + "."+doneStatus + item.getName());
        });
        long count = allItems.stream().filter(Item::getDone).count();
        System.out.println("Total: "+allItems.size()+" items," +count +" item done");
    }
}
