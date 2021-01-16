package com.test.service.impl;

import com.test.bo.Item;
import com.test.service.ProcessItemservice;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ：ls05
 * @date ：Created in 2020/12/28 19:34
 */
public class ProcessTxtServiceImpl implements ProcessItemservice {

    TodoJsonFileUtils<Item> todoFieUtils = new TodoJsonFileUtils();

    @Override
    public void done(long doneIndex) throws IOException {
        List<Item> items = todoFieUtils.getAllItems();
        items.stream().filter(item -> item.getIndex() == doneIndex).findFirst().ifPresent(item -> item.setDone());
        todoFieUtils.writeAllItem(items);
    }

    private List<Item> getAllItems() throws IOException {
        return todoFieUtils.getAllItems();
    }

    @Override
    public List<Item> getUserItems() throws IOException {
        String userIndex = todoFieUtils.getLoginUserIndex();
        return this.getAllItems().stream().filter(item -> item.getUserIndex().equals(userIndex)).collect(Collectors.toList());
    }

    @Override
    public Item addUserItem(final Item item) throws IOException {
        List<Item> items = todoFieUtils.getAllItems();
        String userIndex = todoFieUtils.getLoginUserIndex();
        if (userIndex.equals(TodoJsonFileUtils.ERROR_INDEX)) {
            throw new IllegalAccessError("请先登录");
        }

         long initUserIndex = 1L;
        if (items.size() != 0) {
            initUserIndex = items.stream().map(Item::getIndex).max(Long::compareTo).get();
            initUserIndex++;
        }
        Item itemNew = new Item(item.getName());
        itemNew.setUserIndex(userIndex);
        itemNew.setIndex(initUserIndex);
        todoFieUtils.writeNewItem(itemNew);
        return itemNew;
    }
}
