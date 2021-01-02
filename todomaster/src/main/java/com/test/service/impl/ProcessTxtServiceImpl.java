package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.ProcessItemservice;

import java.io.IOException;
import java.util.*;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:34
 */
public class ProcessTxtServiceImpl implements ProcessItemservice {

    TodoJsonFileUtils<Item> todoFieUtils = new TodoJsonFileUtils();

    @Override
    public Item add(final Item item) throws IOException {
        Item lastItem = todoFieUtils.getLastItem();
        Item itemNew = new Item(item.getName());
        itemNew.setIndex(lastItem.getIndex() +1 );
        todoFieUtils.writeNewItem(itemNew);
        return itemNew;
    }

    @Override
    public void done(long doneIndex) throws IOException {
        List<Item> items = todoFieUtils.getAllItems();
        items.stream().filter(item -> item.getIndex() == doneIndex).findFirst().ifPresent(item -> item.setDone());
        todoFieUtils.writeAllItem(items);
    }

    @Override
    public List<Item> getAllItems() throws IOException {
        return  todoFieUtils.getAllItems();
    }
}
