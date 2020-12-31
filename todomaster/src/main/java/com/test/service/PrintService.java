package com.test.service;

import com.test.bo.Item;

import java.util.List;

public interface PrintService {
    void printAdd(Item item);

    void printOneItemDone(long doneIndex);

    void printTodoItems(List<Item> todoItems);

    void printAllItems(List<Item> allItems);
}
