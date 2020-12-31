package com.test.service;

import com.test.bo.Item;

import java.util.List;

public interface ProcessItemservice {
    Item add(Item item);
    void done(long doneIndex);
    List<Item> getAllItems();
}
