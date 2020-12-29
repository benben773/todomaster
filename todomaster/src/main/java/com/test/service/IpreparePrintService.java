package com.test.service;

import com.test.bo.Item;

import java.util.List;

public interface IpreparePrintService {
    List<Item> getAllTodoItems();

    Long getLastAddIndex();
}
