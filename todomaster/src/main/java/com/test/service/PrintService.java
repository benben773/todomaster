package com.test.service;

import com.test.bo.Item;

import java.util.List;

public interface PrintService {
    void prinAdd(List<Item> todoItems, Long lastAddIndex);

    void prinDone(long doneIndex);

    void prinItems(List<Item> todoItems);
}
