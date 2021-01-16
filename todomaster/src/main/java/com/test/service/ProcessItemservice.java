package com.test.service;

import com.test.bo.Item;

import java.io.IOException;
import java.util.List;

public interface ProcessItemservice {
    void done(long doneIndex) throws IOException;
    List<Item> getUserItems() throws IOException;

    Item addUserItem(Item item) throws IOException;
}
