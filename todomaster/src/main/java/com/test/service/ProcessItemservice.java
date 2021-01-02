package com.test.service;

import com.test.bo.Item;

import java.io.IOException;
import java.util.List;

public interface ProcessItemservice {
    Item add(Item item) throws IOException;
    void done(long doneIndex) throws IOException;
    List<Item> getAllItems() throws IOException;
}
